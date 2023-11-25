package com.atacanymc.pokemonreviewapi.Exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter @Setter
public class ExceptionResponse {
    private HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private String message;
    private String debugMessage;
    private String path;
    private String error;

    private ExceptionResponse() {
        timestamp = LocalDateTime.now();
    }

    public ExceptionResponse(HttpStatus status) {
        this();
        this.status = status;
    }

    public ExceptionResponse(HttpStatus status, Throwable ex) {
        this();
        this.status = status;
        this.message = "Unexpected error";
        this.debugMessage = ex.getLocalizedMessage();
        this.path = ex.getStackTrace()[0].getClassName();
        this.error = ex.getClass().getSimpleName();
    }

    public ExceptionResponse(HttpStatus status, String message, Throwable ex) {
        this();
        this.status = status;
        this.message = message;
        this.debugMessage = ex.getLocalizedMessage();
        this.path = ex.getStackTrace()[0].getClassName();
        this.error = ex.getClass().getSimpleName();
    }
}
