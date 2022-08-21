package com.mglcl.services;

import java.util.List;

import com.mglcl.entities.Adherent;
import com.mglcl.entities.User;


public interface UtilisateurService {
    List < User > getAllUsers();
    void saveUser(User user);
    User getUserById(int id);
    void deleteUserById(int id);
}
