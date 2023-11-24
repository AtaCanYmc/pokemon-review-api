package com.atacanymc.pokemonreviewapi.Repository;

import com.atacanymc.pokemonreviewapi.Model.PokemonReview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PokemonReviewRepository extends JpaRepository<PokemonReview, Long> {
    List<PokemonReview> findByPokemonId(Long pokemonId);
    List<PokemonReview> findByUserId(Long userId);
}