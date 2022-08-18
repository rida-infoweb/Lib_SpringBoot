package com.mglcl.controller;

import java.util.List;

import javax.validation.Valid;

import com.mglcl.entities.Adherent;
import com.mglcl.services.AdherentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/adherents")
public class AdherentController {
	
	  private AdherentService adherentService;
	  @Autowired
	  public AdherentController (AdherentService adherentService) {
		  this.adherentService=adherentService;
	  }  
	    @GetMapping("/")
	    public String listesAdherents(Model model) {
	    	List<Adherent> listesAdherents = adherentService.getAllAdherents(); 	
	    	model.addAttribute("listesAdherents", listesAdherents);
			return "adherents/listesAdherents";
	    }
	    @GetMapping("/trouverAdherent")
	    public String rechercheAdherent(Model model) {
	        Adherent adherent = new Adherent();
	        model.addAttribute("adherent", adherent);
	        return "adherents/rechercheAdherent";
	    }
	    
	    @PostMapping("/rechercheAdherent")
	    public String rechercheAdherent(@ModelAttribute Adherent adherent, Model model) {
	        model.addAttribute("adherent", adherentService.getAdherentById(adherent.getIdAdherent()));
	        return "adherents/rechercheAdherent";
	    }
	    	    
	    @GetMapping("/ajoutAdherent")
	    public String ajoutAdherent(Model model) {
	        Adherent adherent = new Adherent();
	        model.addAttribute("adherent", adherent);
	        return "adherents/ajoutAdherent";
	    }
	    
	    @PostMapping("/insertionAdherent")
	    public String insertionAdherent( @Valid @ModelAttribute("adherent") Adherent adherent,  BindingResult bindingResult) {
	    	  if (bindingResult.hasErrors()) {
		            return "adherents/ajoutAdherent";
		        } 
	    	  else {
			        adherentService.saveAdherent(adherent);
			        return "redirect:/adherents/";
		        }
	    }
	    
	    @PostMapping("/modificationAdherent")
	    public String modificationAdherent( @Valid @ModelAttribute("adherent") Adherent adherent,  BindingResult bindingResult) {
	    	  if (bindingResult.hasErrors()) {
		            return "adherents/modificationAdherent";
		        } 
	    	  else {
			        adherentService.saveAdherent(adherent);
			        return "redirect:/adherents/";
		        }
	    }

	    @GetMapping("/modificationAdherent/{idAdherent}")
	    public String modificationAdherent(@PathVariable(value = "idAdherent") int idAdherent, Model model ) {
	    	    Adherent adherent = adherentService.getAdherentById(idAdherent);
		        model.addAttribute("adherent", adherent);
		        return "adherents/modificationAdherent";
	    	  }
	    

	    @GetMapping("/suppressionAdherent/{idAdherent}")
	    public String suppressionAdherent(@PathVariable(value = "idAdherent") int idAdherent) {
	        this.adherentService.deleteAdherentById(idAdherent);
	        return "redirect:/adherents/";
	    }
		
}
