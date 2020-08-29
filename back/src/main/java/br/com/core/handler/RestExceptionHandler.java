package br.com.core.handler;

import br.com.core.error.ResourceNotFoundDetails;
import br.com.core.error.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException rfnExcepcion){
        ResourceNotFoundDetails rnfDetails = ResourceNotFoundDetails.Builder.newBuilder()
                .timestamp(new Date().getTime())
                .status(HttpStatus.NOT_FOUND.value())
                .title("Resource not found")
                .detail(rfnExcepcion.getMessage())
                .developerMessage(rfnExcepcion.getClass().getName())
                .build();
        return new ResponseEntity<>(rnfDetails,HttpStatus.NOT_FOUND);
    }
}
