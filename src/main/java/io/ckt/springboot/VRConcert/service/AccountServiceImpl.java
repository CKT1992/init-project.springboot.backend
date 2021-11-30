package io.ckt.springboot.VRConcert.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.ckt.springboot.VRConcert.domain.Role;
import io.ckt.springboot.VRConcert.domain.Account;
import io.ckt.springboot.VRConcert.repo.RoleRepo;
import io.ckt.springboot.VRConcert.repo.AccountRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class AccountServiceImpl implements AccountService, UserDetailsService{
    private final AccountRepo accountRepo;
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Account account = accountRepo.findByEmail(email);
        if(account == null) {
            log.error("Account not found in the database.");
            throw new UsernameNotFoundException("Account not found in the database.");
        } else {
            log.info("Account found in the database: {}.", account.getEmail());
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        account.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getRolename()));
        });
        return new User(account.getEmail(), account.getPassword(), authorities);
    }

    @Override
    public Account saveAccount(Account account) {
        log.info("Saving new account {} {} into db.", account.getFirstname(), account.getLastname());
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        return accountRepo.save(account);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role {} into db.", role.getRolename());
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToAccount(String email, String rolename) {
        log.info("Adding role {} to account {}.", rolename, email);
        Account account = accountRepo.findByEmail(email);
        Role role = roleRepo.findByRolename(rolename);
        account.getRoles().add(role);
    }

    @Override
    public Account getAccount(String email) {
        log.info("Fetching account {}.", email);
        return accountRepo.findByEmail(email);
    }

    @Override
    public List<Account> getAccounts() {
        log.info("Fetching all account.");
        return accountRepo.findAll();
    }
    
}
