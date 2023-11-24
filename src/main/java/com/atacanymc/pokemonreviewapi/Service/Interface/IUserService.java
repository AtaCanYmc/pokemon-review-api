package com.atacanymc.pokemonreviewapi.Service.Interface;

import com.atacanymc.pokemonreviewapi.DTOs.Request.User.*;
import com.atacanymc.pokemonreviewapi.DTOs.Response.User.LoginResponse;
import com.atacanymc.pokemonreviewapi.DTOs.Response.User.UserDto;

import java.util.List;

public interface IUserService {
    public LoginResponse loginUser(LoginUserRequest request);
    public UserDto registerUser(RegisterUserRequest request);
    public UserDto changePassword(ChangePasswordRequest request, Long id);
    public UserDto getUserById(Long id);
    public List<UserDto> getAllUsers();
    public UserDto createUser(CreateUserRequest request);
    public UserDto updateUser(UpdateUserRequest request, Long id);
    public UserDto deleteUser(Long id);
}
