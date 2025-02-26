package dev.rajnish.EcomProductService.dto;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateCartProductQuantityDTO {

    private UUID cartProductId;
    private int quantity;    
}
