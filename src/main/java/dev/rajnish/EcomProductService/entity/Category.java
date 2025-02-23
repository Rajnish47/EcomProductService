package dev.rajnish.EcomProductService.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="ECOM_CATEGORY")
public class Category extends BaseModel {

    private String name;
    @OneToMany
    private List<Product> products;
    
}
