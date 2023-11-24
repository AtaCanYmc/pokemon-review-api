package com.atacanymc.pokemonreviewapi.DTOs.Request.Review;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.atacanymc.pokemonreviewapi.Model.Review}
 */
@Value
public class CreateReviewRequest implements Serializable {
    String title;
    String body;
    int rating;
    Long pokemonId;
    Long reviewerId;
}