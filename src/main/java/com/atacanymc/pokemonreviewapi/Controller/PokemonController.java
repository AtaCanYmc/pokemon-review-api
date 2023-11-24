package com.atacanymc.pokemonreviewapi.Controller;

import com.atacanymc.pokemonreviewapi.DTOs.Request.Pokemon.CreatePokemonRequest;
import com.atacanymc.pokemonreviewapi.DTOs.Request.Pokemon.UpdatePokemonRequest;
import com.atacanymc.pokemonreviewapi.Service.Implementation.PokemonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import com.atacanymc.pokemonreviewapi.DTOs.Response.Pokemon.PokemonDto;
import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/pokemon-api/pokemon")
public class PokemonController {
    private final PokemonService pokemonService;
    
    @GetMapping
    public ResponseEntity<List<PokemonDto>> getAllPokemons() {
        return ResponseEntity.ok(pokemonService.getAllPokemons());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PokemonDto> getPokemonById(@PathVariable Long id) {
        return ResponseEntity.ok(pokemonService.getPokemonById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<PokemonDto> getPokemonByName(@PathVariable String name) {
        return ResponseEntity.ok(pokemonService.getPokemonByName(name));
    }

    @PostMapping
    public ResponseEntity<PokemonDto> createPokemon(@RequestBody CreatePokemonRequest request) {
        return ResponseEntity.ok(pokemonService.createPokemon(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PokemonDto> updatePokemon(@PathVariable Long id, @RequestBody UpdatePokemonRequest request) {
        return ResponseEntity.ok(pokemonService.updatePokemon(request, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PokemonDto> deletePokemonById(@PathVariable Long id) {
        return ResponseEntity.ok(pokemonService.deletePokemon(id));
    }
}
