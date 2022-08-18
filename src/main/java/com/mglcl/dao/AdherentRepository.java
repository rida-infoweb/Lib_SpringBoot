package com.mglcl.dao;
import com.mglcl.entities.Adherent;

import org.springframework.data.jpa.repository.JpaRepository;
public interface AdherentRepository extends JpaRepository<Adherent, Integer> {

}
