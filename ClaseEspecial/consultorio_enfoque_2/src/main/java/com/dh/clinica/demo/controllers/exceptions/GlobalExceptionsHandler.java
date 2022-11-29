package com.dh.clinica.demo.controllers.exceptions;

import com.dh.clinica.demo.exceptions.EntityNotFoundException;
import com.dh.clinica.demo.exceptions.IntegrityDataException;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionsHandler {

    private final Logger logger = Logger.getLogger(GlobalExceptionsHandler.class);

    @ExceptionHandler({IntegrityDataException.class})
    public ResponseEntity<Error> procesarErrorBadRequest(IntegrityDataException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(handlerException(ex));
    }

    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<Error> procesarErrorNotFound(EntityNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                handlerException(ex)
        );
    }

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<Error> procesarAnyException(RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(handlerException(ex));
    }

    private Error handlerException(Throwable ex){
        logger.error(ex.getMessage());
        return new Error( ex.getClass().getSimpleName(), ex.getMessage());
    }

}
