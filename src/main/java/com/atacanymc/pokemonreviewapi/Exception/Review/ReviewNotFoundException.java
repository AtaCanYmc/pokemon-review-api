package com.atacanymc.pokemonreviewapi.Exception.Review;

public class ReviewNotFoundException extends RuntimeException{
    public ReviewNotFoundException(String message) {
        super(message);
    }
}
