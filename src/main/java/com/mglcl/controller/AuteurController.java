package com.mglcl.controller;

import java.util.List;

import javax.validation.Valid;

import com.mglcl.entities.Auteur;
import com.mglcl.services.AuteurService;

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
@RequestMapping("/auteurs/")
public class AuteurController {
	
	  private AuteurService auteurService;
	  
	  @Autowired
	  public AuteurController (AuteurService auteurService) {
		  this.auteurService=auteurService;
	  } 
	    @GetMapping("listes")
	    public String listesAuteurs(Model model) {
	    	List<Auteur> listesAuteurs = auteurService.getAllAuteurs(); 	
	    	model.addAttribute("listesAuteurs", listesAuteurs);
			return "admin/auteurs/listes";
	    }

	    @GetMapping("insertion")
	    public String insertionAuteur(Model model) {
	        Auteur auteur = new Auteur();
	        model.addAttribute("auTeur", auteur);
	        return "admin/auteurs/insertion";
	    }
	    @PostMapping("insertion")
	    public String insertionAuteur( @Valid @ModelAttribute("auTeur") Auteur auteur,  BindingResult bindingResult) {
	    	  if (bindingResult.hasErrors()) {
		            return "admin/auteurs/insertion";
		        } 
	    	  else {
			        auteurService.saveAuteur(auteur);
			        return "redirect:/auteurs/listes";
		        }
	    }
	    @PostMapping("modification")
	    public String modificationAuteur( @Valid @ModelAttribute("auTeur") Auteur auteur,  BindingResult bindingResult) {
	    	  if (bindingResult.hasErrors()) {
		            return "admin/auteurs/modification";
		        } 
	    	  else {
	    		  auteurService.saveAuteur(auteur);
			        return "redirect:/auteurs/listes";
		        }
	    }
	    @GetMapping("modification/{idAuteur}")
	    public String modificationAuteur(@PathVariable(value = "idAuteur") int idAuteur, Model model ) {
	    	Auteur auteur = auteurService.getAuteurById(idAuteur);
		        model.addAttribute("auTeur", auteur);
		        return "admin/auteurs/modification";
	    	  }
	    
	    @GetMapping("suppression/{idAuteur}")
	    public String suppressionAuteur(@PathVariable(value = "idAuteur") int idAuteur) {
	        this.auteurService.deleteAuteurById(idAuteur);
	        return "redirect:/auteurs/listes";
	    }
		
}
