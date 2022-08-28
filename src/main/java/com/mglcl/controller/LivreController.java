package com.mglcl.controller;

import java.util.List;

import javax.validation.Valid;

import com.mglcl.entities.Livre;
import com.mglcl.entities.Auteur;
import com.mglcl.entities.Dictionnaire;
import com.mglcl.services.AuteurService;
import com.mglcl.services.DictionnaireService;
import com.mglcl.services.LanguesService;
import com.mglcl.services.LivreService;

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
@RequestMapping("/livres/")
public class LivreController {
	
	  private LivreService livreService;
	  
	  @Autowired
	  private AuteurService auteurService;

	  
	  @Autowired
	  public LivreController (LivreService livreService) {
		  this.livreService=livreService;
	  } 
	    @GetMapping("listes")
	    public String listesLivres(Model model) {
	    	List<Livre> listesLivres = livreService.getAllLivres(); 	
	    	model.addAttribute("listesLivres", listesLivres);
			return "admin/livres/listes";
	    }
	    @GetMapping("/recherche")
	    public String rechercheLivre(Model model) {
	    	Livre livre = new Livre();
	    	model.addAttribute("livre", livre);
	        return "admin/livres/recherche";
	    }
	    @PostMapping("/recherche")
	    public String rechercheLivre(@ModelAttribute Livre livre, Model model) {
	        model.addAttribute("livre", livreService.getLivreById(livre.getIdLivre()));
	        return "admin/livres/recherche";
	    }
	    @GetMapping("insertion")
	    public String insertionLivre(Model model) {
	    	Livre livre = new Livre();
	    	List<Auteur> auteurs =auteurService.getAllAuteurs();
	        model.addAttribute("livre", livre);
	        model.addAttribute("auteurs", auteurs);

	        return "admin/livres/insertion";
	    }
	    @PostMapping("insertion")
	    public String insertionLivre( @Valid @ModelAttribute("livre") Livre livre,  BindingResult bindingResult) {
	    	  if (bindingResult.hasErrors()) {
		            return "admin/livres/insertion";
		        } 
	    	  else {
	    		  livreService.saveLivre(livre);
			        return "redirect:/livres/listes";
		        }
	    }
	    @PostMapping("modification")
	    public String modificationLivre( @Valid @ModelAttribute("livre") Livre livre,  BindingResult bindingResult) {
	    	  if (bindingResult.hasErrors()) {
		            return "admin/livres/modification";
		        } 
	    	  else {
	    		  livreService.saveLivre(livre);
			        return "redirect:/livres/listes";
		        }
	    }
	    @GetMapping("modification/{idLivre}")
	    public String modificationLivre(@PathVariable(value = "idLivre") int idLivre, Model model ) {	    	
	    	
	    	Livre livre = livreService.getLivreById(idLivre);

	    	List<Auteur> auteurs =auteurService.getAllAuteurs();
	        model.addAttribute("livre", livre);	      
		        model.addAttribute("auteurs", auteurs);
		        return "admin/livres/modification";
	    	  }
	    
	    @GetMapping("suppression/{idLivre}")
	    public String suppressionLivre(@PathVariable(value = "idLivre") int idLivre) {
	        this.livreService.deleteLivreById(idLivre);
	        return "redirect:/livres/listes";
	    }
		
}
