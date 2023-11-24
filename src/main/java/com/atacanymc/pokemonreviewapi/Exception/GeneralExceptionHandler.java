package com.atacanymc.pokemonreviewapi.Exception;

import com.atacanymc.pokemonreviewapi.Exception.Pokemon.PokemonAlreadyExistException;
import com.atacanymc.pokemonreviewapi.Exception.Pokemon.PokemonNotFoundException;
import com.atacanymc.pokemonreviewapi.Exception.User.UserAlreadyExistException;
import com.atacanymc.pokemonreviewapi.Exception.User.UserNotFoundException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler {
    private ResponseEntity<Object> buildResponseEntity(ExceptionResponse exception) {
        return new ResponseEntity<>(exception, exception.getStatus());
    }

    @ExceptionHandler({UserNotFoundException.class})
    public ResponseEntity<?> handleUserNotFoundException(UserNotFoundException exception) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.NOT_FOUND, exception.getMessage(), exception);
        return buildResponseEntity(exceptionResponse);
    }

    @ExceptionHandler({PokemonNotFoundException.class})
    public ResponseEntity<Object> handlePokemonNotFoundException(PokemonNotFoundException exception) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.NOT_FOUND, exception.getMessage(), exception);
        return buildResponseEntity(exceptionResponse);
    }

    @ExceptionHandler({UserAlreadyExistException.class})
    public ResponseEntity<Object> handleUserAlreadyExistException(UserAlreadyExistException exception) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.CONFLICT, exception.getMessage(), exception);
        return buildResponseEntity(exceptionResponse);
    }
    @ExceptionHandler({PokemonAlreadyExistException.class})
    public ResponseEntity<Object> handlePokemonAlreadyExistException(UserAlreadyExistException exception) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.CONFLICT, exception.getMessage(), exception);
        return buildResponseEntity(exceptionResponse);
    }

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<Object> handleRuntimeException(RuntimeException exception) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage(), exception);
        return buildResponseEntity(exceptionResponse);
    }
}