package com.mglcl.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.mglcl.entities.User;

public interface UtilisateurRepository extends JpaRepository<User, Long> {

}