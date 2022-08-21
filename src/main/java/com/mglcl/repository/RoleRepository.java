package com.mglcl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mglcl.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}