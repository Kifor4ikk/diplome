package ru.kifor4ik.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import ru.kifor4ik.util.ExceptionDto;

@RestControllerAdvice
public class ExceptionController {


    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String badRequest(Exception exception, WebRequest request) {
        System.out.println("HERE!");

        return "Cause: " + exception.getMessage();
    }

    @ExceptionHandler({org.postgresql.util.PSQLException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String sqlException(org.postgresql.util.PSQLException exception, WebRequest request) {
        return "Cause: " + exception.getMessage();
    }
}
