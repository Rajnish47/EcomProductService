package dev.rajnish.EcomProductService.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.rajnish.EcomProductService.dto.CategoryResponseDTO;
import dev.rajnish.EcomProductService.dto.CreateCategoryRequestDTO;
import dev.rajnish.EcomProductService.service.interfaces.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/add")
    public ResponseEntity createNewCategory(@RequestBody CreateCategoryRequestDTO createCategoryRequestDTO)
    {
        CategoryResponseDTO categoryResponseDTO = categoryService.createNewCategory(createCategoryRequestDTO);
        return ResponseEntity.ok(categoryResponseDTO);
    }

    @GetMapping("/all")
    public ResponseEntity getAllCategories()
    {
        List<CategoryResponseDTO> categorys = categoryService.getAllCategories();
        return ResponseEntity.ok(categorys);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity getCategoryByName(@PathVariable("name") String categoryName)
    {
        //TODO:Add exception handeling
        return ResponseEntity.ok(categoryService.findCategoryByName(categoryName));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity getCategoryById(@PathVariable("id") UUID id)
    {
        //TODO:Add exception handeling
        return ResponseEntity.ok(categoryService.findCategoryById(id));
    }
    
}
