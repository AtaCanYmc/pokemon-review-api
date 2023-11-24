package com.atacanymc.pokemonreviewapi.Repository;

import com.atacanymc.pokemonreviewapi.Model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
    Optional<Pokemon> findByName(String name);
    Boolean existsByName(String name);
}