package com.atacanymc.pokemonreviewapi.Model;

import com.atacanymc.pokemonreviewapi.ENUMs.UserRole;
import com.atacanymc.pokemonreviewapi.ENUMs.UserStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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

    @NotBlank(message = "Username cannot be blank")
    private String username;

    @NotBlank(message = "Password cannot be blank")
    private String password;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Email should be valid")
    private String email;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @NotNull(message = "Role cannot be null")
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @OneToMany(mappedBy = "reviewer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Review> reviews = new HashSet<>();

    public User(String username, String password, String email, UserRole role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.status = UserStatus.ACTIVE;
        this.role = role;
    }

}
