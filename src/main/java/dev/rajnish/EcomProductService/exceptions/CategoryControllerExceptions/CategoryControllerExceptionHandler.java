package dev.rajnish.EcomProductService.exceptions.CategoryControllerExceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import dev.rajnish.EcomProductService.controller.CategoryController;
import dev.rajnish.EcomProductService.dto.ExceptionResponseDTO;

@ControllerAdvice(basePackageClasses= CategoryController.class)
public class CategoryControllerExceptionHandler {

    @ExceptionHandler(CategoryNotPresentException.class)
    public ResponseEntity handleCategoryNotPresentException(CategoryNotPresentException pe)
    {
        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(pe.getMessage(), 404);
        return ResponseEntity.ok(exceptionResponseDTO);
    }    
}
