package com.atacanymc.pokemonreviewapi.ENUMs;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum PokemonType {
    FIRE(1),
    WATER(2),
    GRASS(3),
    ELECTRIC(4),
    PSYCHIC(5),
    GROUND(6),
    ROCK(7),
    ICE(8),
    DRAGON(9),
    DARK(10),
    FAIRY(11),
    NORMAL(12),
    FIGHTING(13),
    FLYING(14),
    POISON(15);

    @Getter
    private final int id;

    public static PokemonType fromId(int id) {
        return switch (id) {
            case 1 -> FIRE;
            case 2 -> WATER;
            case 3 -> GRASS;
            case 4 -> ELECTRIC;
            case 5 -> PSYCHIC;
            case 6 -> GROUND;
            case 7 -> ROCK;
            case 8 -> ICE;
            case 9 -> DRAGON;
            case 10 -> DARK;
            case 11 -> FAIRY;
            case 12 -> NORMAL;
            case 13 -> FIGHTING;
            case 14 -> FLYING;
            case 15 -> POISON;
            default -> null;
        };
    }
}
