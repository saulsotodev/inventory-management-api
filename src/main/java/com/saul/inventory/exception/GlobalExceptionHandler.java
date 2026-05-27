package com.saul.inventory.exception;

import com.saul.inventory.dto.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice // Intercepta los errores de todos los controladores de la API
public class GlobalExceptionHandler {

    // 1. Captura errores de validación de campos (@NotBlank, @Min, etc.)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDTO> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        ErrorResponseDTO errorResponse = new ErrorResponseDTO(
                "Error de validación en los datos enviados",
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now(),
                errors
        );

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    // 2. Captura cualquier otro fallo inesperado del sistema para que no muestre código feo
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleGlobalExceptions(Exception ex) {
        ErrorResponseDTO errorResponse = new ErrorResponseDTO(
                "Ocurrió un error interno en el servidor: " + ex.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                LocalDateTime.now(),
                null
        );

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    // 3. Captura errores específicos de recursos no encontrados (HTTP 404)
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleResourceNotFoundException(ResourceNotFoundException ex) {
        ErrorResponseDTO errorResponse = new ErrorResponseDTO(
                ex.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                LocalDateTime.now(),
                null
        );

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}