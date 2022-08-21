package com.mglcl.services;

import java.util.List;

import com.mglcl.entities.Adherent;
import com.mglcl.entities.Role;


public interface RoleService {
    List < Role > getAllRoles();
    void saveRole(Role role );
    Role getRoleById(int id);
    void deleteRoleById(int id);
}
