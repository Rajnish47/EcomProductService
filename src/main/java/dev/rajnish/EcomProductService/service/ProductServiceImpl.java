package dev.rajnish.EcomProductService.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.rajnish.EcomProductService.dto.CreateProductRequestDTO;
import dev.rajnish.EcomProductService.dto.ProductResponseDTO;
import dev.rajnish.EcomProductService.entity.Product;
import dev.rajnish.EcomProductService.mapper.DtoToEntityMapper;
import dev.rajnish.EcomProductService.mapper.EntityToDTOMapper;
import dev.rajnish.EcomProductService.repository.ProductRepository;
import dev.rajnish.EcomProductService.service.interfaces.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllProducts'");
    }

    @Override
    public ProductResponseDTO getProduct(int productId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProduct'");
    }

    @Override
    public ProductResponseDTO createProduct(CreateProductRequestDTO productDTO) {
        Product product = DtoToEntityMapper.productDtoToEntity(productDTO);
        Product savedProduct = productRepository.save(product);
        ProductResponseDTO productResponseDTO = EntityToDTOMapper.productToDTOMapper(savedProduct);

        return productResponseDTO;
    }

    @Override
    public ProductResponseDTO updateProduct(CreateProductRequestDTO updatedProduct, UUID productId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateProduct'");
    }

    @Override
    public boolean deleteProduct(UUID productId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteProduct'");
    }

    @Override
    public ProductResponseDTO getProduct(String productName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProduct'");
    }

    @Override
    public List<Product> getProducts(double minPrice, double maxPrice) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProducts'");
    }

    
    
}
