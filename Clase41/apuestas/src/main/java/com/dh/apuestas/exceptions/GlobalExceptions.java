package com.dh.apuestas.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptions {

    @ExceptionHandler({InvalidIDException.class})
    public ResponseEntity<ErrorMessage> procesarErrorBadRequest(InvalidIDException ex){
        ErrorMessage message = new ErrorMessage();
        message.setMessage("Ups ocurrio un error.. Lo sentimos mucho");
        message.setDescription(ex.getMessage());
        message.setStatusCode(1001);
        System.out.println("eeeeappppa tiene un error");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    }


}
