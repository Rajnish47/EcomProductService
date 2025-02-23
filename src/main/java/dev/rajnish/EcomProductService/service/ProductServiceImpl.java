package dev.rajnish.EcomProductService.service;

import java.util.ArrayList;
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
        List<ProductResponseDTO> products = new ArrayList<>();
        List<Product> savedProducts = productRepository.findAll();
        for(Product savedProduct: savedProducts)
        {
            products.add(EntityToDTOMapper.productToDTOMapper(savedProduct));
        }

        return products;
    }

    @Override
    public ProductResponseDTO getProduct(UUID productId) {
        Product savedProduct = productRepository.findById(productId).get();
        ProductResponseDTO productResponseDTO = EntityToDTOMapper.productToDTOMapper(savedProduct);

        return productResponseDTO;
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

        Product savedProduct = productRepository.findById(productId).get();
        savedProduct.setTitle(updatedProduct.getTitle());
        savedProduct.setPrice(updatedProduct.getPrice());
        savedProduct.setDescription(updatedProduct.getDescription());
        savedProduct.setImageUrl(updatedProduct.getImageURL());
        savedProduct.setRating(updatedProduct.getRating());

        productRepository.save(savedProduct);

        return EntityToDTOMapper.productToDTOMapper(savedProduct);
    }

    @Override
    public boolean deleteProduct(UUID productId) {

        productRepository.deleteById(productId);
        return true;
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
