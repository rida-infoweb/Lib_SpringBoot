package com.mglcl.logic;

import java.util.List;
import java.util.Optional;

import com.mglcl.entities.Adherent;
import com.mglcl.entities.Livre;
import com.mglcl.repository.AdherentRepository;
import com.mglcl.repository.DictionnaireRepository;
import com.mglcl.repository.LivreRepository;
import com.mglcl.services.AdherentService;
import com.mglcl.services.DictionnaireService;
import com.mglcl.services.LivreService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Transactional
@Service
public class LivreLogic implements LivreService{

	
    private LivreRepository livreRepository;
    
    @Autowired
    public LivreLogic (LivreRepository livreRepository) {
    	this.livreRepository=livreRepository;
    }
    
	@Override
	public List<Livre> getAllLivres() {
		return  livreRepository.findAll();
	}

	@Override
	public void saveLivre(Livre livre) {
		livreRepository.save(livre)		;
	}

	@Override
	public Livre getLivreById(int idLivre) {
        Optional < Livre > optional = livreRepository.findById(idLivre);
        Livre livre = null;
        if (optional.isPresent()) {
        	livre = optional.get();
        } else {
            throw new RuntimeException(" Livre introuvable avec cet  id :: " + idLivre);
        }
        return livre;
	}

	@Override
	public void deleteLivreById(int idLivre) {
		this.livreRepository.deleteById(idLivre);		
	}


	@Override
	public long getLivreCount() {
		return livreRepository.count();
	}


}
