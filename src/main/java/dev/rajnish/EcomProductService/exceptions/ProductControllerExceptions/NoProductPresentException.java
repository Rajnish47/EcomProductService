package dev.rajnish.EcomProductService.exceptions.ProductControllerExceptions;

public class NoProductPresentException extends RuntimeException {

    public NoProductPresentException()
    {

    }

    public NoProductPresentException(String message)
    {
        super(message);
    }
    
}
