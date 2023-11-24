package com.atacanymc.pokemonreviewapi.Exception.Pokemon;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Pokemon is already exist")
public class PokemonAlreadyExistException extends RuntimeException{
    public PokemonAlreadyExistException(String message) {
        super(message);
    }
}
