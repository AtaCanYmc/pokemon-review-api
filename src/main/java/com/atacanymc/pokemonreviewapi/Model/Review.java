package com.atacanymc.pokemonreviewapi.Model;

import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Review {
    private String title;
    private String body;
    private int rating;
}
