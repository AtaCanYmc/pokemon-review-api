package com.atacanymc.pokemonreviewapi.Service.Implementation;

import com.atacanymc.pokemonreviewapi.DTOs.Converter.UserDtoConverter;
import com.atacanymc.pokemonreviewapi.DTOs.Request.User.*;
import com.atacanymc.pokemonreviewapi.DTOs.Response.User.LoginResponse;
import com.atacanymc.pokemonreviewapi.DTOs.Response.User.UserDto;
import com.atacanymc.pokemonreviewapi.ENUMs.UserRole;
import com.atacanymc.pokemonreviewapi.Model.User;
import com.atacanymc.pokemonreviewapi.Repository.UserRepository;
import com.atacanymc.pokemonreviewapi.Service.Interface.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import static java.util.stream.Collectors.toList;

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
        if (userRepository.existsByUsername(request.getUsername())){
            throw new RuntimeException("Username already exists");
        }
        if (userRepository.existsByEmail(request.getEmail())){
            throw new RuntimeException("Email already exists");
        }

        User user = new User(
                request.getUsername(),
                request.getEmail(),
                encryptionService.encryptPassword(request.getPassword()),
                UserRole.USER
        );

        userRepository.save(user);
        return userDtoConverter.convert(user);
    }

    @Override
    public UserDto changePassword(ChangePasswordRequest request, Long id) {
        User user = findUserById(id);
        if (encryptionService.verifyPassword(request.getPassword(), user.getPassword())){
            user.setPassword(encryptionService.encryptPassword(request.getNewPassword()));
            userRepository.save(user);
            return userDtoConverter.convert(user);
        }
        else{
            throw new RuntimeException("Invalid password");
        }
    }

    @Override
    public UserDto getUserById(Long id) {
        User user = findUserById(id);
        return userDtoConverter.convert(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<UserDto> users = userRepository.findAll()
                .stream()
                .map(userDtoConverter::convert)
                .collect(toList());
        return users;
    }

    @Override
    public UserDto createUser(CreateUserRequest request) {
        User user = new User(
                request.getUsername(),
                request.getEmail(),
                encryptionService.encryptPassword(request.getPassword()),
                UserRole.fromInteger(request.getRole())
        );
        return userDtoConverter.convert(userRepository.save(user));
    }

    @Override
    public UserDto updateUser(UpdateUserRequest request, Long id) {
        User user = findUserById(id);
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        return userDtoConverter.convert(userRepository.save(user));
    }

    @Override
    public UserDto deleteUser(Long id) {
        User user = findUserById(id);
        userRepository.delete(user);
        return userDtoConverter.convert(user);
    }
}
