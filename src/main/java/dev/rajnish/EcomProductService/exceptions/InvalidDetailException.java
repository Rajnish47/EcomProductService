package dev.rajnish.EcomProductService.exceptions;

public class InvalidDetailException extends RuntimeException {

    public InvalidDetailException()
    {

    }

    public InvalidDetailException(String message)
    {
        super(message);
    }    
}
