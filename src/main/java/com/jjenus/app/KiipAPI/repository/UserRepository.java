package com.jjenus.app.KiipAPI.repository;

import com.jjenus.app.KiipAPI.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
