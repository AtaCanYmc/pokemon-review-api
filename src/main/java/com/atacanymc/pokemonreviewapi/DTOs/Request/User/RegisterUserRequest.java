package com.atacanymc.pokemonreviewapi.DTOs.Request.User;

import lombok.*;

@Value
public class RegisterUserRequest {
    private String username;
    private String password;
    private String email;
}
