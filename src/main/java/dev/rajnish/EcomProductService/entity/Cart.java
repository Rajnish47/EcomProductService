package dev.rajnish.EcomProductService.entity;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Cart extends BaseModel {

    private UUID userId;
    private String cartName;
    @OneToMany
    private List<CartProduct> cartProducts;
    private int totalProducts;    
}
