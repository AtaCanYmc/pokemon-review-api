package com.atacanymc.pokemonreviewapi.Controller;

import com.atacanymc.pokemonreviewapi.DTOs.Request.Review.UpdateReviewRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.atacanymc.pokemonreviewapi.Service.Implementation.ReviewService;
import org.springframework.http.ResponseEntity;
import com.atacanymc.pokemonreviewapi.DTOs.Response.Review.ReviewDto;
import java.util.List;
import com.atacanymc.pokemonreviewapi.DTOs.Request.Review.CreateReviewRequest;

@RequiredArgsConstructor
@RestController
@RequestMapping("/pokemon-api/review")
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping
    public ResponseEntity<List<ReviewDto>> getAllReviews() {
        return ResponseEntity.ok(reviewService.getAllReviews());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewDto> getReviewById(@PathVariable Long id) {
        return ResponseEntity.ok(reviewService.getReviewById(id));
    }

    @GetMapping("/pokemon/{pokemonId}")
    public ResponseEntity<List<ReviewDto>> getReviewsByPokemonId(@PathVariable Long pokemonId) {
        return ResponseEntity.ok(reviewService.getReviewsByPokemonId(pokemonId));
    }

    @GetMapping("/reviewer/{userId}")
    public ResponseEntity<List<ReviewDto>> getReviewsByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(reviewService.getReviewsByUserId(userId));
    }

    @PostMapping
    public ResponseEntity<ReviewDto> createReview(@RequestBody CreateReviewRequest request) {
        return ResponseEntity.ok(reviewService.createReview(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReviewDto> updateReview(@PathVariable Long id, @RequestBody UpdateReviewRequest request) {
        return ResponseEntity.ok(reviewService.updateReview(request, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ReviewDto> deleteReviewById(@PathVariable Long id) {
        return ResponseEntity.ok(reviewService.deleteReview(id));
    }
}
