package com.atacanymc.pokemonreviewapi.Exception.Pokemon;

public class PokemonAlreadyExistException extends RuntimeException{
    public PokemonAlreadyExistException(String message) {
        super(message);
    }
}
