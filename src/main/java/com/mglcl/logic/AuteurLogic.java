package com.mglcl.logic;

import java.util.List;
import java.util.Optional;

import com.mglcl.entities.Auteur;
import com.mglcl.repository.AuteurRepository;
import com.mglcl.services.AuteurService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Transactional(readOnly = false)
@Service
public class AuteurLogic implements AuteurService{

	
    private AuteurRepository auteurRepository;
    
    @Autowired
    public AuteurLogic (AuteurRepository auteurRepository) {
    	this.auteurRepository=auteurRepository;
    }
    
	@Override
	public List<Auteur> getAllAuteurs(){
		return  auteurRepository.findAll();
	}

	@Override
	public void saveAuteur(Auteur auteur) {
		auteurRepository.save(auteur)	;
	}

	@Override
	public Auteur getAuteurById(int idAuteur) {
        Optional < Auteur > optional = auteurRepository.findById(idAuteur);
        Auteur auteur = null;
        if (optional.isPresent()) {
        	auteur = optional.get();
        } else {
            throw new RuntimeException(" Auteur introuvable avec cet  id :: " + idAuteur);
        }
        return auteur;
	}

	@Override
	public void deleteAuteurById(int idAuteur) {
		this.auteurRepository.deleteById(idAuteur);		
	}




}
