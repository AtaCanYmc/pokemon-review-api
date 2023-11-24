package com.atacanymc.pokemonreviewapi.Repository;

import com.atacanymc.pokemonreviewapi.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    Boolean existsByUsername(String username);
}