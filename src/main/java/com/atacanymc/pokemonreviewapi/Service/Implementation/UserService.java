package com.atacanymc.pokemonreviewapi.Service.Implementation;

import com.atacanymc.pokemonreviewapi.DTOs.Converter.UserDtoConverter;
import com.atacanymc.pokemonreviewapi.DTOs.Request.User.*;
import com.atacanymc.pokemonreviewapi.DTOs.Response.User.LoginResponse;
import com.atacanymc.pokemonreviewapi.DTOs.Response.User.UserDto;
import com.atacanymc.pokemonreviewapi.Model.User;
import com.atacanymc.pokemonreviewapi.Repository.UserRepository;
import com.atacanymc.pokemonreviewapi.Service.Interface.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class UserService implements IUserService{
    private final UserRepository userRepository;
    private final UserDtoConverter userDtoConverter;
    private final EncryptionService encryptionService;

    protected User findUserById(Long id){
        return userRepository.findById(id)
                .orElseThrow();
    }

    protected User findUserByUsername(String username){
        return userRepository.findByUsername(username)
                .orElseThrow();
    }

    @Override
    public LoginResponse loginUser(LoginUserRequest request) {
        User user = findUserByUsername(request.getUsername());
        if (encryptionService.verifyPassword(request.getPassword(), user.getPassword())){
            return new LoginResponse("", "", user.getRole());
        }
        else{
            throw new RuntimeException("Invalid password");
        }
    }

    @Override
    public UserDto registerUser(RegisterUserRequest request) {
        return null;
    }

    @Override
    public UserDto changePassword(ChangePasswordRequest request, Long id) {
        return null;
    }

    @Override
    public UserDto getUserById(Long id) {
        return null;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return null;
    }

    @Override
    public UserDto createUser(CreateUserRequest request) {
        return null;
    }

    @Override
    public UserDto updateUser(UpdateUserRequest request, Long id) {
        return null;
    }

    @Override
    public UserDto deleteUser(Long id) {
        return null;
    }
}
