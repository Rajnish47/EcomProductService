package dev.rajnish.EcomProductService.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.rajnish.EcomProductService.dto.CategoryResponseDTO;
import dev.rajnish.EcomProductService.dto.CreateCategoryRequestDTO;
import dev.rajnish.EcomProductService.entity.Category;
import dev.rajnish.EcomProductService.exceptions.CategoryControllerExceptions.CategoryNotPresentException;
import dev.rajnish.EcomProductService.mapper.DtoToEntityMapper;
import dev.rajnish.EcomProductService.mapper.EntityToDTOMapper;
import dev.rajnish.EcomProductService.repository.CategoryRepository;
import dev.rajnish.EcomProductService.service.interfaces.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryResponseDTO> getAllCategories(){

        List<Category> savedCategories = categoryRepository.findAll();
        List<CategoryResponseDTO> categoryResponseDTOs = new ArrayList<>();

        for(Category savedCategory: savedCategories)
        {
            categoryResponseDTOs.add(EntityToDTOMapper.categoryToDTOMapper(savedCategory));
        }

        return categoryResponseDTOs;
    }

    @Override
    public CategoryResponseDTO createNewCategory(CreateCategoryRequestDTO createCategoryRequestDTO) {

        Category category = DtoToEntityMapper.categoryDTOToEntity(createCategoryRequestDTO);
        Category savedCategory = categoryRepository.save(category);
        CategoryResponseDTO categoryResponseDTO = EntityToDTOMapper.categoryToDTOMapper(savedCategory);

        return categoryResponseDTO;
    }

    @Override
    public CategoryResponseDTO findCategoryById(UUID categoryId) throws CategoryNotPresentException {
        Category savedCategory = categoryRepository.findById(categoryId).get();
        if(savedCategory==null)
        {
            throw new CategoryNotPresentException("No category present");
        }

        return EntityToDTOMapper.categoryToDTOMapper(savedCategory);
    }

    @Override
    public CategoryResponseDTO findCategoryByName(String categoryName) throws CategoryNotPresentException {

        Category savedCategory = categoryRepository.findByName(categoryName);
        if(savedCategory==null)
        {
            throw new CategoryNotPresentException("No category present");
        }

        return EntityToDTOMapper.categoryToDTOMapper(savedCategory);
    }

    @Override
    public void updateCategory(Category updatedCategory) {
        categoryRepository.save(updatedCategory);
    }

    @Override
    public Category getCategoryById(UUID categoryId) throws CategoryNotPresentException {
        Category savedCategory = categoryRepository.findById(categoryId).get();
        if(savedCategory==null)
        {
            throw new CategoryNotPresentException("No category present");
        }

        return savedCategory;
    }    
}
