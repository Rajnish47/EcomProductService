package dev.rajnish.EcomProductService.mapper;

import java.util.ArrayList;
import java.util.List;

import dev.rajnish.EcomProductService.dto.CartProductResponseDTO;
import dev.rajnish.EcomProductService.dto.CartResponseDTO;
import dev.rajnish.EcomProductService.dto.CategoryResponseDTO;
import dev.rajnish.EcomProductService.dto.ProductResponseDTO;
import dev.rajnish.EcomProductService.entity.Cart;
import dev.rajnish.EcomProductService.entity.CartProduct;
import dev.rajnish.EcomProductService.entity.Category;
import dev.rajnish.EcomProductService.entity.Product;

public class EntityToDTOMapper {
    
    public static ProductResponseDTO productToDTOMapper(Product product)
    {
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setProductId(product.getId());
        productResponseDTO.setTitle(product.getTitle());
        productResponseDTO.setDescription(product.getDescription());
        productResponseDTO.setImageURL(product.getImageUrl());
        productResponseDTO.setRating(product.getRating());
        productResponseDTO.setPrice(product.getPrice());
        productResponseDTO.setCategory(product.getCategory().getName());

        return productResponseDTO;        
    }

    public static CategoryResponseDTO categoryToDTOMapper(Category category)
    {
        CategoryResponseDTO categoryResponseDTO = new CategoryResponseDTO();
        categoryResponseDTO.setName(category.getName());
        categoryResponseDTO.setId(category.getId());

        return categoryResponseDTO;        
    }

    public static CartResponseDTO cartToDTOMapper(Cart cart)
    {
        CartResponseDTO cartResponseDTO = new CartResponseDTO();
        cartResponseDTO.setCartID(cart.getId());
        cartResponseDTO.setCartName(cart.getCartName());
        List<CartProductResponseDTO> cartProductResponseDTOs = new ArrayList<>();
        if(cart.getCartProducts()!=null)
        {            
            for(CartProduct cartProduct: cart.getCartProducts())
            {
                CartProductResponseDTO cartProductResponseDTO = new CartProductResponseDTO();
                cartProductResponseDTO.setCartProductId(cartProduct.getId());
                cartProductResponseDTO.setProductName(cartProduct.getProduct().getTitle());
                cartProductResponseDTO.setQuantity(cartProduct.getQuantity());

                cartProductResponseDTOs.add(cartProductResponseDTO);
            }
        }
        cartResponseDTO.setCartProducts(cartProductResponseDTOs);

        return cartResponseDTO;
    }
}
