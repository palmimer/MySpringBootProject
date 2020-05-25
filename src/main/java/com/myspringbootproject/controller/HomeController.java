package com.myspringbootproject.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	//ha el akarunk kapni bármilyen /user/ kezdetű és dinamikus, tehát előre nem tudott adatot
	//hogyan tudjuk a hibákat elirányítani egy bizonyos oldalra? Létrehozunk egy függvényt a hibakezelésre
	@RequestMapping("/user/{id}")
	public String searchForUsers(@PathVariable(value = "id") String id, Model model) throws Exception {
		if(id == null) {
			throw new Exception("Ilyen azonosítójú felhasználó nem létezik!");
		}
		return "user";
	}
	
	@ExceptionHandler
	private String handleException(HttpServletRequest request, Exception ex, Model model) {
		model.addAttribute("errMessage", ex.getMessage());
		return "exceptionHandler";
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
