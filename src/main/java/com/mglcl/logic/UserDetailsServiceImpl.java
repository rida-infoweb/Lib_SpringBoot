package com.mglcl.logic;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mglcl.entities.Role;
import com.mglcl.entities.User;
import com.mglcl.repository.UserRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) throw new UsernameNotFoundException(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        
        if(user.getUsername().equals("administrateur")) {
        	Role adminrole = new Role();
        	adminrole.setName("ROLE_ADMIN");
        	 grantedAuthorities.add(new SimpleGrantedAuthority(adminrole.getName()));
        }
        else {
        	Role userrole = new Role();
        	userrole.setName("ROLE_USER");
        	 grantedAuthorities.add(new SimpleGrantedAuthority(userrole.getName()));
        	
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}