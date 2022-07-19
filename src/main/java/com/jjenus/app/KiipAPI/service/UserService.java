package com.jjenus.app.KiipAPI.service;

import com.jjenus.app.KiipAPI.model.Role;
import com.jjenus.app.KiipAPI.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    User getUser(String email);
    void addRoleToUser(String email, String roleName);
    Role saveRole(Role role);
    User saveUser(User user);
}
