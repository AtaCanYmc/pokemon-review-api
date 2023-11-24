package com.atacanymc.pokemonreviewapi.DTOs.Request.User;

import lombok.*;

@Value
public class CreateUserRequest {
    private String username;
    private String password;
    private String email;
    private int role;
}
