package com.mglcl.logic;

import java.util.List;
import java.util.Optional;

import com.mglcl.entities.User;
import com.mglcl.repository.UtilisateurRepository;
import com.mglcl.services.UtilisateurService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Transactional(readOnly = false)
@Service
public class UtilisateurLogic implements UtilisateurService{

	
    private UtilisateurRepository utilisateurRepository ;
    
    @Autowired
    public UtilisateurLogic (UtilisateurRepository utilisateurRepository) {
    	this.utilisateurRepository=utilisateurRepository;
    }
    
	@Override
	public List<User> getAllUsers() {
		return  utilisateurRepository.findAll();
	}

	@Override
	public void saveUser(User user) {
		utilisateurRepository.save(user)		;
	}

	@Override
	public void deleteUserById(int id) {
		utilisateurRepository.deleteById((long) id);		
	}

	@Override
	public User getUserById(int id) {
        Optional < User > optional = utilisateurRepository.findById((long) id);
        User utilisateur = null;
        if (optional.isPresent()) {
        	utilisateur = optional.get();
        } else {
            throw new RuntimeException(" Utilisateur introuvable avec cet  id :: " + id);
        }
        return utilisateur;
	}


}
