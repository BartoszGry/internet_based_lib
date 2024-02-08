package com.grygierczyk.services;

import com.grygierczyk.models.Role;
import com.grygierczyk.models.User;
import com.grygierczyk.system_repo.RoleRepository;
import com.grygierczyk.system_repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public User registerUser(String email, String password) {
        String encodedPassword=passwordEncoder.encode(password);
        Role userRole=roleRepository.findByAuthority("USER").get();

        Set<Role> authorities =new HashSet<>();

        authorities.add(userRole);

        return userRepository.save(new User(email,encodedPassword,authorities));
    }
}
