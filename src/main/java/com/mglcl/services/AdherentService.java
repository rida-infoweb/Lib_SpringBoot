package com.mglcl.services;

import java.util.List;

import com.mglcl.entities.Adherent;


public interface AdherentService {
    List < Adherent > getAllAdherents();
    void saveAdherent(Adherent adherent);
    Adherent getAdherentById(int idAdherent);
    void deleteAdherentById(int idAdherent);
}
