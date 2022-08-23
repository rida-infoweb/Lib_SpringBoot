package com.mglcl.logic;

import java.util.List;
import java.util.Optional;

import com.mglcl.entities.Adherent;
import com.mglcl.entities.Dictionnaire;
import com.mglcl.repository.AdherentRepository;
import com.mglcl.repository.DictionnaireRepository;
import com.mglcl.services.AdherentService;
import com.mglcl.services.DictionnaireService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Transactional
@Service
public class DictionnaireLogic implements DictionnaireService{

	
    private DictionnaireRepository dictionnaireRepository;
    
    @Autowired
    public DictionnaireLogic (DictionnaireRepository dictionnaireRepository) {
    	this.dictionnaireRepository=dictionnaireRepository;
    }
    
	@Override
	public List<Dictionnaire> getAllDictionnaires() {
		return  dictionnaireRepository.findAll();
	}

	@Override
	public void saveDictionnaire(Dictionnaire dictionnaire) {
		dictionnaireRepository.save(dictionnaire)		;
	}

	@Override
	public Dictionnaire getDictionnaireById(int idDictionnaire) {
        Optional < Dictionnaire > optional = dictionnaireRepository.findById(idDictionnaire);
        Dictionnaire dictionnaire = null;
        if (optional.isPresent()) {
        	dictionnaire = optional.get();
        } else {
            throw new RuntimeException(" Dictionnaire introuvable avec cet  id :: " + idDictionnaire);
        }
        return dictionnaire;
	}

	@Override
	public void deleteDictionnaireById(int idDictionnaire) {
		this.dictionnaireRepository.deleteById(idDictionnaire);		
	}


	@Override
	public long getDictionnaireCount() {
		return dictionnaireRepository.count();
	}


}
