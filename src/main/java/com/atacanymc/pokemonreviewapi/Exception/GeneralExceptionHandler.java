package com.atacanymc.pokemonreviewapi.Exception;

import com.atacanymc.pokemonreviewapi.Exception.Pokemon.PokemonAlreadyExistException;
import com.atacanymc.pokemonreviewapi.Exception.Pokemon.PokemonNotFoundException;
import com.atacanymc.pokemonreviewapi.Exception.Review.ReviewNotFoundException;
import com.atacanymc.pokemonreviewapi.Exception.User.UserAlreadyExistException;
import com.atacanymc.pokemonreviewapi.Exception.User.UserNotFoundException;
import jakarta.validation.ConstraintViolation;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import jakarta.validation.ConstraintViolationException;

import java.util.ArrayList;
import java.util.List;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler {
    private ResponseEntity<Object> buildResponseEntity(ExceptionResponse exception) {
        return new ResponseEntity<>(exception, exception.getStatus());
    }

    @ExceptionHandler({UserNotFoundException.class})
    public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException exception) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.NOT_FOUND, "User not found", exception);
        return buildResponseEntity(exceptionResponse);
    }

    @ExceptionHandler({PokemonNotFoundException.class})
    public ResponseEntity<Object> handlePokemonNotFoundException(PokemonNotFoundException exception) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.NOT_FOUND, "Pokemon not found", exception);
        return buildResponseEntity(exceptionResponse);
    }

    @ExceptionHandler({UserAlreadyExistException.class})
    public ResponseEntity<Object> handleUserAlreadyExistException(UserAlreadyExistException exception) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.CONFLICT, "User already exist", exception);
        return buildResponseEntity(exceptionResponse);
    }

    @ExceptionHandler({PokemonAlreadyExistException.class})
    public ResponseEntity<Object> handlePokemonAlreadyExistException(UserAlreadyExistException exception) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.CONFLICT, "Pokemon already exist", exception);
        return buildResponseEntity(exceptionResponse);
    }

    @ExceptionHandler({ReviewNotFoundException.class})
    public ResponseEntity<Object> handleReviewNotFoundException(ReviewNotFoundException exception) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.NOT_FOUND, "Review not found", exception);
        return buildResponseEntity(exceptionResponse);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException exception) {
        List<String> messages = new ArrayList<>();

        for (ConstraintViolation<?> violation : exception.getConstraintViolations()) {
            messages.add(violation.getMessage());
        }

        ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.BAD_REQUEST, messages.toString(), exception);
        return buildResponseEntity(exceptionResponse);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<Object> handleBadCredentialsException(BadCredentialsException exception) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.UNAUTHORIZED, "Invalid credentials", exception);
        return buildResponseEntity(exceptionResponse);
    }

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<Object> handleRuntimeException(RuntimeException exception) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage(), exception);
        return buildResponseEntity(exceptionResponse);
    }
}