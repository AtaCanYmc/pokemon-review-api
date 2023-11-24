package com.atacanymc.pokemonreviewapi.DTOs.Response.Pokemon;

import com.atacanymc.pokemonreviewapi.ENUMs.PokemonType;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.atacanymc.pokemonreviewapi.Model.Pokemon}
 */
@Value
public class PokemonDto implements Serializable {
    Long id;
    String name;
    PokemonType type;
}