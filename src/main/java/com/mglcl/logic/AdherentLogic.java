package com.mglcl.logic;

import java.util.List;
import java.util.Optional;

import com.mglcl.dao.AdherentRepository;
import com.mglcl.entities.Adherent;
import com.mglcl.services.AdherentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdherentLogic implements AdherentService{

	
    private AdherentRepository adherentRepository;
    
    @Autowired
    public AdherentLogic (AdherentRepository adherentRepository) {
    	this.adherentRepository=adherentRepository;
    }
    
	@Override
	public List<Adherent> getAllAdherents() {
		return  adherentRepository.findAll();
	}

	@Override
	public void saveAdherent(Adherent adherent) {
		adherentRepository.save(adherent)		;
	}

	@Override
	public Adherent getAdherentById(int idAdherent) {
        Optional < Adherent > optional = adherentRepository.findById(idAdherent);
        Adherent adherent = null;
        if (optional.isPresent()) {
        	adherent = optional.get();
        } else {
            throw new RuntimeException(" Adhérent introuvable avec cet  id :: " + idAdherent);
        }
        return adherent;
	}

	@Override
	public void deleteAdherentById(int idAdherent) {
		this.adherentRepository.deleteById(idAdherent);		
	}

	@Override
	public Adherent getAdherentByCin(String cin) {
        Optional < Adherent > optional = Optional.ofNullable(adherentRepository.findByCin(cin));
        Adherent adherent = null;
        if (optional.isPresent()) {
        	adherent = optional.get();
        } else {
            throw new RuntimeException(" Adhérent introuvable avec ce CIN :: " + cin);
        }
        return adherent;	}

	@Override
	public long getAdherentCount() {
		return adherentRepository.count();
	}


}
