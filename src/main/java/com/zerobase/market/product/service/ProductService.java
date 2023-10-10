package com.zerobase.market.product.service;

import com.zerobase.market.category.domain.Category;
import com.zerobase.market.category.exception.CategoryException;
import com.zerobase.market.category.repository.CategoryRepository;
import com.zerobase.market.product.domain.Product;
import com.zerobase.market.product.dto.ProductDto;
import com.zerobase.market.product.repository.ProductRepository;
import com.zerobase.market.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    private final UserRepository userRepository;

    private final CategoryRepository categoryRepository;

    public ProductDto save(Long categoryId , ProductDto productDto){

        final Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CategoryException());

        Product product = Product.builder()
                 .name(productDto.getName())
                 .price(productDto.getPrice())
                 .stock(productDto.getStock())
                 .status(productDto.getStatus())
                 .category(category)
                 .registDate(LocalDateTime.now())
                 .updateDate(LocalDateTime.now())
                .build();

        productRepository.save(product);

        return productDto;
    }

}
