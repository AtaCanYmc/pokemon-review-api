package com.atacanymc.pokemonreviewapi.Exception.Pokemon;

public class PokemonNotFoundException extends RuntimeException{
    public PokemonNotFoundException(String message) {
        super(message);
    }
}
