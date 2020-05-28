package com.myspringbootproject.service;

import java.util.List;
import java.util.NoSuchElementException;
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

	public Optional<Blogger> getBlogger(String identifyer) {
		Optional<Blogger> blogger = null;
		try {
			Long id = Long.parseLong(identifyer);
			blogger = bloggerRepo.findById(id);
		} catch (Exception e) {
			System.out.println("Nem megfelelő formátum!" + e);
		}
		return blogger;
	}
	
	public Optional<Blogger> findBloggerByName(String name) {
		Optional<Blogger> blogger = bloggerRepo.findByName(name);
		return blogger;
	}
	
	public void registerNewBlogger(String name, String email) {
		Blogger newBlogger = new Blogger(name, email);
		bloggerRepo.save(newBlogger);
	}
	
	public void saveNewStory(String title, String content, String bloggerId) {
		Blogger blogger = null;
		try {
			Long id = Long.parseLong(bloggerId);
			//ez dobhat egy NoSuchElementExceptiont!
			blogger = bloggerRepo.findById(id).get();
		} catch (NumberFormatException ex) {
			System.out.println("Nem megfelelő formátumú a blogger id!" + ex);
		} catch (NoSuchElementException ex) {
			System.out.println("Nem találjuk ezt a bloggert!" + ex);
		}
		Story newStory = new Story(title, content, blogger);
		storyRepo.save(newStory);
	}
	
	public Story getFirstStory(Blogger blogger) {
		return storyRepo.findFirstByOrderByLatestUpdatedDesc();
	}

	public Story getSingleStory(String title) {
		storyRepo.findByTitle(title);
		return null;
	}

	
}
