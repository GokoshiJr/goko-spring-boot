package com.goko.HandleException.controllers;

import com.goko.HandleException.exceptions.UserNotFoundException;
import com.goko.HandleException.models.dtos.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ErrorHandlerController {

    @ExceptionHandler({NullPointerException.class, HttpMessageNotWritableException.class, UserNotFoundException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> nullPointerException(Exception exception) {
        Map<String, Object> res = new HashMap<>();
        res.put("Date", new Date());
        res.put("Error", "No existe el objeto buscado");
        res.put("Message", exception.getMessage());
        res.put("Status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return res;
    }

    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> numberFormatException(Exception exception) {
        Map<String, Object> res = new HashMap<>();
        res.put("Date", new Date());
        res.put("Error", "Error al formatear el numero");
        res.put("Message", exception.getMessage());
        res.put("Status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return res;
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<ErrorDTO> notFound(Exception exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND.value())
                .body(new ErrorDTO(
                        exception.getMessage(),
                        "La ruta no existe",
                        HttpStatus.NOT_FOUND.value(),
                        new Date())
                );
    }

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ErrorDTO> error(Exception exception) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .body(new ErrorDTO(
                        exception.getMessage(),
                        "dividiendo por cero",
                        HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        new Date())
                );
    }
}
