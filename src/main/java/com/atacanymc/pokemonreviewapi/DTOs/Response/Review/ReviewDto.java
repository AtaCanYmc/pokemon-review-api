package com.atacanymc.pokemonreviewapi.DTOs.Response.Review;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.atacanymc.pokemonreviewapi.Model.Review}
 */
@Value
public class ReviewDto implements Serializable {
    Long id;
    String title;
    String body;
    int rating;
    Long pokemonId;
    Long reviewerId;
}