package com.atacanymc.pokemonreviewapi.Exception.User;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message) {
        super(message);
    }
}
