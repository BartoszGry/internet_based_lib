package com.grygierczyk.services;

import com.grygierczyk.config.Role;
import com.grygierczyk.entity.User;
import com.grygierczyk.system_repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder=passwordEncoder;
    }

    public User createUser(User user) {
        validateUserData(user);

        //sprawdzić, czy użytkownik o podanym e-mailu już istnieje
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("Użytkownik o podanym adresie e-mail już istnieje");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        // Hasło powinno być już zahaszowane, jeśli używasz setPassword z PasswordEncoder
        return userRepository.save(user);
    }

    private void validateUserData(User user) {
        if (user.getName() == null || user.getName().isEmpty()) {
            throw new RuntimeException("Imię użytkownika nie może być puste");
        }

        if (user.getSurname() == null || user.getSurname().isEmpty()) {
            throw new RuntimeException("Nazwisko użytkownika nie może być puste");
        }

        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new RuntimeException("Adres e-mail użytkownika nie może być pusty");
        }

    }
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Optional<User> getUserBySurname(String surname) {
        return userRepository.findBySurname(surname);
    }



}
