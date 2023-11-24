package com.atacanymc.pokemonreviewapi.DTOs.Response.User;

import com.atacanymc.pokemonreviewapi.ENUMs.UserRole;
import lombok.Value;

@Value
public class LoginResponse {
    private String accessToken;
    private String refreshToken;
    private UserRole role;
}
