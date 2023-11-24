package com.atacanymc.pokemonreviewapi.DTOs.Request.Review;

import lombok.Value;

@Value
public class UpdateReviewRequest {
    private String title;
    private String body;
    private int rating;
}
