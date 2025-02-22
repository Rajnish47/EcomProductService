package dev.rajnish.EcomProductService.exceptions;

public class NoProductPresentException extends RuntimeException {

    public NoProductPresentException()
    {

    }

    public NoProductPresentException(String message)
    {
        super(message);
    }
    
}
