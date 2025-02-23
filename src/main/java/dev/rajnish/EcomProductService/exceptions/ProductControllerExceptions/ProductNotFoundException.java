package dev.rajnish.EcomProductService.exceptions.ProductControllerExceptions;

public class ProductNotFoundException extends RuntimeException {
    
    public ProductNotFoundException()
    {

    }

    public ProductNotFoundException(String message)
    {
        super(message);
    }
}
