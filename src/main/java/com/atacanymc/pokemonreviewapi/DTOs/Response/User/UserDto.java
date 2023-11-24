package com.atacanymc.pokemonreviewapi.DTOs.Response.User;

import com.atacanymc.pokemonreviewapi.ENUMs.UserRole;
import com.atacanymc.pokemonreviewapi.ENUMs.UserStatus;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.atacanymc.pokemonreviewapi.Model.User}
 */
@Value
public class UserDto implements Serializable {
    Long id;
    String username;
    String email;
    UserStatus status;
    UserRole role;
}