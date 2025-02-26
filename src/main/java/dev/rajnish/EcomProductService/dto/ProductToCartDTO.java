package dev.rajnish.EcomProductService.dto;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductToCartDTO {

    private UUID cartId;
    private UUID productId;
    private int productQuantity; 
}
