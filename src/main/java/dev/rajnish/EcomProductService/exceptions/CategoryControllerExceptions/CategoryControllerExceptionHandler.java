package dev.rajnish.EcomProductService.exceptions.CategoryControllerExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import dev.rajnish.EcomProductService.controller.CategoryController;
import dev.rajnish.EcomProductService.dto.ExceptionResponseDTO;
import dev.rajnish.EcomProductService.exceptions.UnauthorisedException;

@ControllerAdvice(basePackageClasses= CategoryController.class)
public class CategoryControllerExceptionHandler {

    @ExceptionHandler(CategoryNotPresentException.class)
    public ResponseEntity handleCategoryNotPresentException(CategoryNotPresentException pe)
    {
        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(pe.getMessage(), 404);
        return new ResponseEntity<>(exceptionResponseDTO,HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(UnauthorisedException.class)
    public ResponseEntity handleUnauthorisedException(UnauthorisedException e)
    {
        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(e.getMessage(), 401);
        return new ResponseEntity<>(exceptionResponseDTO,HttpStatus.UNAUTHORIZED);
    }
}
