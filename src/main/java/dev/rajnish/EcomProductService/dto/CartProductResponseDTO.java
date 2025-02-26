package dev.rajnish.EcomProductService.dto;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartProductResponseDTO {
    
    private UUID cartProductId;
    private String productName;
    private int quantity;
}
