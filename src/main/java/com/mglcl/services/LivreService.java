package com.mglcl.services;

import java.util.List;

import com.mglcl.entities.Livre;


public interface LivreService {
    List < Livre > getAllLivres();
    void saveLivre(Livre livre);
    Livre getLivreById(int idLivre);
    void deleteLivreById(int idLivre);
    public long getLivreCount() ;
}