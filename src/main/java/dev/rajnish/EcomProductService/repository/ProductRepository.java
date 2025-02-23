package dev.rajnish.EcomProductService.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.rajnish.EcomProductService.entity.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product,UUID> {

    Product findProductByTitle(String title);
    List<Product> findByPriceBetween(double maxPrice,double minPrice);    
    List<Product> findByCategoryName(String category);
}
