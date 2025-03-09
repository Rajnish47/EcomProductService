package dev.rajnish.EcomProductService.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.rajnish.EcomProductService.entity.Cart;


@Repository
public interface CartRepository extends JpaRepository<Cart,UUID> {

    Cart findByUserId(UUID userId);    
}
