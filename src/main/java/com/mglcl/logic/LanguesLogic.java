package com.mglcl.logic;

import java.util.List;
import java.util.Optional;

import com.mglcl.entities.Langue;
import com.mglcl.repository.LangueRepository;
import com.mglcl.services.LanguesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Transactional(readOnly = false)
@Service
public class LanguesLogic implements LanguesService{

	
    private LangueRepository langueRepository;
    
    @Autowired
    public LanguesLogic (LangueRepository langueRepository) {
    	this.langueRepository=langueRepository;
    }
    
	@Override
	public List<Langue> getAllLangues(){
		return  langueRepository.findAll();
	}

	@Override
	public void saveLangue(Langue langue) {
		langueRepository.save(langue)	;
	}

	@Override
	public Langue getLangueById(int idLangue) {
        Optional < Langue > optional = langueRepository.findById(idLangue);
        Langue langue = null;
        if (optional.isPresent()) {
        	langue = optional.get();
        } else {
            throw new RuntimeException(" Langue introuvable avec cet  id :: " + idLangue);
        }
        return langue;
	}

	@Override
	public void deleteLangueById(int idLangue) {
		this.langueRepository.deleteById(idLangue);		
	}




}
