package dev.rajnish.EcomProductService.service.interfaces;

import java.util.UUID;

import dev.rajnish.EcomProductService.dto.CartResponseDTO;
import dev.rajnish.EcomProductService.dto.ProductToCartDTO;
import dev.rajnish.EcomProductService.dto.RemoveProductFromCartRequestDTO;
import dev.rajnish.EcomProductService.dto.UpdateCartProductQuantityDTO;

public interface CartService {

    CartResponseDTO addNewCart(String name,UUID userId);
    CartResponseDTO getCartDetailsById(UUID cartId,String token);
    boolean addProductToCart(ProductToCartDTO productToCartDTO,String token);
    boolean updateCartProductQuantity(UpdateCartProductQuantityDTO updateCartProductQuantityDTO,String token);
    boolean removeProductFromCart(RemoveProductFromCartRequestDTO removeProductFromCartRequestDTO,String token);    
}
