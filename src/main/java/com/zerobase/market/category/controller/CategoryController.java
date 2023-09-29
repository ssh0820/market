package com.zerobase.market.category.controller;

import com.zerobase.market.category.dto.CategoryDto;
import com.zerobase.market.category.dto.CategoryRequest;
import com.zerobase.market.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/list")
    public ResponseEntity<?> categoryList(final Pageable pageable){
        return ResponseEntity.ok(categoryService.categoryList(pageable));
    }

    @PostMapping("/")
    public ResponseEntity<?> registCategory(CategoryDto categoryDto){
        return ResponseEntity.ok(categoryService.registCategory(categoryDto));
    }

    @PostMapping("/{name}")
    public ResponseEntity<?> updateCategory(@PathVariable String name, CategoryRequest categoryRequest){
        return ResponseEntity.ok(categoryService.updateCategory(name, categoryRequest));
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<?> deleteCategory(@PathVariable String name){
        return ResponseEntity.ok(categoryService.deleteCategory(name));
    }

}
