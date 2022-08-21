package com.mglcl.services;

import com.mglcl.entities.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}