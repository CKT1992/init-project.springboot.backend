package io.ckt.springboot.VRConcert.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import io.ckt.springboot.VRConcert.domain.Role;

public interface RoleRepo extends JpaRepository<Role, UUID>{
    Role findByRolename(String rolename);
}
