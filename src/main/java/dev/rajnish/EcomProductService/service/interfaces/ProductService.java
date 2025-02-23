package dev.rajnish.EcomProductService.service.interfaces;

import java.util.List;
import java.util.UUID;

import dev.rajnish.EcomProductService.dto.CreateProductRequestDTO;
import dev.rajnish.EcomProductService.dto.ProductResponseDTO;
import dev.rajnish.EcomProductService.exceptions.ProductControllerExceptions.NoProductPresentException;
import dev.rajnish.EcomProductService.exceptions.ProductControllerExceptions.ProductNotFoundException;

public interface ProductService {

    List<ProductResponseDTO> getAllProducts();
    ProductResponseDTO getProduct(UUID productId) throws ProductNotFoundException;
    ProductResponseDTO createProduct(CreateProductRequestDTO productDTO);
    ProductResponseDTO updateProduct(CreateProductRequestDTO updatedProduct, UUID productId);
    boolean deleteProduct(UUID productId);
    ProductResponseDTO getProduct(String productName) throws ProductNotFoundException;
    List<ProductResponseDTO> getProducts(double minPrice, double maxPrice) throws NoProductPresentException;
    List<ProductResponseDTO> getProductsByCategory(String categoryName) throws NoProductPresentException;
    
}
