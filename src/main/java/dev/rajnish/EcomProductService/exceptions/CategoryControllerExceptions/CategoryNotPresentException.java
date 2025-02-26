package dev.rajnish.EcomProductService.exceptions.CategoryControllerExceptions;

public class CategoryNotPresentException extends RuntimeException {

    public CategoryNotPresentException()
    {

    }

    public CategoryNotPresentException(String message)
    {
        super(message);
    }    
}
