package io.ckt.springboot.VRConcert;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import io.ckt.springboot.VRConcert.domain.Account;
import io.ckt.springboot.VRConcert.domain.Role;
import io.ckt.springboot.VRConcert.service.AccountService;

@SpringBootApplication
public class VrConcertApplication {

	public static void main(String[] args) {
		SpringApplication.run(VrConcertApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// @Bean
	// CommandLineRunner run(AccountService accountService) {
	// 	return args -> {
	// 		accountService.saveRole(new Role(null, "ROLE_USER"));
	// 		accountService.saveRole(new Role(null, "ROLE_MANAGER"));
	// 		accountService.saveRole(new Role(null, "ROLE_ADMIN"));
	// 		accountService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

	// 		accountService.saveAccount(new Account(null, "CK", "Tseng", "1992-11-20T00:00:00.001+0000", "tseng1120a@gmail.com", new ArrayList<>(), "Ji394su3!", true, "2021-11-20T00:00:00.001+0000", "2021-11-20T00:00:00.001+0000"));

	// 		accountService.addRoleToAccount("tseng1120a@gmail.com", "ROLE_ADMIN");
	// 	};
	// }

}
