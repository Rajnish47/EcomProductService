package dev.rajnish.EcomProductService.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.rajnish.EcomProductService.dto.CreateProductRequestDTO;
import dev.rajnish.EcomProductService.dto.ProductResponseDTO;
import dev.rajnish.EcomProductService.exceptions.ProductControllerExceptions.InvalidDetailException;
import dev.rajnish.EcomProductService.service.interfaces.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public ResponseEntity getAllProducts()
    {
        List<ProductResponseDTO> products = productService.getAllProducts();
        return ResponseEntity.ok(products);        
    }

    @GetMapping("/{id}")
    public ResponseEntity getProductById(@PathVariable("id") UUID id)
    {
        if(id==null)
        {
            throw new InvalidDetailException("Invalid product id");
        }
        ProductResponseDTO product = productService.getProduct(id);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/title/{title}")
    public ResponseEntity getProductByTitle(@PathVariable("title") String title)
    {
        if(title==null || title.isEmpty() || title.isBlank())
        {
            throw new InvalidDetailException("Please provide a proper product name");            
        }

        ProductResponseDTO productResponseDTO = productService.getProduct(title);

        return ResponseEntity.ok(productResponseDTO);
    }

    @GetMapping("/price/{max_price}/{min_price}")
    public ResponseEntity getProductsBetweenPriceRange(@PathVariable("max_price") double max_price,@PathVariable("min_price") double min_price)
    {
        List<ProductResponseDTO> products = productService.getProducts(max_price, min_price);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/category/{name}")
    public ResponseEntity getProductsByCategory(@PathVariable("name") String categoryName)
    {
        List<ProductResponseDTO> products = productService.getProductsByCategory(categoryName);
        return ResponseEntity.ok(products);
    }

    //below conteoller methods require authentication, role required is admin

    @PostMapping("/add")
    public ResponseEntity addNewProduct(@RequestBody CreateProductRequestDTO createProductRequestDTO,@RequestHeader(HttpHeaders.AUTHORIZATION) String token)
    {
        ProductResponseDTO productResponseDTO = productService.createProduct(createProductRequestDTO,token);
        return ResponseEntity.ok(productResponseDTO);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateProduct(@PathVariable("id") UUID productId,@RequestBody CreateProductRequestDTO updateProductRequestDTO,@RequestHeader(HttpHeaders.AUTHORIZATION) String token)
    {
        ProductResponseDTO updatedProduct = productService.updateProduct(updateProductRequestDTO, productId,token);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProduct(@PathVariable("id") UUID productId,@RequestHeader(HttpHeaders.AUTHORIZATION) String token)
    {
        productService.deleteProduct(productId,token);
        return ResponseEntity.ok("Product deleted");
    }
}
