package dev.rajnish.EcomProductService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CartProduct extends BaseModel {

    @ManyToOne
    private Product product;
    private int quantity;    
}
