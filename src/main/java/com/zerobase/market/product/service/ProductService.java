package com.zerobase.market.product.service;

import com.zerobase.market.category.domain.Category;
import com.zerobase.market.category.exception.CategoryException;
import com.zerobase.market.category.repository.CategoryRepository;
import com.zerobase.market.product.domain.Product;
import com.zerobase.market.product.dto.ProductDto;
import com.zerobase.market.product.exception.ProductException;
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

    public ProductDto registProduct(ProductDto productDto){

        final Category category = categoryRepository.findById(productDto.getCategoryId())
                .orElseThrow(() -> new CategoryException());

        Product product = productRepository.save(
                Product.builder()
                .name(productDto.getName())
                .price(productDto.getPrice())
                .stock(productDto.getStock())
                .status(productDto.getStatus())
                .category(category)
                .registDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build()
        );

        return ProductDto.from(product);
    }

    public ProductDto viewProduct(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new ProductException());
        return ProductDto.from(product);

    }
}
