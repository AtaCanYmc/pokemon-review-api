package com.atacanymc.pokemonreviewapi.ENUMs;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum UserStatus {
    ACTIVE(1),
    INACTIVE(2),
    SUSPENDED(3);

    @Getter
    private final int id;

    public static UserStatus fromInteger(int x) {
        return switch (x) {
            case 1 -> ACTIVE;
            case 2 -> INACTIVE;
            case 3 -> SUSPENDED;
            default -> null;
        };
    }
}
