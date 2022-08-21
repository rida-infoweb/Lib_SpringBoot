package com.mglcl.repository;
import com.mglcl.entities.Adherent;

import org.springframework.data.jpa.repository.JpaRepository;
public interface AdherentRepository extends JpaRepository<Adherent, Integer> {
    Adherent findByCin(String cin);
    }
