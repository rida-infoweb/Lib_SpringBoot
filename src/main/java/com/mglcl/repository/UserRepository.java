package com.mglcl.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.mglcl.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}