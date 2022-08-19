package com.mglcl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.mglcl.entities.Adherent;
import com.mglcl.services.AdherentService;

@Controller
public class AccueilController {
	  private AdherentService adherentService;
	  @Autowired
	  public AccueilController (AdherentService adherentService) {
		  this.adherentService=adherentService;
	  }	    @GetMapping("/")
	    public String accueil(Model model) {
	    	long adherents = adherentService.getAdherentCount(); 	
	    	model.addAttribute("adherents", adherents);
			return "accueil";
		}
	 
}
