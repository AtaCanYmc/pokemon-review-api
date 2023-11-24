package com.atacanymc.pokemonreviewapi.DTOs.Converter;

import com.atacanymc.pokemonreviewapi.DTOs.Response.Review.PokemonReviewDto;
import com.atacanymc.pokemonreviewapi.DTOs.Response.Review.ReviewDto;
import com.atacanymc.pokemonreviewapi.DTOs.Response.Review.UserReviewDto;
import com.atacanymc.pokemonreviewapi.Model.Review;
import org.springframework.stereotype.Component;

@Component
public class ReviewDtoConverter {
    public static ReviewDto convert(Review review) {
        return new ReviewDto(review.getId(),
                review.getTitle(),
                review.getBody(),
                review.getRating(),
                review.getPokemon().getId(),
                review.getReviewer().getId());
    }

    public static UserReviewDto convertUserReview(Review review) {
        return new UserReviewDto(review.getId(),
                review.getTitle(),
                review.getBody(),
                review.getRating(),
                PokemonDtoConverter.convert(review.getPokemon()));
    }

    public static PokemonReviewDto convertPokemonReview(Review review) {
        return new PokemonReviewDto(review.getId(),
                review.getTitle(),
                review.getBody(),
                review.getRating(),
                UserDtoConverter.convert(review.getReviewer()));
    }
}
