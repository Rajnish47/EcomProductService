package dev.rajnish.EcomProductService.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// @Entity(name="ECOM_CATEGORY")
public class Category extends BaseModel {

    private String name;
    
}
