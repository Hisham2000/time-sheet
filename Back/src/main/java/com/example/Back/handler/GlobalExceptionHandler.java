package com.example.Back.handler;


import com.example.Back.dto.ErrorResponse;
import jakarta.persistence.ElementCollection;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        Map<String, String> error = new HashMap<>();
        String errorMessage = ex.getRootCause().getMessage();
        error.put("error", errorMessage);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }


    @ExceptionHandler(PreventSaveException.class)
    public ResponseEntity handleRestaurantNotActive(PreventSaveException restaurantNotActiveException){
        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(restaurantNotActiveException.getMessage())
                .code(403)
                .success(Boolean.FALSE)
                .build();
        return ResponseEntity.status(403).body(errorResponse);
    }

    @ExceptionHandler(WrongUserNameOrPasswordException.class)
    public ResponseEntity handelWrongUserNameOrPassword(WrongUserNameOrPasswordException exception){
        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(exception.getMessage())
                .code(403)
                .success(Boolean.FALSE)
                .build();
        return ResponseEntity.status(403).body(errorResponse);
    }

    @ExceptionHandler(HttpClientErrorException.Forbidden.class)
    public ResponseEntity handleCustomForbiddenException(HttpClientErrorException.Forbidden ex) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(ex.getMessage())
                .code(403)
                .success(Boolean.FALSE)
                .build();
        return ResponseEntity.status(403).body(errorResponse);
    }
}

