package com.grygierczyk.DTO;

import com.grygierczyk.models.User;

public class LoginResponseDTO {
    private UserDTO userdto;

    private String jwt;

    public LoginResponseDTO(UserDTO user, String jwt) {
        this.userdto = user;
        this.jwt = jwt;
    }

    public UserDTO getUser() {
        return userdto;
    }

    public void setUser(UserDTO user) {
        this.userdto = user;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
