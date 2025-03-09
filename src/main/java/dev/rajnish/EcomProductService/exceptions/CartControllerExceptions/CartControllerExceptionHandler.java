package dev.rajnish.EcomProductService.exceptions.CartControllerExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import dev.rajnish.EcomProductService.controller.CartController;
import dev.rajnish.EcomProductService.dto.ExceptionResponseDTO;
import dev.rajnish.EcomProductService.exceptions.UnauthorisedException;

@ControllerAdvice(basePackageClasses = CartController.class)
public class CartControllerExceptionHandler {

    @ExceptionHandler(UnauthorisedException.class)
    public ResponseEntity handleUnauthorisedException(UnauthorisedException e)
    {
        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(e.getMessage(), 401);
        return new ResponseEntity<>(exceptionResponseDTO,HttpStatus.UNAUTHORIZED);
    }    
}
