package dev.rajnish.EcomProductService.mapper;

import dev.rajnish.EcomProductService.dto.CategoryResponseDTO;
import dev.rajnish.EcomProductService.dto.ProductResponseDTO;
import dev.rajnish.EcomProductService.entity.Category;
import dev.rajnish.EcomProductService.entity.Product;

public class EntityToDTOMapper {
    
    public static ProductResponseDTO productToDTOMapper(Product product)
    {
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setProductId(product.getId());
        productResponseDTO.setTitle(product.getTitle());
        productResponseDTO.setDescription(product.getDescription());
        productResponseDTO.setImageURL(product.getImageUrl());
        productResponseDTO.setRating(product.getRating());
        productResponseDTO.setPrice(product.getPrice());
        productResponseDTO.setCategory(product.getCategory().getName());

        return productResponseDTO;        
    }

    public static CategoryResponseDTO categoryToDTOMapper(Category category)
    {
        CategoryResponseDTO categoryResponseDTO = new CategoryResponseDTO();
        categoryResponseDTO.setName(category.getName());
        categoryResponseDTO.setId(category.getId());

        return categoryResponseDTO;        
    }
}
