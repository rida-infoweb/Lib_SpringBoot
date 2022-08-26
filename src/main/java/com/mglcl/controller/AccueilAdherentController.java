package com.mglcl.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mglcl.entities.Adherent;
import com.mglcl.entities.Emprunt;
import com.mglcl.entities.User;
import com.mglcl.services.AdherentService;
import com.mglcl.services.EmpruntService;
import com.mglcl.services.UserService;

@Controller
public class AccueilAdherentController {

	  private EmpruntService empruntService;
	  private UserService userService;
	  private AdherentService adherentService;

	  @Autowired
	  public AccueilAdherentController(EmpruntService empruntService, UserService userService,AdherentService adherentService ) {
			super();
			this.empruntService=empruntService;
			this.userService=userService;
			this.adherentService=adherentService;
		}
	  @GetMapping({"/adherent"})
	    public String accueil(Model model) {
		  
		    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		    String username = auth.getName();
		    User user = userService.findByUsername(username);
		   Adherent adherent = adherentService.getAdherentById(user.getAdherent().getIdAdherent());
	    	List<Emprunt> listesEmprunts = empruntService.getEmpruntByAdherent(user.getAdherent()); 	
	    	model.addAttribute("listesEmprunts", listesEmprunts);	   
	    	model.addAttribute("adherent", adherent);	   

			return "accueilAdherent";
		}


	 
}
