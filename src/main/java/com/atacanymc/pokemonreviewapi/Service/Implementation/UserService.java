package com.atacanymc.pokemonreviewapi.Service.Implementation;

import com.atacanymc.pokemonreviewapi.DTOs.Converter.UserDtoConverter;
import com.atacanymc.pokemonreviewapi.DTOs.Request.User.*;
import com.atacanymc.pokemonreviewapi.DTOs.Response.User.LoginResponse;
import com.atacanymc.pokemonreviewapi.DTOs.Response.User.UserDto;
import com.atacanymc.pokemonreviewapi.ENUMs.UserRole;
import com.atacanymc.pokemonreviewapi.ENUMs.UserStatus;
import com.atacanymc.pokemonreviewapi.Exception.User.UserAlreadyExistException;
import com.atacanymc.pokemonreviewapi.Exception.User.UserNotFoundException;
import com.atacanymc.pokemonreviewapi.Model.User;
import com.atacanymc.pokemonreviewapi.Repository.UserRepository;
import com.atacanymc.pokemonreviewapi.Service.Interface.IUserService;
import jakarta.validation.Valid;
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
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
    }

    protected User findUserByUsername(String username){
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User not found with username: " + username));
    }

    private void checkUserCreatable(String username, String email){
        if (userRepository.existsByUsername(username)){
            throw new UserAlreadyExistException("Username already exists");
        }
        if (userRepository.existsByEmail(email)){
            throw new UserAlreadyExistException("Email already exists");
        }
    }

    private void checkUserUpdatable(Long id, String username, String email){
        if (userRepository.existsByUsername(username) && !userRepository.findByUsername(username).get().getId().equals(id)){
            throw new UserAlreadyExistException("Username already exists");
        }
        if (userRepository.existsByEmail(email) && !userRepository.findByEmail(email).get().getId().equals(id)){
            throw new UserAlreadyExistException("Email already exists");
        }
    }

    @Override
    public LoginResponse loginUser(LoginUserRequest request) {
        User user = findUserByUsername(request.getUsername());
        if (encryptionService.verifyPassword(request.getPassword(), user.getPassword())){
            return new LoginResponse("", "", user.getRole());
        }
        else{
            throw new UserNotFoundException("Invalid username or password");
        }
    }

    @Override
    public UserDto registerUser(RegisterUserRequest request) {
        checkUserCreatable(request.getUsername(), request.getEmail());

        User user = new User(
                request.getUsername(),
                encryptionService.encryptPassword(request.getPassword()),
                request.getEmail(),
                UserRole.USER
        );

        userRepository.save(user);
        return userDtoConverter.convert(user);
    }

    @Override
    public UserDto changePassword(ChangePasswordRequest request) {
        User user = findUserByUsername(request.getUsername());
        if (encryptionService.verifyPassword(request.getPassword(), user.getPassword())){
            user.setPassword(encryptionService.encryptPassword(request.getNewPassword()));
            userRepository.save(user);
            return userDtoConverter.convert(user);
        }
        else{
            throw new UserNotFoundException("Invalid password");
        }
    }

    @Override
    public UserDto getUserById(Long id) {
        User user = findUserById(id);
        return userDtoConverter.convert(user);
    }

    public UserDto getUserByUsername(String username) {
        User user = findUserByUsername(username);
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
        checkUserCreatable(request.getUsername(), request.getEmail());
        User user = new User(
                request.getUsername(),
                encryptionService.encryptPassword(request.getPassword()),
                request.getEmail(),
                UserRole.fromInteger(request.getRole())
        );
        return userDtoConverter.convert(userRepository.save(user));
    }

    @Override
    public UserDto updateUser(UpdateUserRequest request, Long id) {
        User user = findUserById(id);
        checkUserUpdatable(id, request.getUsername(), request.getEmail());
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        return userDtoConverter.convert(userRepository.save(user));
    }

    public UserDto updateUserStatus(Long id, int status) {
        User user = findUserById(id);
        user.setStatus(UserStatus.fromInteger(status));
        return userDtoConverter.convert(userRepository.save(user));
    }

    public UserDto updateUserRole(Long id, int role) {
        User user = findUserById(id);
        user.setRole(UserRole.fromInteger(role));
        return userDtoConverter.convert(userRepository.save(user));
    }

    @Override
    public UserDto deleteUser(Long id) {
        User user = findUserById(id);
        userRepository.delete(user);
        return userDtoConverter.convert(user);
    }

}
