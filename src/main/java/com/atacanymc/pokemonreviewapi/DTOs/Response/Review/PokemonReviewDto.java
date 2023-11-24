package com.atacanymc.pokemonreviewapi.DTOs.Response.Review;

import com.atacanymc.pokemonreviewapi.DTOs.Response.User.UserDto;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.atacanymc.pokemonreviewapi.Model.Review}
 */
@Value
public class PokemonReviewDto implements Serializable {
    Long id;
    String title;
    String body;
    int rating;
    UserDto reviewer;
}