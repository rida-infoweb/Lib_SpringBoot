package com.mglcl.services;

import java.util.List;

import com.mglcl.entities.Emprunt;


public interface EmpruntService {
    List < Emprunt > getAllEmprunts();
    void saveEmprunt(Emprunt emprunt);
    Emprunt getEmpruntById(int idEmprunt);
    void deleteEmpruntById(int idEmprunt);
    public long getEmpruntCount() ;
}