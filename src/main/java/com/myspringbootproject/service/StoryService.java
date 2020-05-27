package com.myspringbootproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspringbootproject.domain.Blogger;
import com.myspringbootproject.domain.Story;
import com.myspringbootproject.repository.BloggerRepository;
import com.myspringbootproject.repository.StoryRepository;

@Service
public class StoryService {
	
	private StoryRepository storyRepo;
	
	private BloggerRepository bloggerRepo;

	@Autowired
	public void setStoryRepo(StoryRepository storyRepo) {
		this.storyRepo = storyRepo;
	}

	@Autowired
	public void setBloggerRepo(BloggerRepository bloggerRepo) {
		this.bloggerRepo = bloggerRepo;
	}

	public List<Story> getAllStories(){
		//TODO itt kell beletenni a story-kat a listába
		List<Story> stories = storyRepo.findAll();
		return stories;
//		//ez lenne, ha nem írnánk felül a függvényt a repo-ban, hogy List-et adjon vissza:
//		Iterable<Story> storiesIt = storyService.storyRepo.findAll();
//		//az iterable lista beletöltése az arraylistbe (nem szép megoldás!)
//		java.util.Iterator<Story> it = storiesIt.iterator();
//		while (it.hasNext()) 
//			stories.add(it.next());
		
	}

	public List<Blogger> getAllBloggers() throws Exception{
		
		List<Blogger> bloggers = bloggerRepo.findAll();
		if(bloggers == null || bloggers.isEmpty()) {
			throw new Exception("Egy blogger sincs!");
		}
		return bloggers;
	}

	public Optional<Blogger> findBlogger(String identifyer) {
		Long id = Long.parseLong(identifyer);
		Optional<Blogger> blogger = bloggerRepo.findById(id);
		return blogger;
	}
	
	public void registerNewBlogger(String name, String email) {
		Blogger newBlogger = new Blogger(name, email);
		bloggerRepo.save(newBlogger);
	}
	
	public void saveNewStory(String title, String content, String bloggerId) {
		Long id = Long.parseLong(bloggerId);
		//ez dobhat egy NoSuchElementExceptiont!
		Blogger blogger = bloggerRepo.findById(id).get();
		
		Story newStory = new Story(title, content, blogger);
		storyRepo.save(newStory);
	}
	
	public Story getFirstStory(Blogger blogger) {
		
		return storyRepo.findFirstByOrderByLatestUpdatedDesc();
	}
}
