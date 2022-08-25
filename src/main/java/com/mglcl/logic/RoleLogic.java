package com.mglcl.logic;

import java.util.List;
import java.util.Optional;

import com.mglcl.entities.Role;
import com.mglcl.repository.RoleRepository;
import com.mglcl.services.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Transactional(readOnly = false)
@Service
public class RoleLogic implements RoleService{

	
    private RoleRepository roleRepository;
    
    @Autowired
    public RoleLogic (RoleRepository roleRepository) {
    	this.roleRepository=roleRepository;
    }
    
	@Override
	public List<Role> getAllRoles() {
		return  roleRepository.findAll();
	}

	@Override
	public void saveRole(Role role) {
		roleRepository.save(role)		;
	}

	@Override
	public Role getRoleById(int id) {
        Optional < Role > optional = roleRepository.findById((long) id);
        Role role = null;
        if (optional.isPresent()) {
        	role = optional.get();
        } else {
            throw new RuntimeException(" Rôle introuvable avec cet  id :: " + id);
        }
        return role;
	}

	@Override
	public void deleteRoleById(int id) {
		this.roleRepository.deleteById((long) id);		
	}




}
