package com.jjenus.app.KiipAPI.service;

import com.jjenus.app.KiipAPI.model.Role;
import com.jjenus.app.KiipAPI.model.User;
import com.jjenus.app.KiipAPI.repository.RoleRepository;
import com.jjenus.app.KiipAPI.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public Role saveRole(Role role){
        return roleRepository.save(role);
    }

    public void addRoleToUser(String username, String roleName){
        User user = userRepository.findByUsername(username);
        user.getRoles().add(roleRepository.findByName(roleName));
    }

    public User getUser(String userName){
        return userRepository.findByUsername(userName);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }
}
