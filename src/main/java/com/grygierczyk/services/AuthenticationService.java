package com.grygierczyk.services;

import com.grygierczyk.DTO.LoginResponseDTO;
import com.grygierczyk.DTO.UserDTO;
import com.grygierczyk.models.Role;
import com.grygierczyk.models.User;
import com.grygierczyk.system_repo.RoleRepository;
import com.grygierczyk.system_repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private final TokenService tokenService;

    public AuthenticationService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, TokenService tokenService) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @Transactional
    public User registerUser(String email, String password) {
        String encodedPassword = passwordEncoder.encode(password);
        Role userRole = roleRepository.findByAuthority("USER").get();

        Set<Role> authorities = new HashSet<>();

        authorities.add(userRole);

        return userRepository.save(new User(email, encodedPassword, authorities));
    }

    @Transactional
    public LoginResponseDTO loginUser(String email, String password) {
        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email, password)
            );
            String token = tokenService.generateJWT(auth);

            User user=userRepository.findByEmail(email).get();
            return new LoginResponseDTO( new UserDTO(user.getUserId(),user.getEmail(),user.getName()),token);

        } catch (AuthenticationException e) {
            return new LoginResponseDTO(null, "AuthenticationException");
        }
    }

}
