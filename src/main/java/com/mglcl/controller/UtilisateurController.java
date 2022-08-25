package com.mglcl.controller;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import com.mglcl.entities.Adherent;
import com.mglcl.entities.Role;
import com.mglcl.entities.User;
import com.mglcl.services.AdherentService;
import com.mglcl.services.RoleService;
import com.mglcl.services.UtilisateurService;

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
@RequestMapping("/utilisateurs/")
public class UtilisateurController {
	
	  private UtilisateurService utilisateurService;
	  
	  @Autowired
	  private RoleService roleService;
	  @Autowired
	  private AdherentService adherentService;	  
	  @Autowired
	  public UtilisateurController (UtilisateurService utilisateurService) {
		  this.utilisateurService=utilisateurService;
	  } 
	    @GetMapping("listes")
	    public String listesUtilisateurs(Model model) {
	    	List<User> listesUtilisateurs = utilisateurService.getAllUsers(); 	
	    	model.addAttribute("listesUtilisateurs", listesUtilisateurs);
			return "admin/utilisateurs/listes";
	    }
	  

	    @PostMapping("modification")
	    public String modificationUtilisateur( @Valid @ModelAttribute("utilisateur") User utilisateur,  BindingResult bindingResult) {
	    	  if (bindingResult.hasErrors()) {
		            return "admin/utilisateurs/modification";
		        } 
	    	  else {
	    		  utilisateurService.saveUser(utilisateur);
			        return "redirect:/utilisateurs/listes";
		        }
	    }
	    @GetMapping("modification/{id}")
	    public String modificationUtilisateur(@PathVariable(value = "id") int id, Model model ) {
	    	User utilisateur = utilisateurService.getUserById(id);
	    	List<Role> roles =roleService.getAllRoles();
	    	List<Adherent> adherents = adherentService.getAllAdherents(); 	

		        model.addAttribute("utilisateur", utilisateur);
		        model.addAttribute("roles", roles);
		        model.addAttribute("adherents", adherents);

		        return "admin/utilisateurs/modification";
	    	  }
	    
	    @GetMapping("suppression/{id}")
	    public String suppressionUtilisateur(@PathVariable(value = "id") int id) {
	        this.utilisateurService.deleteUserById(id);
	        return "redirect:/utilisateurs/listes";
	    }
		
}
