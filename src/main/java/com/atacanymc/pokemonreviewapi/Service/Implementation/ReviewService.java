package com.atacanymc.pokemonreviewapi.Service.Implementation;

import com.atacanymc.pokemonreviewapi.DTOs.Converter.ReviewDtoConverter;
import com.atacanymc.pokemonreviewapi.DTOs.Request.Review.CreateReviewRequest;
import com.atacanymc.pokemonreviewapi.DTOs.Request.Review.UpdateReviewRequest;
import com.atacanymc.pokemonreviewapi.DTOs.Response.Review.ReviewDto;
import com.atacanymc.pokemonreviewapi.Exception.Review.ReviewNotFoundException;
import com.atacanymc.pokemonreviewapi.Model.Review;
import com.atacanymc.pokemonreviewapi.Service.Interface.IReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.atacanymc.pokemonreviewapi.Repository.ReviewRepository;
import java.util.List;


@RequiredArgsConstructor
@Service
public class ReviewService implements IReviewService {
    private final PokemonService pokemonService;
    private final UserService userService;
    private final ReviewRepository reviewRepository;
    private final ReviewDtoConverter reviewDtoConverter;

    protected Review findReviewById(Long id){
        return reviewRepository.findById(id)
                .orElseThrow(() -> new ReviewNotFoundException("Review not found with id: " + id));
    }

    @Override
    public ReviewDto getReviewById(Long id) {
        return reviewDtoConverter.convert(findReviewById(id));
    }

    @Override
    public List<ReviewDto> getAllReviews() {
        return reviewRepository.findAll().stream()
                .map(reviewDtoConverter::convert)
                .collect(java.util.stream.Collectors.toList());
    }

    @Override
    public ReviewDto createReview(CreateReviewRequest request) {
        Review review = new Review(
                request.getTitle(),
                request.getBody(),
                request.getRating(),
                pokemonService.findPokemonById(request.getPokemonId()),
                userService.findUserById(request.getReviewerId())
        );
        return reviewDtoConverter.convert(reviewRepository.save(review));
    }

    @Override
    public ReviewDto updateReview(UpdateReviewRequest request, Long id) {
        Review review = findReviewById(id);
        review.setTitle(request.getTitle());
        review.setBody(request.getBody());
        review.setRating(request.getRating());
        reviewRepository.save(review);
        return reviewDtoConverter.convert(review);
    }

    @Override
    public ReviewDto deleteReview(Long id) {
        Review review = findReviewById(id);
        reviewRepository.delete(review);
        return reviewDtoConverter.convert(review);
    }
}
