package dev.rajnish.EcomProductService.dto;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDTO {
    private UUID productId;
    private String title;
    private double price;
    private String description;
    private String category;
    private String imageURL;
    private double rating;    
}
