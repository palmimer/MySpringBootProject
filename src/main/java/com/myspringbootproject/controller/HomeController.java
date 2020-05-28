package com.myspringbootproject.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myspringbootproject.domain.Blogger;
import com.myspringbootproject.domain.Story;
import com.myspringbootproject.repository.StoryRepository;
import com.myspringbootproject.service.StoryService;

//@RestController (ez akkor kell, ha csak adatot adunk vissza) 
//A @Controller VIEW-t ad vissza
@Controller
public class HomeController {
	
	private StoryService storyService;
	
	@Autowired
	public void setStoryService(StoryService storyService) {
		this.storyService = storyService;
	}


	@RequestMapping("/")
	public String stories(Model model, Locale locale) {
		model.addAttribute("pageTitle", "Ez az oldal címe");
		model.addAttribute("stories", storyService.getAllStories());
		//System.out.println(String.format("Request received: Language: s%, Country: s%", locale.getLanguage(), locale.getDisplayCountry()));
		return "stories";
	}
	
	
//	@RequestMapping("/bloggers")
//	public String showBloggers(Model model) throws Exception {
//		
//		model.addAttribute("bloggers", storyService.getAllBloggers());
//		model.addAttribute("numberOfBloggers", storyService.getAllBloggers().size());
//		return "bloggers";
//	}
	
	//ha el akarunk kapni bármilyen /blogger/ kezdetű és dinamikus, tehát előre nem tudott adatot
	//hogyan tudjuk a hibákat elirányítani egy bizonyos oldalra? Létrehozunk egy függvényt a hibakezelésre
	
//	@RequestMapping("/blogger/{id}")
//	public String showBloggerPage(@PathVariable(value = "id") String id, Model model) throws Exception {
//		if(id == null) {
//			throw new Exception("Ilyen azonosítójú blogger nem létezik!");
//		}
//		model.addAttribute("blogger", storyService.findBlogger(id));
//		return "bloggerpage";
//	}
	
	@RequestMapping("/story/{title}")
	public String showStoryPage(@PathVariable(value = "title") String title, Model model) throws Exception {
		if(title == null) {
			throw new Exception("Ilyen azonosítójú story nem létezik!");
		}
		model.addAttribute("story", storyService.getSingleStory(title));
		return "story";
	}
	
	@ExceptionHandler
	public String handleException(HttpServletRequest request, Exception ex, Model model) {
		model.addAttribute("errMessage", ex.getMessage());
		return "exceptionHandler";
	}
	
	@RequestMapping("/registration")
	public String newRegistration(HttpServletRequest request) {
		
		return "confirmRegistration";
	}
	
	
	
//	@RequestMapping("/")
//	public String index() {
//		return "Helló, itt a kontroller index oldala!";
//	}
	
//	Story stor1 = new Story();
//	stor1.setAuthor("Ubulka");
//	stor1.setContent("Elmesélek nektek egy szép történetet. Figyeljetek, hosszú lesz.");
//	stor1.setLatestUpdated(new Date());
//	stor1.setTitle("Egy szép történet");
//	
//	Story stor2 = new Story();
//	stor2.setAuthor("Gréti");
//	stor2.setContent("Az én történetem sokkal érdekesebb! Meglátjátok, ha elolvassátok!");
//	stor2.setLatestUpdated(new Date());
//	stor2.setTitle("Egy érdekes történet");
//	
//	stories.add(stor1);
//	stories.add(stor2);
}
