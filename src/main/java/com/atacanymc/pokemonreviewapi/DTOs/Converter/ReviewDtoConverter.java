package com.atacanymc.pokemonreviewapi.DTOs.Converter;

import com.atacanymc.pokemonreviewapi.DTOs.Response.Review.PokemonReviewDto;
import com.atacanymc.pokemonreviewapi.DTOs.Response.Review.ReviewDto;
import com.atacanymc.pokemonreviewapi.DTOs.Response.Review.UserReviewDto;
import com.atacanymc.pokemonreviewapi.Model.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ReviewDtoConverter {
    private final PokemonDtoConverter pokemonDtoConverter;
    private final UserDtoConverter userDtoConverter;
    public ReviewDto convert(Review review) {
        return new ReviewDto(review.getId(),
                review.getTitle(),
                review.getBody(),
                review.getRating(),
                review.getPokemon().getId(),
                review.getReviewer().getId());
    }

    public UserReviewDto convertUserReview(Review review) {
        return new UserReviewDto(review.getId(),
                review.getTitle(),
                review.getBody(),
                review.getRating(),
                pokemonDtoConverter.convert(review.getPokemon()));
    }

    public PokemonReviewDto convertPokemonReview(Review review) {
        return new PokemonReviewDto(review.getId(),
                review.getTitle(),
                review.getBody(),
                review.getRating(),
                userDtoConverter.convert(review.getReviewer()));
    }
}
