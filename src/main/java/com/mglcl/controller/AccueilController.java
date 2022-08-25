package com.mglcl.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mglcl.services.AdherentService;
import com.mglcl.services.DictionnaireService;
import com.mglcl.services.EmpruntService;
import com.mglcl.services.LivreService;
import com.mglcl.services.RevueService;

@Controller
public class AccueilController {
	  private AdherentService adherentService;
	  private DictionnaireService dictionnaireService;
	  private LivreService livreService;
	  private RevueService revueService;
	  private EmpruntService empruntService;

	  @Autowired
	  public AccueilController(AdherentService adherentService, DictionnaireService dictionnaireService,
				LivreService livreService, RevueService revueService,EmpruntService empruntService) {
			super();
			this.adherentService = adherentService;
			this.dictionnaireService = dictionnaireService;
			this.livreService = livreService;
			this.revueService = revueService;
			this.empruntService=empruntService;
		}
	  @GetMapping({"/","/accueil"})
	    public String accueil(Model model) {
	    	long adherents = adherentService.getAdherentCount(); 	
	    	model.addAttribute("adherents", adherents);
	    	
	    	long dictionnaires = dictionnaireService.getDictionnaireCount(); 	
	    	model.addAttribute("dictionnaires", dictionnaires);
	    	long revues = revueService.getRevueCount(); 	
	    	model.addAttribute("revues", revues);
	    	long livres = livreService.getLivreCount(); 	
	    	model.addAttribute("livres", livres);
	    	long emprunts = empruntService.getEmpruntCount(); 	
	    	model.addAttribute("emprunts", emprunts);	    	
	    	
	    	
	    	
	    	
	    	
			return "accueil";
		}


	 
}
