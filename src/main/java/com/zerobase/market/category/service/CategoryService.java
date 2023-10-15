package com.zerobase.market.category.service;

import com.zerobase.market.category.domain.Category;
import com.zerobase.market.category.dto.CategoryDto;
import com.zerobase.market.category.dto.CategoryRequest;
import com.zerobase.market.category.exception.CategoryException;
import com.zerobase.market.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Page<Category> categoryList(final Pageable pageable){
        return categoryRepository.findAll(pageable);
    }

    public CategoryDto registCategory(CategoryDto categoryDto) {
        boolean nameCheck = categoryRepository.existsByName(categoryDto.getName());

        if(nameCheck){
            throw new CategoryException();
        }else{
            return CategoryDto.builder()
                    .name(categoryDto.getName())
                    .registDate(LocalDateTime.now())
                    .updateDate(LocalDateTime.now())
                    .build();
        }
    }

    public CategoryDto viewCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new CategoryException());
        return CategoryDto.from(category);
    }

    public CategoryDto updateCategory(Long categoryId, CategoryRequest categoryRequest) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new CategoryException());
        category.updateCategory(categoryRequest);
        return CategoryDto.from(category);
    }

    public Long deleteCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new CategoryException());
        return categoryRepository.deleteCategory(category.getId());
    }


}
