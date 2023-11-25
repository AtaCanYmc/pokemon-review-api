package com.atacanymc.pokemonreviewapi.Controller;

import com.atacanymc.pokemonreviewapi.DTOs.Request.User.ChangePasswordRequest;
import com.atacanymc.pokemonreviewapi.DTOs.Request.User.LoginUserRequest;
import com.atacanymc.pokemonreviewapi.DTOs.Request.User.RegisterUserRequest;
import com.atacanymc.pokemonreviewapi.DTOs.Response.User.LoginResponse;
import com.atacanymc.pokemonreviewapi.DTOs.Response.User.UserDto;
import com.atacanymc.pokemonreviewapi.Service.Implementation.UserService;
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
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody RegisterUserRequest request) {
        return ResponseEntity.ok(userService.registerUser(request));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginUserRequest request) {
        return ResponseEntity.ok(userService.loginUser(request));
    }

    @PostMapping("/change-password")
    public ResponseEntity<UserDto> changePassword(@RequestBody ChangePasswordRequest request) {
        return ResponseEntity.ok(userService.changePassword(request));
    }

}
