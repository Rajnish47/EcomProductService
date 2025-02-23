package dev.rajnish.EcomProductService.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.rajnish.EcomProductService.dto.CreateProductRequestDTO;
import dev.rajnish.EcomProductService.dto.ProductResponseDTO;
import dev.rajnish.EcomProductService.exceptions.InvalidDetailException;
import dev.rajnish.EcomProductService.service.interfaces.ProductService;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity getAllProducts()
    {
        List<ProductResponseDTO> products = productService.getAllProducts();
        return ResponseEntity.ok(products);        
    }

    @GetMapping("/product/{id}")
    public ResponseEntity getProductById(@PathVariable("id") UUID id)
    {
        if(id==null)
        {
            throw new InvalidDetailException("Invalid product id");
        }
        ProductResponseDTO product = productService.getProduct(id);
        return ResponseEntity.ok(product);
    }

    @PostMapping("/product/add")
    public ResponseEntity addNewProduct(@RequestBody CreateProductRequestDTO createProductRequestDTO)
    {
        ProductResponseDTO productResponseDTO = productService.createProduct(createProductRequestDTO);
        return ResponseEntity.ok(productResponseDTO);
    }

    @PutMapping("/product/update/{id}")
    public ResponseEntity updateProduct(@PathVariable("id") UUID productId,@RequestBody CreateProductRequestDTO updateProductRequestDTO)
    {
        ProductResponseDTO updatedProduct = productService.updateProduct(updateProductRequestDTO, productId);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/product/delete/{id}")
    public ResponseEntity deleteProduct(@PathVariable("id") UUID productId)
    {
        productService.deleteProduct(productId);
        return ResponseEntity.ok("Product deleted");
    }
}
