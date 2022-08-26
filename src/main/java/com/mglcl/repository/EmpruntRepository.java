package com.mglcl.repository;

import com.mglcl.entities.Adherent;
import com.mglcl.entities.Emprunt;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpruntRepository extends JpaRepository<Emprunt, Integer>{
    List<Emprunt> findByAdherent(Adherent adherent); 
}
