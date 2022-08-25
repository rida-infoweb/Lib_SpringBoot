package com.mglcl.services;

import java.util.List;

import com.mglcl.entities.Revue;


public interface RevueService {
    List < Revue > getAllRevues();
    void saveRevue(Revue revue);
    Revue getRevueById(int idRevue);
    void deleteRevueById(int idRevue);
    public long getRevueCount() ;
}