package com.atacanymc.pokemonreviewapi.Controller;

import com.atacanymc.pokemonreviewapi.DTOs.Request.User.CreateUserRequest;
import com.atacanymc.pokemonreviewapi.DTOs.Request.User.UpdateUserRequest;
import com.atacanymc.pokemonreviewapi.DTOs.Response.User.UserDto;
import com.atacanymc.pokemonreviewapi.Service.Implementation.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/pokemon-api/user")
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<UserDto> getUserByUsername(@PathVariable String username) {
        return ResponseEntity.ok(userService.getUserByUsername(username));
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody CreateUserRequest request) {
        return ResponseEntity.ok(userService.createUser(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UpdateUserRequest request) {
        return ResponseEntity.ok(userService.updateUser(request, id));
    }

    @PatchMapping("/status/{id}")
    public ResponseEntity<UserDto> updateUserStatus(@PathVariable Long id, @RequestParam(name = "status", required = true, defaultValue = "1") int status) {
        return ResponseEntity.ok(userService.updateUserStatus(id, status));
    }

    @PatchMapping("/role/{id}")
    public ResponseEntity<UserDto> updateUserRole(@PathVariable Long id, @RequestParam(name = "role", required = true, defaultValue = "1") int role) {
        return ResponseEntity.ok(userService.updateUserRole(id, role));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserDto> deleteUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.deleteUser(id));
    }
}
