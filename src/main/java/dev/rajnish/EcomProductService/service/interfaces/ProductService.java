package dev.rajnish.EcomProductService.service.interfaces;

import java.util.List;
import java.util.UUID;

import dev.rajnish.EcomProductService.dto.CreateProductRequestDTO;
import dev.rajnish.EcomProductService.dto.ProductResponseDTO;
import dev.rajnish.EcomProductService.entity.Product;

public interface ProductService {

    List<ProductResponseDTO> getAllProducts();
    ProductResponseDTO getProduct(UUID productId);
    ProductResponseDTO createProduct(CreateProductRequestDTO productDTO);
    ProductResponseDTO updateProduct(CreateProductRequestDTO updatedProduct, UUID productId);
    boolean deleteProduct(UUID productId);
    ProductResponseDTO getProduct(String productName);
    List<Product> getProducts(double minPrice, double maxPrice); 
    
}
