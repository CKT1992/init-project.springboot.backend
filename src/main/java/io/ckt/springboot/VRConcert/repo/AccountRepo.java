package io.ckt.springboot.VRConcert.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import io.ckt.springboot.VRConcert.domain.Account;

public interface AccountRepo extends JpaRepository<Account, UUID>{
    Account findByEmail(String email);
}
