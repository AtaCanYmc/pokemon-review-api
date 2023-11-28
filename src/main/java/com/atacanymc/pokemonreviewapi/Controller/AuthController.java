package com.atacanymc.pokemonreviewapi.Controller;

import com.atacanymc.pokemonreviewapi.DTOs.Request.User.LoginUserRequest;
import com.atacanymc.pokemonreviewapi.DTOs.Request.User.RegisterUserRequest;
import com.atacanymc.pokemonreviewapi.DTOs.Response.User.LoginResponse;
import com.atacanymc.pokemonreviewapi.Service.Implementation.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/pokemon-api/auth")
public class AuthController {
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<LoginResponse> register(@RequestBody RegisterUserRequest request) {
        return ResponseEntity.ok(authenticationService.registerUser(request));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginUserRequest request) {
        return ResponseEntity.ok(authenticationService.loginUser(request));
    }

}
