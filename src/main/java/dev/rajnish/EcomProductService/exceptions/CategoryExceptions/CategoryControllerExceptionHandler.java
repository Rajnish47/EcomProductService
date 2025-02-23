package dev.rajnish.EcomProductService.exceptions.CategoryExceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;

import dev.rajnish.EcomProductService.controller.CategoryController;

@ControllerAdvice(basePackageClasses= CategoryController.class)
public class CategoryControllerExceptionHandler {
    
}
