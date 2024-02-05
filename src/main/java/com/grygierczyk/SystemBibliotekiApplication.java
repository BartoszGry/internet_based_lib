package com.grygierczyk;

import com.grygierczyk.models.Role;
import com.grygierczyk.models.User;
import com.grygierczyk.system_repo.RoleRepository;
import com.grygierczyk.system_repo.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@ComponentScan(basePackages = "com.grygierczyk")
public class SystemBibliotekiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SystemBibliotekiApplication.class, args);
	}

	@Bean
	CommandLineRunner run(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder){
		return args->{
			if (roleRepository.findByAuthority("ADMIN").isPresent())return;
			Role adminRole=roleRepository.save(new Role("ADMIN"));
			roleRepository.save(new Role("USER"));

			Set<Role> roleSet=new HashSet<>();
			roleSet.add(adminRole);

			User admin = new User(1,"admin", passwordEncoder.encode("admin"),roleSet );

			userRepository.save(admin);
		};
	}

}
