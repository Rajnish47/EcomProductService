package dev.rajnish.EcomProductService.service.interfaces;

import java.util.List;
import java.util.UUID;

import dev.rajnish.EcomProductService.dto.CategoryResponseDTO;
import dev.rajnish.EcomProductService.dto.CreateCategoryRequestDTO;
import dev.rajnish.EcomProductService.entity.Category;
import dev.rajnish.EcomProductService.exceptions.CategoryExceptions.CategoryNotPresentException;

public interface CategoryService {
    
    List<CategoryResponseDTO> getAllCategories();
    CategoryResponseDTO createNewCategory(CreateCategoryRequestDTO createCategoryRequestDTO);
    Category getCategoryById(UUID categoryId) throws CategoryNotPresentException;
    CategoryResponseDTO findCategoryById(UUID categoryId) throws CategoryNotPresentException;
    CategoryResponseDTO findCategoryByName(String categoryName) throws CategoryNotPresentException;
    void updateCategory(Category updatedCategory);
}
