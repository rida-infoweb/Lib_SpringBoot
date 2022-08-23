package com.mglcl.services;

import java.util.List;

import com.mglcl.entities.Auteur;


public interface AuteurService {
    List < Auteur > getAllAuteurs();
    void saveAuteur(Auteur auteur);
    Auteur getAuteurById(int idAuteur);
    void deleteAuteurById(int idAuteur);
}