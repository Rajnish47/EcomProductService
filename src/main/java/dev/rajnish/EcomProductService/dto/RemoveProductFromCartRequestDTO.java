package dev.rajnish.EcomProductService.dto;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RemoveProductFromCartRequestDTO {

    private UUID cartId;
    private UUID cartProductId;    
}
