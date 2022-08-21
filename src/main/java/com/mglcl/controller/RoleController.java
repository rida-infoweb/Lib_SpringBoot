package com.mglcl.controller;

import java.util.List;

import javax.validation.Valid;

import com.mglcl.entities.Role;
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
@RequestMapping("/roles/")
public class RoleController {
	
	  private RoleService roleService;
	  
	  @Autowired
	  public RoleController (RoleService roleService) {
		  this.roleService=roleService;
	  } 
	    @GetMapping("listes")
	    public String listesRoles(Model model) {
	    	List<Role> listesRoles = roleService.getAllRoles(); 	
	    	model.addAttribute("listesRoles", listesRoles);
			return "admin/roles/listes";
	    }

	    @GetMapping("insertion")
	    public String insertionRole(Model model) {
	        Role role = new Role();
	        model.addAttribute("role", role);
	        return "admin/roles/insertion";
	    }
	    @PostMapping("insertion")
	    public String insertionRole( @Valid @ModelAttribute("role") Role role,  BindingResult bindingResult) {
	    	  if (bindingResult.hasErrors()) {
		            return "admin/roles/insertion";
		        } 
	    	  else {
			        roleService.saveRole(role);
			        return "redirect:/roles/listes";
		        }
	    }
	    @PostMapping("modification")
	    public String modificationRole( @Valid @ModelAttribute("role") Role role,  BindingResult bindingResult) {
	    	  if (bindingResult.hasErrors()) {
		            return "admin/roles/modification";
		        } 
	    	  else {
			        roleService.saveRole(role);
			        return "redirect:/roles/listes";
		        }
	    }
	    @GetMapping("modification/{id}")
	    public String modificationRole(@PathVariable(value = "id") int id, Model model ) {
	    	    Role role = roleService.getRoleById(id);
		        model.addAttribute("role", role);
		        return "admin/roles/modification";
	    	  }
	    
	    @GetMapping("suppression/{id}")
	    public String suppressionRole(@PathVariable(value = "id") int id) {
	        this.roleService.deleteRoleById(id);
	        return "redirect:/roles/listes";
	    }
		
}
