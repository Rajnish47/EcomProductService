package dev.rajnish.EcomProductService.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.rajnish.EcomProductService.entity.CartProduct;

@Repository
public interface CartProductRepository extends JpaRepository<CartProduct,UUID> {
    
}
