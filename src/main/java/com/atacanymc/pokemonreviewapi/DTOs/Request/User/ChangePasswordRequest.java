package com.atacanymc.pokemonreviewapi.DTOs.Request.User;

import lombok.Value;

@Value
public class ChangePasswordRequest {
    private String username;
    private String password;
    private String newPassword;
}
