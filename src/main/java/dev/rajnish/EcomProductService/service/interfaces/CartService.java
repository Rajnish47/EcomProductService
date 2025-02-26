package dev.rajnish.EcomProductService.service.interfaces;

import java.util.UUID;

import dev.rajnish.EcomProductService.dto.CartResponseDTO;
import dev.rajnish.EcomProductService.dto.ProductToCartDTO;

public interface CartService {

    CartResponseDTO addNewCart(String name);
    CartResponseDTO getCartDetailsById(UUID cartId);
    boolean addProductToCart(ProductToCartDTO productToCartDTO);
    boolean removeProductFromCart(ProductToCartDTO productToCartDTO);    
}
