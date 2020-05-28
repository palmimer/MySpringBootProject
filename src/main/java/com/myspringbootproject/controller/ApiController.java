package com.myspringbootproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myspringbootproject.domain.Blogger;
import com.myspringbootproject.domain.Story;
import com.myspringbootproject.service.StoryService;

@RestController
public class ApiController {

	private StoryService storyService;
	
	@Autowired
	public void setStoryService(StoryService storyService) {
		this.storyService = storyService;
	}
	
	@RequestMapping("/bloggers")
	public List<Blogger> showBloggers() throws Exception {
		
		return storyService.getAllBloggers();
	}
	
	@RequestMapping("/blogger/{id}/stories")
	public List<Story> getStoriesOfBlogger(@PathVariable(value = "id") String id) throws Exception {
		if(id == null) {
			throw new Exception("Nem kaptunk blogger azonosítót!");
		}
		if(!storyService.getBlogger(id).isPresent()) {
			throw new Exception("Ilyen azonosítójú bloggert nem találtunk!");
		}
		return storyService.getBlogger(id).get().getStories();
	}
	
	@RequestMapping("/blogger/{name}")
	public Blogger getStoriesOfBloggerByName(@PathVariable(value = "name") String name) throws Exception {
		if(name == null) {
			throw new Exception("Nem érkezett blogger név!");
		}
		if(!storyService.findBloggerByName(name).isPresent()) {
			throw new Exception("Ilyen nevű blogger nem létezik!");
		}
		return storyService.findBloggerByName(name).get();
	}

}
