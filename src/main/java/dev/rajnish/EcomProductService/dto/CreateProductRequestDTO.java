package dev.rajnish.EcomProductService.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductRequestDTO {
    private String title;
    private double price;
    private String description;
    private String imageURL;
    private double rating;    
}
