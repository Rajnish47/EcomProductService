package dev.rajnish.EcomProductService.mapper;

import dev.rajnish.EcomProductService.dto.CreateProductRequestDTO;
import dev.rajnish.EcomProductService.entity.Product;

public class DtoToEntityMapper {
    
    public static Product productDtoToEntity(CreateProductRequestDTO createProductRequestDTO)
    {
        Product product = new Product();
        product.setTitle(createProductRequestDTO.getTitle());
        product.setDescription(createProductRequestDTO.getDescription());
        product.setPrice(createProductRequestDTO.getPrice());
        product.setImageUrl(createProductRequestDTO.getImageURL());
        product.setRating(createProductRequestDTO.getRating());

        return product;        
    }
}
