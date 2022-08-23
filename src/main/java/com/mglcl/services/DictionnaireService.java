package com.mglcl.services;

import java.util.List;

import com.mglcl.entities.Dictionnaire;


public interface DictionnaireService {
    List < Dictionnaire > getAllDictionnaires();
    void saveDictionnaire(Dictionnaire dictionnaire);
    Dictionnaire getDictionnaireById(int idDictionnaire);
    void deleteDictionnaireById(int idDictionnaire);
    public long getDictionnaireCount() ;
}