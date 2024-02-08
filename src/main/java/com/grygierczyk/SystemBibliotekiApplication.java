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

//	@Bean
//	CommandLineRunner run(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder){
//		return args->{
//
//			Role adminRole=roleRepository.findByAuthority("ADMIN").get();
//			Role userRole = roleRepository.findByAuthority("USER").get();
//
//			Set<Role> roleSet=new HashSet<>();
//			roleSet.add(adminRole);
//			roleSet.add(userRole);
//
//			User admin = new User("admin", passwordEncoder.encode("admin"),roleSet );
//
//			userRepository.save(admin);
//		};
//	}

}
