package com.atacanymc.pokemonreviewapi.Service.Interface;

import com.atacanymc.pokemonreviewapi.DTOs.Request.Review.CreateReviewRequest;
import com.atacanymc.pokemonreviewapi.DTOs.Request.Review.UpdateReviewRequest;
import com.atacanymc.pokemonreviewapi.DTOs.Response.Review.ReviewDto;

import java.util.List;

public interface IReviewService {
    public ReviewDto getReviewById(Long id);
    public List<ReviewDto> getAllReviews();
    public ReviewDto createReview(CreateReviewRequest request);
    public ReviewDto updateReview(UpdateReviewRequest request, Long id);
    public ReviewDto deleteReview(Long id);
}
