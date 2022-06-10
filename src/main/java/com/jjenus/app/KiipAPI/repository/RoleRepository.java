package com.jjenus.app.KiipAPI.repository;

import com.jjenus.app.KiipAPI.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
