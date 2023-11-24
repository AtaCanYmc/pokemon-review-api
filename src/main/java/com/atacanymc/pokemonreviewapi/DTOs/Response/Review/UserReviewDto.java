package com.atacanymc.pokemonreviewapi.DTOs.Response.Review;

import com.atacanymc.pokemonreviewapi.DTOs.Response.Pokemon.PokemonDto;
import lombok.Value;
import java.io.Serializable;

/**
 * DTO for {@link com.atacanymc.pokemonreviewapi.Model.Review}
 */
@Value
public class UserReviewDto implements Serializable {
    Long id;
    String title;
    String body;
    int rating;
    PokemonDto pokemon;
}