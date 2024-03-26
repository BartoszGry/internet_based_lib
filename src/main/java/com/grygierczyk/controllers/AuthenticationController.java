package com.grygierczyk.controllers;

import com.grygierczyk.DTO.LoginResponseDTO;
import com.grygierczyk.DTO.LoginDTO;
import com.grygierczyk.DTO.RegistrationDTO;
import com.grygierczyk.DTO.RegistrationResponseDTO;
import com.grygierczyk.services.AuthenticationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthenticationController {


    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public RegistrationResponseDTO registerUser(@RequestBody RegistrationDTO body){
        return authenticationService.registerUser(body.getEmail(), body.getPassword(),body.getName(), body.getSurname());
    }

    @PostMapping("/login")
    public LoginResponseDTO loginUser(@RequestBody LoginDTO body){
            return authenticationService.loginUser(body.getEmail(), body.getPassword());
    }

}
