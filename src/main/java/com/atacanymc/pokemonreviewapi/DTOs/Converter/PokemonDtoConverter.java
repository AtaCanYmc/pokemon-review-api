package com.atacanymc.pokemonreviewapi.DTOs.Converter;

import com.atacanymc.pokemonreviewapi.DTOs.Response.Pokemon.PokemonDto;
import com.atacanymc.pokemonreviewapi.Model.Pokemon;
import org.springframework.stereotype.Component;

@Component
public class PokemonDtoConverter {
    public static PokemonDto convert(Pokemon pokemon) {
        return new PokemonDto(pokemon.getId(),
                pokemon.getName(),
                pokemon.getType());
    }
}
