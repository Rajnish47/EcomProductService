package dev.rajnish.EcomProductService.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.rajnish.EcomProductService.client.AuthServiceClient;
import dev.rajnish.EcomProductService.dto.CreateProductRequestDTO;
import dev.rajnish.EcomProductService.dto.ProductResponseDTO;
import dev.rajnish.EcomProductService.entity.Category;
import dev.rajnish.EcomProductService.entity.Product;
import dev.rajnish.EcomProductService.exceptions.UnauthorisedException;
import dev.rajnish.EcomProductService.exceptions.ProductControllerExceptions.NoProductPresentException;
import dev.rajnish.EcomProductService.exceptions.ProductControllerExceptions.ProductNotFoundException;
import dev.rajnish.EcomProductService.mapper.DtoToEntityMapper;
import dev.rajnish.EcomProductService.mapper.EntityToDTOMapper;
import dev.rajnish.EcomProductService.repository.ProductRepository;
import dev.rajnish.EcomProductService.service.interfaces.CategoryService;
import dev.rajnish.EcomProductService.service.interfaces.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private AuthServiceClient authServiceClient;

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
    public ProductResponseDTO getProduct(UUID productId) throws ProductNotFoundException {
        Product savedProduct = productRepository.findById(productId).get();
        if(savedProduct==null)
        {
            throw new ProductNotFoundException("No product with id: "+productId);
        }
        ProductResponseDTO productResponseDTO = EntityToDTOMapper.productToDTOMapper(savedProduct);

        return productResponseDTO;
    }

    @Override
    public ProductResponseDTO createProduct(CreateProductRequestDTO productDTO,String token) throws UnauthorisedException {
        authServiceClient.authenticateUser(token, "Admin");
        Product product = DtoToEntityMapper.productDtoToEntity(productDTO);
        UUID categoryId = productDTO.getCategoryID();
        Category savedCategory = categoryService.getCategoryById(categoryId);
        product.setCategory(savedCategory);
        Product savedProduct = productRepository.save(product);
        List<Product> savedCategoryProducts = savedCategory.getProducts();
        if(savedCategoryProducts==null)
        {
            savedCategoryProducts = new ArrayList<>();
        }

        savedCategoryProducts.add(savedProduct);
        categoryService.updateCategory(savedCategory);
        ProductResponseDTO productResponseDTO = EntityToDTOMapper.productToDTOMapper(savedProduct);

        return productResponseDTO;
    }

    @Override
    public ProductResponseDTO updateProduct(CreateProductRequestDTO updatedProduct, UUID productId,String token) throws UnauthorisedException {
        
        authServiceClient.authenticateUser(token, "Admin");
        Product savedProduct = productRepository.findById(productId).get();
        savedProduct.setTitle(updatedProduct.getTitle());
        savedProduct.setPrice(updatedProduct.getPrice());
        savedProduct.setDescription(updatedProduct.getDescription());
        savedProduct.setImageUrl(updatedProduct.getImageURL());
        savedProduct.setRating(updatedProduct.getRating());
        savedProduct.setQuantity(updatedProduct.getQuantity());;

        productRepository.save(savedProduct);

        return EntityToDTOMapper.productToDTOMapper(savedProduct);
    }

    @Override
    public boolean deleteProduct(UUID productId,String token) throws UnauthorisedException {

        authServiceClient.authenticateUser(token, "Admin");
        Product savedProduct = productRepository.findById(productId).get();
        if(savedProduct!=null)
        {
            Category savedCategory = savedProduct.getCategory();
            List<Product> savedCategoryProducts = savedCategory.getProducts();
            savedCategoryProducts.remove(savedProduct);
            savedCategory.setProducts(savedCategoryProducts);
            categoryService.updateCategory(savedCategory);
        }
        productRepository.deleteById(productId);
        return true;
    }

    @Override
    public ProductResponseDTO getProduct(String productName) throws ProductNotFoundException {
        Product savedProduct = productRepository.findProductByTitle(productName);
        if(savedProduct==null)
        {
            throw new ProductNotFoundException("No product with title: "+productName);
        }

        return EntityToDTOMapper.productToDTOMapper(savedProduct);
    }

    @Override
    public List<ProductResponseDTO> getProducts(double minPrice, double maxPrice) throws NoProductPresentException {

        List<Product> savedProducts = productRepository.findByPriceBetween(maxPrice, minPrice);

        if(savedProducts==null)
        {
            throw new NoProductPresentException("No product in the given price range");
        }
        
        List<ProductResponseDTO> products = new ArrayList<>();
        for(Product savedProduct: savedProducts)
        {
            products.add(EntityToDTOMapper.productToDTOMapper(savedProduct));
        }

        return products;
    }

    @Override
    public List<ProductResponseDTO> getProductsByCategory(String categoryName) throws NoProductPresentException {

        List<Product> savedProducts = productRepository.findByCategoryName(categoryName);
        if(savedProducts==null)
        {
            throw new NoProductPresentException("No product in the given category");
        }

        List<ProductResponseDTO> products = new ArrayList<>();

        for(Product savedProduct: savedProducts)
        {
            products.add(EntityToDTOMapper.productToDTOMapper(savedProduct));
        }

        return products;
    }    
}
