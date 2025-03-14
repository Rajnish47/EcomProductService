package dev.rajnish.EcomProductService.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.rajnish.EcomProductService.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,UUID> {

    Category findByName(String name);    
}
