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
import dev.rajnish.EcomProductService.exceptions.NoProductPresentException;
import dev.rajnish.EcomProductService.exceptions.ProductNotFoundException;
import dev.rajnish.EcomProductService.service.interfaces.ProductService;

@Service("fakeStoreProductService")
public class FakeStoreProductServiceImpl{


    @Autowired
    private FakeStoreClient fakeStoreClient;

    // @Override
    public List<FakeStoreProductResponseDTO> getAllProducts() throws NoProductPresentException {

        List<FakeStoreProductResponseDTO> products = fakeStoreClient.getAllProducts();
        if(products==null)
        {
            throw new ProductNotFoundException("No products present");
        }
        return products;
    }

    // @Override
    public FakeStoreProductResponseDTO getProduct(int productId) throws ProductNotFoundException {
        FakeStoreProductResponseDTO product = fakeStoreClient.getProductById(productId);
        if(product==null)
        {
            throw new ProductNotFoundException("Product not found with id "+productId);
        }

        return product;
    }
}
