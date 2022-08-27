package com.mglcl.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mglcl.entities.Role;
import com.mglcl.entities.User;
import com.mglcl.repository.RoleRepository;
import com.mglcl.repository.UserRepository;
import com.mglcl.services.RoleService;
import com.mglcl.services.UserService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



@Transactional(readOnly = false)
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private RoleService roleService;

    
    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        
        
        if(user.getUsername().equals("administrateur")) {
        	Role adminrole = new Role();
        	adminrole.setName("ROLE_ADMIN");
        	adminrole.setId(1l);
        	roleService.saveRole(adminrole);
        	List<Role> roles = new ArrayList<Role>();
        	roles.add(adminrole);
        	user.setRoles(roles);
        	userRepository.save(user);
    }
        else {
        	Role userole = new Role();
        	userole.setName("ROLE_USER");
        	userole.setId(2l);
        	roleService.saveRole(userole);
        	List<Role> roles = new ArrayList<Role>();
        	roles.add(userole);
        	user.setRoles(roles);        	

        	userRepository.save(user);
        }
        
        
        
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}