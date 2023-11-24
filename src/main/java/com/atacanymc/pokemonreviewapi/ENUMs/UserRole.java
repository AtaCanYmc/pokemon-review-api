package com.atacanymc.pokemonreviewapi.ENUMs;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.atacanymc.pokemonreviewapi.ENUMs.RolePermission.*;

@RequiredArgsConstructor
public enum UserRole {
    USER(1, Collections.emptySet()),
    ADMIN(2,
            Set.of(
                    ADMIN_READ,
                    ADMIN_UPDATE,
                    ADMIN_DELETE,
                    ADMIN_CREATE,
                    MANAGER_READ,
                    MANAGER_UPDATE,
                    MANAGER_DELETE,
                    MANAGER_CREATE
            )
    ),
    MANAGER(3,
            Set.of(
                    MANAGER_READ,
                    MANAGER_UPDATE,
                    MANAGER_DELETE,
                    MANAGER_CREATE
            )
    );

    @Getter
    private final int id;
    @Getter
    private final Set<RolePermission> permissions;

    public static UserRole fromInteger(int x) {
        return switch (x) {
            case 1 -> USER;
            case 2 -> ADMIN;
            case 3 -> MANAGER;
            default -> null;
        };
    }

    public List<SimpleGrantedAuthority> getAuthorities() {
        var authorities = getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}
