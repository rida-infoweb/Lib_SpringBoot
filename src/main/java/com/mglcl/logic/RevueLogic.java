package com.mglcl.logic;

import java.util.List;
import java.util.Optional;

import com.mglcl.entities.Revue;
import com.mglcl.entities.Livre;
import com.mglcl.repository.AdherentRepository;
import com.mglcl.repository.DictionnaireRepository;
import com.mglcl.repository.LivreRepository;
import com.mglcl.repository.RevueRepository;
import com.mglcl.services.AdherentService;
import com.mglcl.services.DictionnaireService;
import com.mglcl.services.LivreService;
import com.mglcl.services.RevueService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Transactional(readOnly = false)
@Service
public class RevueLogic implements RevueService{

	
    private RevueRepository revueRepository;
    
    @Autowired
    public RevueLogic (RevueRepository revueRepository) {
    	this.revueRepository=revueRepository;
    }
    
	@Override
	public List<Revue> getAllRevues() {
		return  revueRepository.findAll();
	}

	@Override
	public void saveRevue(Revue revue) {
		revueRepository.save(revue)		;
	}

	@Override
	public Revue getRevueById(int idRevue) {
        Optional < Revue > optional = revueRepository.findById(idRevue);
        Revue revue = null;
        if (optional.isPresent()) {
        	revue = optional.get();
        } else {
            throw new RuntimeException(" Revue introuvable avec cet  id :: " + idRevue);
        }
        return revue;
	}

	@Override
	public void deleteRevueById(int idRevue) {
		this.revueRepository.deleteById(idRevue);		
	}


	@Override
	public long getRevueCount() {
		return revueRepository.count();
	}


}
