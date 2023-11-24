package com.atacanymc.pokemonreviewapi.DTOs.Request.Pokemon;

import lombok.Value;

@Value
public class UpdatePokemonRequest {
    private String name;
    private int type;
}
