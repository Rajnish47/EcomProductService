package dev.rajnish.EcomProductService.dto;

import java.util.List;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartResponseDTO {

    private UUID cartID;
    private String cartName;
    private List<CartProductResponseDTO> cartProducts;    
}
