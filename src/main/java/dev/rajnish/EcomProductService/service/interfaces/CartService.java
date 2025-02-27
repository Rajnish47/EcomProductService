package dev.rajnish.EcomProductService.service.interfaces;

import java.util.UUID;

import dev.rajnish.EcomProductService.dto.CartResponseDTO;
import dev.rajnish.EcomProductService.dto.ProductToCartDTO;
import dev.rajnish.EcomProductService.dto.RemoveProductFromCartRequestDTO;
import dev.rajnish.EcomProductService.dto.UpdateCartProductQuantityDTO;

public interface CartService {

    CartResponseDTO addNewCart(String name);
    CartResponseDTO getCartDetailsById(UUID cartId);
    boolean addProductToCart(ProductToCartDTO productToCartDTO);
    boolean updateCartProductQuantity(UpdateCartProductQuantityDTO updateCartProductQuantityDTO);
    boolean removeProductFromCart(RemoveProductFromCartRequestDTO removeProductFromCartRequestDTO);    
}
