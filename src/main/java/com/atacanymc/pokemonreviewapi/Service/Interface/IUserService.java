package com.atacanymc.pokemonreviewapi.Service.Interface;

import com.atacanymc.pokemonreviewapi.DTOs.Request.User.*;
import com.atacanymc.pokemonreviewapi.DTOs.Response.User.LoginResponse;
import com.atacanymc.pokemonreviewapi.DTOs.Response.User.UserDto;
import java.util.List;

public interface IUserService {
    public UserDto getUserById(Long id);
    public List<UserDto> getAllUsers();
    public UserDto createUser(CreateUserRequest request);
    public UserDto updateUser(UpdateUserRequest request, Long id);
    public UserDto changePassword(ChangePasswordRequest request);
    public UserDto deleteUser(Long id);
}
