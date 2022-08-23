package com.mglcl.controller;

import java.util.List;

import javax.validation.Valid;

import com.mglcl.entities.Dictionnaire;
import com.mglcl.entities.Langue;
import com.mglcl.services.DictionnaireService;
import com.mglcl.services.LanguesService;

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
@RequestMapping("/dictionnaires/")
public class DictionnaireController {
	
	  private DictionnaireService dictionnaireService;
	  
	  @Autowired
	  private LanguesService languesService;

	  
	  @Autowired
	  public DictionnaireController (DictionnaireService dictionnaireService) {
		  this.dictionnaireService=dictionnaireService;
	  } 
	    @GetMapping("listes")
	    public String listesDictionnaires(Model model) {
	    	List<Dictionnaire> listesDictionnaires = dictionnaireService.getAllDictionnaires(); 	
	    	model.addAttribute("listesDictionnaires", listesDictionnaires);
			return "admin/dictionnaires/listes";
	    }
	  
	    @GetMapping("insertion")
	    public String insertionDictionnaire(Model model) {
	    	Dictionnaire dictionnaire = new Dictionnaire();
	    	List<Langue> langues =languesService.getAllLangues();
	        model.addAttribute("dictionnaire", dictionnaire);
	        model.addAttribute("langues", langues);

	        return "admin/dictionnaires/insertion";
	    }
	    @PostMapping("insertion")
	    public String insertionDictionnaire( @Valid @ModelAttribute("dictionnaire") Dictionnaire dictionnaire,  BindingResult bindingResult) {
	    	  if (bindingResult.hasErrors()) {
		            return "admin/dictionnaires/insertion";
		        } 
	    	  else {
	    		  dictionnaireService.saveDictionnaire(dictionnaire);
			        return "redirect:/dictionnaires/listes";
		        }
	    }
	    @PostMapping("modification")
	    public String modificationDictionnaire( @Valid @ModelAttribute("dictionnaire") Dictionnaire dictionnaire,  BindingResult bindingResult) {
	    	  if (bindingResult.hasErrors()) {
		            return "admin/dictionnaires/modification";
		        } 
	    	  else {
	    		  dictionnaireService.saveDictionnaire(dictionnaire);
			        return "redirect:/dictionnaires/listes";
		        }
	    }
	    @GetMapping("modification/{idDictionnaire}")
	    public String modificationDictionnaire(@PathVariable(value = "idDictionnaire") int idDictionnaire, Model model ) {	    	
	    	
	    	Dictionnaire dictionnaire = dictionnaireService.getDictionnaireById(idDictionnaire);

	    	List<Langue> langues =languesService.getAllLangues();
	        model.addAttribute("dictionnaire", dictionnaire);	      
		        model.addAttribute("langues", langues);
		        return "admin/dictionnaires/modification";
	    	  }
	    
	    @GetMapping("suppression/{idDictionnaire}")
	    public String suppressionDictionnaire(@PathVariable(value = "idDictionnaire") int idDictionnaire) {
	        this.dictionnaireService.deleteDictionnaireById(idDictionnaire);
	        return "redirect:/dictionnaires/listes";
	    }
		
}
