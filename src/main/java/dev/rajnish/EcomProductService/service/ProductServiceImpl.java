package dev.rajnish.EcomProductService.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.rajnish.EcomProductService.client.FakeStoreClient;
import dev.rajnish.EcomProductService.dto.CreateProductRequestDTO;
import dev.rajnish.EcomProductService.dto.ProductResponseDTO;
import dev.rajnish.EcomProductService.dto.FakeStoreDTO.FakeStoreProductResponseDTO;
import dev.rajnish.EcomProductService.entity.Product;
import dev.rajnish.EcomProductService.exceptions.ProductNotFoundException;
import dev.rajnish.EcomProductService.service.interfaces.ProductService;

@Service
public class ProductServiceImpl implements ProductService{


    @Autowired
    private FakeStoreClient fakeStoreClient;

    @Override
    public List<FakeStoreProductResponseDTO> getAllProducts() {

        List<FakeStoreProductResponseDTO> products = fakeStoreClient.getAllProducts();
        return products;
    }

    @Override
    public FakeStoreProductResponseDTO getProduct(int productId) throws ProductNotFoundException {
        FakeStoreProductResponseDTO product = fakeStoreClient.getProductById(productId);
        if(product==null)
        {
            throw new ProductNotFoundException("Product not found with id "+productId);
        }

        return product;
    }

    @Override
    public ProductResponseDTO createProduct(CreateProductRequestDTO product) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createProduct'");
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
