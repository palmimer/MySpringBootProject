package com.myspringbootproject.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myspringbootproject.domain.Story;

//@RestController
@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String stories(Model model, Locale locale) {
		model.addAttribute("pageTitle", "Ez az oldal címe");
		model.addAttribute("stories", getStories());
		//System.out.println(String.format("Request received: Language: s%, Country: s%", locale.getLanguage(), locale.getDisplayCountry()));
		return "stories";
	}
	
		private ArrayList<Story> getStories(){
		ArrayList<Story> stories = new ArrayList<>();
		
		//TODO itt kell beletenni a story-kat a listába
		Story stor1 = new Story();
		stor1.setAuthor("Ubulka");
		stor1.setContent("Elmesélek nektek egy szép történetet. Figyeljetek, hosszú lesz.");
		stor1.setLatestUpdated(new Date());
		stor1.setTitle("Egy szép történet");
		
		Story stor2 = new Story();
		stor2.setAuthor("Gréti");
		stor2.setContent("Az én történetem sokkal érdekesebb! Meglátjátok, ha elolvassátok!");
		stor2.setLatestUpdated(new Date());
		stor2.setTitle("Egy érdekes történet");
		
		stories.add(stor1);
		stories.add(stor2);
		
		return stories;
	}
	
	
	
//	@RequestMapping("/")
//	public String index() {
//		return "Helló, itt a kontroller index oldala!";
//	}
	
}
