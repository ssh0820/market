package com.zerobase.market.category.repository;

import com.zerobase.market.category.domain.Category;
import com.zerobase.market.category.dto.CategorySearch;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryCustomRepository {

    List<Category> searchCategory(Pageable pageable, CategorySearch categorySearch);

    Long deleteCategory(Long categoryId);
}
