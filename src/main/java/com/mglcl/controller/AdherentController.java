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
@RequestMapping("/adherents/")
public class AdherentController {
	
	  private AdherentService adherentService;
	  
	  @Autowired
	  public AdherentController (AdherentService adherentService) {
		  this.adherentService=adherentService;
	  } 
	    @GetMapping("listes")
	    public String listesAdherents(Model model) {
	    	List<Adherent> listesAdherents = adherentService.getAllAdherents(); 	
	    	model.addAttribute("listesAdherents", listesAdherents);
			return "admin/adherents/listes";
	    }
	    @GetMapping("recherche")
	    public String rechercheAdherent(Model model) {
	        Adherent adherent = new Adherent();
	        model.addAttribute("adherent", adherent);
	        return "admin/adherents/recherche";
	    }
	    @PostMapping("recherche")
	    public String rechercheAdherent(@ModelAttribute Adherent adherent, Model model) {
//	        model.addAttribute("adherent", adherentService.getAdherentById(adherent.getIdAdherent()));
	        model.addAttribute("adherent", adherentService.getAdherentByCin(adherent.getCin()));
	        return "admin/adherents/recherche";
	    }
	    @GetMapping("insertion")
	    public String insertionAdherent(Model model) {
	        Adherent adherent = new Adherent();
	        model.addAttribute("adherent", adherent);
	        return "admin/adherents/insertion";
	    }
	    @PostMapping("insertion")
	    public String insertionAdherent( @Valid @ModelAttribute("adherent") Adherent adherent,  BindingResult bindingResult) {
	    	  if (bindingResult.hasErrors()) {
		            return "admin/adherents/insertion";
		        } 
	    	  else {
			        adherentService.saveAdherent(adherent);
			        return "redirect:/adherents/listes";
		        }
	    }
	    @PostMapping("modification")
	    public String modificationAdherent( @Valid @ModelAttribute("adherent") Adherent adherent,  BindingResult bindingResult) {
	    	  if (bindingResult.hasErrors()) {
		            return "admin/adherents/modification";
		        } 
	    	  else {
			        adherentService.saveAdherent(adherent);
			        return "redirect:/adherents/listes";
		        }
	    }
	    @GetMapping("modification/{idAdherent}")
	    public String modificationAdherent(@PathVariable(value = "idAdherent") int idAdherent, Model model ) {
	    	    Adherent adherent = adherentService.getAdherentById(idAdherent);
		        model.addAttribute("adherent", adherent);
		        return "admin/adherents/modification";
	    	  }
	    
	    @GetMapping("suppression/{idAdherent}")
	    public String suppressionAdherent(@PathVariable(value = "idAdherent") int idAdherent) {
	        this.adherentService.deleteAdherentById(idAdherent);
	        return "redirect:/adherents/listes";
	    }
		
}
