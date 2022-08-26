package com.mglcl.logic;

import java.util.List;
import java.util.Optional;

import com.mglcl.entities.Adherent;
import com.mglcl.entities.Emprunt;
import com.mglcl.entities.Livre;
import com.mglcl.repository.AdherentRepository;
import com.mglcl.repository.DictionnaireRepository;
import com.mglcl.repository.EmpruntRepository;
import com.mglcl.repository.LivreRepository;
import com.mglcl.repository.RevueRepository;
import com.mglcl.services.AdherentService;
import com.mglcl.services.DictionnaireService;
import com.mglcl.services.EmpruntService;
import com.mglcl.services.LivreService;
import com.mglcl.services.RevueService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Transactional(readOnly = false)
@Service
public class EmpruntLogic implements EmpruntService{

	
    private EmpruntRepository empruntRepository;
    
    @Autowired
    public EmpruntLogic (EmpruntRepository empruntRepository) {
    	this.empruntRepository=empruntRepository;
    }
    
	@Override
	public List<Emprunt> getAllEmprunts() {
		return  empruntRepository.findAll();
	}

	@Override
	public void saveEmprunt(Emprunt emprunt) {
		empruntRepository.save(emprunt);
	}

	@Override
	public Emprunt getEmpruntById(int idEmprunt) {
        Optional < Emprunt > optional = empruntRepository.findById(idEmprunt);
        Emprunt emprunt = null;
        if (optional.isPresent()) {
        	emprunt = optional.get();
        } else {
            throw new RuntimeException(" Emprunt introuvable avec cet  id :: " + idEmprunt);
        }
        return emprunt;
	}

	@Override
	public void deleteEmpruntById(int idEmprunt) {
		this.empruntRepository.deleteById(idEmprunt);		
	}


	@Override
	public long getEmpruntCount() {
		return empruntRepository.count();
	}

	@Override
	public List<Emprunt> getEmpruntByAdherent(Adherent adherent) {
		    return empruntRepository.findByAdherent(adherent);	
		
	}


}
