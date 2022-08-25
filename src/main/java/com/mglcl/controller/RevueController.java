package com.mglcl.controller;

import java.util.List;

import javax.validation.Valid;

import com.mglcl.entities.Langue;
import com.mglcl.entities.Revue;
import com.mglcl.entities.Role;
import com.mglcl.services.AuteurService;
import com.mglcl.services.LanguesService;
import com.mglcl.services.RevueService;
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
@RequestMapping("/revues/")
public class RevueController {
	
	  private RevueService revueService;
	  
	  @Autowired
	  public RevueController (RevueService revueService) {
		  this.revueService=revueService;
	  } 
	    @GetMapping("listes")
	    public String listesRevues(Model model) {
	    	List<Revue> listesRevues = revueService.getAllRevues(); 	
	    	model.addAttribute("listesRevues", listesRevues);
			return "admin/revues/listes";
	    }

	    @GetMapping("insertion")
	    public String insertionRevue(Model model) {
	    	Revue revue = new Revue();
	        model.addAttribute("revue", revue);
	        return "admin/revues/insertion";
	    }
	    @PostMapping("insertion")
	    public String insertionRevue( @Valid @ModelAttribute("revue") Revue revue,  BindingResult bindingResult) {
	    	  if (bindingResult.hasErrors()) {
		            return "admin/revues/insertion";
		        } 
	    	  else {
	    		  revueService.saveRevue(revue);
			        return "redirect:/revues/listes";
		        }
	    }
	    @PostMapping("modification")
	    public String modificationRevue( @Valid @ModelAttribute("revue") Revue revue,  BindingResult bindingResult) {
	    	  if (bindingResult.hasErrors()) {
		            return "admin/revues/modification";
		        } 
	    	  else {
	    		  revueService.saveRevue(revue);
			        return "redirect:/revues/listes";
		        }
	    }
	    @GetMapping("modification/{idRevue}")
	    public String modificationRevue(@PathVariable(value = "idRevue") int idRevue, Model model ) {
	    	Revue revue = revueService.getRevueById(idRevue);
		        model.addAttribute("revue", revue);
		        return "admin/revues/modification";
	    	  }
	    
	    @GetMapping("suppression/{idRevue}")
	    public String suppressionRevue(@PathVariable(value = "idRevue") int idRevue) {
	        this.revueService.deleteRevueById(idRevue);
	        return "redirect:/revues/listes";
	    }
		
}
