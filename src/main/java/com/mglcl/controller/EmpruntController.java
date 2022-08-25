package com.mglcl.controller;

import java.util.List;

import javax.validation.Valid;

import com.mglcl.entities.Adherent;
import com.mglcl.entities.Dictionnaire;
import com.mglcl.entities.Emprunt;
import com.mglcl.entities.Langue;
import com.mglcl.entities.Livre;
import com.mglcl.entities.Revue;
import com.mglcl.services.AdherentService;
import com.mglcl.services.DictionnaireService;
import com.mglcl.services.EmpruntService;
import com.mglcl.services.LanguesService;
import com.mglcl.services.LivreService;
import com.mglcl.services.RevueService;

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
@RequestMapping("/emprunts/")
public class EmpruntController {
	
	  private EmpruntService empruntService;
	  
	  @Autowired
	  private DictionnaireService dictionnaireService;
	  @Autowired
	  private RevueService revueService;	  
	  @Autowired
	  private LivreService livreService;	  
	  @Autowired
	  private AdherentService adherentService;
	  
	  @Autowired
	  public EmpruntController (EmpruntService empruntService) {
		  this.empruntService=empruntService;
	  } 
	    @GetMapping("listes")
	    public String listesEmprunts(Model model) {
	    	List<Emprunt> listesEmprunts = empruntService.getAllEmprunts(); 	
	    	model.addAttribute("listesEmprunts", listesEmprunts);
			return "admin/emprunts/listes";
	    }
	  
	    @GetMapping("insertion")
	    public String insertionEmprunt(Model model) {
	    	Emprunt emprunt = new Emprunt();
	    	List<Dictionnaire> dictionnaires =dictionnaireService.getAllDictionnaires();
	    	List<Revue> revues =revueService.getAllRevues();
	    	List<Livre> livres =livreService.getAllLivres();
	    	List<Adherent> adherents =adherentService.getAllAdherents();
	        model.addAttribute("emprunt", emprunt);
	        model.addAttribute("dictionnaires", dictionnaires);
	        model.addAttribute("revues", revues);
	        model.addAttribute("livres", livres);
	        model.addAttribute("adherents", adherents);

	        return "admin/emprunts/insertion";
	    }
	    @PostMapping("insertion")
	    public String insertionEmprunt( @Valid @ModelAttribute("emprunt") Emprunt emprunt,  BindingResult bindingResult) {
	    	  if (bindingResult.hasErrors()) {
		            return "admin/emprunts/insertion";
		        } 
	    	  else {
	    		  empruntService.saveEmprunt(emprunt);
			        return "redirect:/emprunts/listes";
		        }
	    }
	    @PostMapping("modification")
	    public String modificationEmprunt( @Valid @ModelAttribute("emprunt") Emprunt emprunt,  BindingResult bindingResult) {
	    	  if (bindingResult.hasErrors()) {
		            return "admin/emprunts/modification";
		        } 
	    	  else {
	    		  empruntService.saveEmprunt(emprunt);
			        return "redirect:/emprunts/listes";
		        }
	    }
	    @GetMapping("modification/{idEmprunt}")
	    public String modificationEmprunt(@PathVariable(value = "idEmprunt") int idEmprunt, Model model ) {	    	
	    	
	    	Emprunt emprunt = empruntService.getEmpruntById(idEmprunt);
	    	List<Dictionnaire> dictionnaires =dictionnaireService.getAllDictionnaires();
	    	List<Revue> revues =revueService.getAllRevues();
	    	List<Livre> livres =livreService.getAllLivres();
	    	List<Adherent> adherents =adherentService.getAllAdherents();
	        model.addAttribute("emprunt", emprunt);
	        model.addAttribute("dictionnaires", dictionnaires);
	        model.addAttribute("revues", revues);
	        model.addAttribute("livres", livres);
	        model.addAttribute("adherents", adherents);
		        return "admin/emprunts/modification";
	    	  }
	    
	    @GetMapping("suppression/{idEmprunt}")
	    public String suppressionEmprunt(@PathVariable(value = "idEmprunt") int idEmprunt) {
	        this.dictionnaireService.deleteDictionnaireById(idEmprunt);
	        return "redirect:/emprunts/listes";
	    }
		
}
