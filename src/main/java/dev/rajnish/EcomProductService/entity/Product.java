package dev.rajnish.EcomProductService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Product extends BaseModel {

    private String title;
    private double price;
    private String description;
    @ManyToOne
    private Category category;
    private String imageUrl;
    private double rating;
    private int quantity;
}