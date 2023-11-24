package com.atacanymc.pokemonreviewapi.DTOs.Request.User;

import lombok.*;

@Value
public class LoginUserRequest {
    private String username;
    private String password;
}
