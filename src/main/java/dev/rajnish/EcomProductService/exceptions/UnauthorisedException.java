package dev.rajnish.EcomProductService.exceptions;

public class UnauthorisedException extends RuntimeException {

    public UnauthorisedException(String message)
    {
        super(message);
    }    
}
