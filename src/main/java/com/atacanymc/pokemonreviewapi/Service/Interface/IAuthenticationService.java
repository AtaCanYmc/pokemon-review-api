package com.atacanymc.pokemonreviewapi.Service.Interface;

import com.atacanymc.pokemonreviewapi.DTOs.Request.User.LoginUserRequest;
import com.atacanymc.pokemonreviewapi.DTOs.Request.User.RegisterUserRequest;
import com.atacanymc.pokemonreviewapi.DTOs.Response.User.LoginResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface IAuthenticationService {
    public LoginResponse loginUser(LoginUserRequest request);
    public LoginResponse registerUser(RegisterUserRequest request);
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
