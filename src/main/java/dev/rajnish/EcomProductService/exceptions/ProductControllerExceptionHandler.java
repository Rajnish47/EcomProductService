package dev.rajnish.EcomProductService.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import dev.rajnish.EcomProductService.controller.ProductController;
import dev.rajnish.EcomProductService.dto.ExceptionResponseDTO;

@ControllerAdvice(basePackageClasses = ProductController.class)
public class ProductControllerExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity handleProductNotFoundException(ProductNotFoundException pe)
    {
        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(pe.getMessage(), 404);

        return new ResponseEntity<>(exceptionResponseDTO,HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(NoProductPresentException.class)
    public ResponseEntity handleNoProductsPresentException(NoProductPresentException pe)
    {
        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(pe.getMessage(), 404);

        return new ResponseEntity<>(exceptionResponseDTO,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidDetailException.class)
    public ResponseEntity handleInvalidDetailException(InvalidDetailException pe)
    {
        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(pe.getMessage(), 400);

        return new ResponseEntity<>(exceptionResponseDTO,HttpStatus.BAD_REQUEST);
    }
}
