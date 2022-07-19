package com.jjenus.app.KiipAPI.controller;

import com.jjenus.app.KiipAPI.model.User;
import com.jjenus.app.KiipAPI.service.UserServiceImpl;
import com.jjenus.app.KiipAPI.util.UserForm;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl userServiceImpl;

    @PostMapping("")
    public ResponseEntity<User> save(@RequestBody UserForm user){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/users").toUriString());
        return ResponseEntity.created(uri).body(userServiceImpl.saveUser(new User(user.getName(), user.getEmail(), user.getPassword())));
    }

    @GetMapping("")
    public ResponseEntity<List<User>> getUsers(){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/users").toUriString());
        return ResponseEntity.created(uri).body(userServiceImpl.getUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") String email){
        return ResponseEntity.ok().body(userServiceImpl.getUser(email));
    }

    @PostMapping("/add-role")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm form){
        userServiceImpl.addRoleToUser(form.getEmail(), form.getRole());
        return ResponseEntity.ok().build();
    }

    @Data
    class RoleToUserForm{
        private String email;
        private String role;
    }

}
