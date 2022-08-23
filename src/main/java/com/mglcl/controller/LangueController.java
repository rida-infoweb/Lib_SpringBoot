package com.mglcl.controller;

import java.util.List;

import javax.validation.Valid;

import com.mglcl.entities.Langue;
import com.mglcl.entities.Role;
import com.mglcl.services.AuteurService;
import com.mglcl.services.LanguesService;
import com.mglcl.services.RoleService;

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
@RequestMapping("/langues/")
public class LangueController {
	
	  private LanguesService languesService;
	  
	  @Autowired
	  public LangueController (LanguesService languesService) {
		  this.languesService=languesService;
	  } 
	    @GetMapping("listes")
	    public String listesLangues(Model model) {
	    	List<Langue> listesLangues = languesService.getAllLangues(); 	
	    	model.addAttribute("listesLangues", listesLangues);
			return "admin/langues/listes";
	    }

	    @GetMapping("insertion")
	    public String insertionLangue(Model model) {
	    	Langue lAngue = new Langue();
	        model.addAttribute("lAngue", lAngue);
	        return "admin/langues/insertion";
	    }
	    @PostMapping("insertion")
	    public String insertionLangue( @Valid @ModelAttribute("lAngue") Langue lAngue,  BindingResult bindingResult) {
	    	  if (bindingResult.hasErrors()) {
		            return "admin/langues/insertion";
		        } 
	    	  else {
	    		  languesService.saveLangue(lAngue);
			        return "redirect:/langues/listes";
		        }
	    }
	    @PostMapping("modification")
	    public String modificationLangue( @Valid @ModelAttribute("lAngue") Langue lAngue,  BindingResult bindingResult) {
	    	  if (bindingResult.hasErrors()) {
		            return "admin/langues/modification";
		        } 
	    	  else {
	    		  languesService.saveLangue(lAngue);
			        return "redirect:/langues/listes";
		        }
	    }
	    @GetMapping("modification/{idLangue}")
	    public String modificationLangue(@PathVariable(value = "idLangue") int idLangue, Model model ) {
	    	Langue lAngue = languesService.getLangueById(idLangue);
		        model.addAttribute("lAngue", lAngue);
		        return "admin/langues/modification";
	    	  }
	    
	    @GetMapping("suppression/{idLangue}")
	    public String suppressionRole(@PathVariable(value = "idLangue") int idLangue) {
	        this.languesService.deleteLangueById(idLangue);
	        return "redirect:/langues/listes";
	    }
		
}
