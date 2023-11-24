package com.atacanymc.pokemonreviewapi.Model;

import com.atacanymc.pokemonreviewapi.ENUMs.UserRole;
import com.atacanymc.pokemonreviewapi.ENUMs.UserStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Entity @Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String email;
    private UserStatus status;
    private UserRole role;

    @OneToMany(mappedBy = "reviewer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PokemonReview> reviews = new HashSet<>();
}
