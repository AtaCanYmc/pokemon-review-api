package com.atacanymc.pokemonreviewapi.Service.Interface;

import com.atacanymc.pokemonreviewapi.DTOs.Request.Pokemon.CreatePokemonRequest;
import com.atacanymc.pokemonreviewapi.DTOs.Request.Pokemon.UpdatePokemonRequest;
import com.atacanymc.pokemonreviewapi.DTOs.Response.Pokemon.PokemonDto;

import java.util.List;

public interface IPokemonService {
    public PokemonDto getPokemonById(Long id);
    public List<PokemonDto> getAllPokemons();
    public PokemonDto createPokemon(CreatePokemonRequest request);
    public PokemonDto updatePokemon(UpdatePokemonRequest request, Long id);
    public PokemonDto deletePokemon(Long id);
}
