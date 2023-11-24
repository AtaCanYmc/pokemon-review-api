package com.atacanymc.pokemonreviewapi.Repository;

import com.atacanymc.pokemonreviewapi.Model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
    Pokemon findByName(String name);
    Boolean existsByName(String name);
}