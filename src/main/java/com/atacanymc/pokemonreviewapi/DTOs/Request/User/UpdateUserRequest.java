package com.atacanymc.pokemonreviewapi.DTOs.Request.User;

import lombok.Value;

@Value
public class UpdateUserRequest {
    private String username;
    private String email;
}
