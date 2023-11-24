package com.atacanymc.pokemonreviewapi.Service.Implementation;

import com.atacanymc.pokemonreviewapi.DTOs.Converter.PokemonDtoConverter;
import com.atacanymc.pokemonreviewapi.DTOs.Request.Pokemon.CreatePokemonRequest;
import com.atacanymc.pokemonreviewapi.DTOs.Request.Pokemon.UpdatePokemonRequest;
import com.atacanymc.pokemonreviewapi.DTOs.Response.Pokemon.PokemonDto;
import com.atacanymc.pokemonreviewapi.ENUMs.PokemonType;
import com.atacanymc.pokemonreviewapi.Exception.Pokemon.PokemonAlreadyExistException;
import com.atacanymc.pokemonreviewapi.Exception.Pokemon.PokemonNotFoundException;
import com.atacanymc.pokemonreviewapi.Model.Pokemon;
import com.atacanymc.pokemonreviewapi.Service.Interface.IPokemonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.atacanymc.pokemonreviewapi.Repository.PokemonRepository;
import java.util.List;
import static java.util.stream.Collectors.toList;

@RequiredArgsConstructor
@Service
public class PokemonService implements IPokemonService {
    private final PokemonRepository pokemonRepository;
    private final PokemonDtoConverter pokemonDtoConverter;

    protected Pokemon findPokemonById(Long id){
        return pokemonRepository.findById(id)
                .orElseThrow(() -> new PokemonNotFoundException("Pokemon not found with id: " + id));
    }

    protected Pokemon findPokemonByName(String name){
        return pokemonRepository.findByName(name)
                .orElseThrow(() -> new PokemonNotFoundException("Pokemon not found with name: " + name));
    }

    @Override
    public PokemonDto getPokemonById(Long id) {
        return pokemonDtoConverter.convert(findPokemonById(id));
    }

    public PokemonDto getPokemonByName(String name) {
        return pokemonDtoConverter.convert(findPokemonByName(name));
    }

    @Override
    public List<PokemonDto> getAllPokemons() {
        return pokemonRepository.findAll().stream()
                .map(pokemonDtoConverter::convert)
                .collect(toList());
    }

    @Override
    public PokemonDto createPokemon(CreatePokemonRequest request) {
        if (pokemonRepository.existsByName(request.getName())){
            throw new PokemonAlreadyExistException("Pokemon already exists");
        }

        Pokemon pokemon = new Pokemon(
                request.getName(),
                PokemonType.fromId(request.getType())
        );

        pokemonRepository.save(pokemon);
        return pokemonDtoConverter.convert(pokemon);
    }

    @Override
    public PokemonDto updatePokemon(UpdatePokemonRequest request, Long id) {
        Pokemon pokemon = findPokemonById(id);
        pokemon.setName(request.getName());
        pokemon.setType(PokemonType.fromId(request.getType()));

        pokemonRepository.save(pokemon);
        return pokemonDtoConverter.convert(pokemon);
    }

    @Override
    public PokemonDto deletePokemon(Long id) {
        Pokemon pokemon = findPokemonById(id);
        pokemonRepository.delete(pokemon);
        return pokemonDtoConverter.convert(pokemon);
    }
}
