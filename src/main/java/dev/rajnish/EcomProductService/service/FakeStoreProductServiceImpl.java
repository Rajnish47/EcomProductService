package dev.rajnish.EcomProductService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.rajnish.EcomProductService.client.FakeStoreClient;
import dev.rajnish.EcomProductService.dto.FakeStoreDTO.FakeStoreProductResponseDTO;
import dev.rajnish.EcomProductService.exceptions.ProductControllerExceptions.NoProductPresentException;
import dev.rajnish.EcomProductService.exceptions.ProductControllerExceptions.ProductNotFoundException;

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
