package com.atacanymc.pokemonreviewapi.DTOs.Request.Pokemon;

import lombok.Value;

@Value
public class CreatePokemonRequest {
    private String name;
    private int type;
}
