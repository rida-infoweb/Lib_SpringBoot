package com.mglcl.services;

import java.util.List;

import com.mglcl.entities.Langue;


public interface LanguesService {
    List < Langue > getAllLangues();
    void saveLangue(Langue langue);
    Langue getLangueById(int idLangue);
    void deleteLangueById(int idLangue);
}