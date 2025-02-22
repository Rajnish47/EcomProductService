package dev.rajnish.EcomProductService.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.rajnish.EcomProductService.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,UUID> {
    
}
