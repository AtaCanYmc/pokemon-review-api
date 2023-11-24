package com.atacanymc.pokemonreviewapi.Exception.User;

public class UserAlreadyExistException extends RuntimeException{
    public UserAlreadyExistException(String message) {
        super(message);
    }
}
