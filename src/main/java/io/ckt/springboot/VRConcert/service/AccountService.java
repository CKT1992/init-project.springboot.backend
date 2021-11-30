package io.ckt.springboot.VRConcert.service;

import java.util.List;

import io.ckt.springboot.VRConcert.domain.Role;
import io.ckt.springboot.VRConcert.domain.Account;

public interface AccountService {
    Account saveAccount(Account account);
    Role saveRole(Role role);
    void addRoleToAccount(String email, String rolename);
    Account getAccount(String email);
    List<Account>getAccounts();
}
