package com.atacanymc.pokemonreviewapi.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Entity @Table(name = "pokemon_reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title cannot be blank")
    @Min(value = 3, message = "Title cannot be less than 3 characters")
    @Max(value = 50, message = "Title cannot be greater than 50 characters")
    private String title;

    @Min(value = 3, message = "Body cannot be less than 3 characters")
    @Max(value = 500, message = "Body cannot be greater than 500 characters")
    @NotBlank(message = "Body cannot be blank")
    private String body;

    @NotBlank(message = "Rating cannot be blank")
    @Min(value = 1, message = "Rating cannot be less than 1")
    @Max(value = 5, message = "Rating cannot be greater than 5")
    private int rating;

    @ManyToOne(targetEntity = Pokemon.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "pokemon_id")
    private Pokemon pokemon;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "rewiever_id")
    private User reviewer;

    public Review(String title, String body, int rating, Pokemon pokemon, User reviewer) {
        this.title = title;
        this.body = body;
        this.rating = rating;
        this.pokemon = pokemon;
        this.reviewer = reviewer;
    }
}
