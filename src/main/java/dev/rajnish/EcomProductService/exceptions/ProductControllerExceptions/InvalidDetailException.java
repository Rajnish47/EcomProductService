package dev.rajnish.EcomProductService.exceptions.ProductControllerExceptions;

public class InvalidDetailException extends RuntimeException {

    public InvalidDetailException()
    {

    }

    public InvalidDetailException(String message)
    {
        super(message);
    }    
}
