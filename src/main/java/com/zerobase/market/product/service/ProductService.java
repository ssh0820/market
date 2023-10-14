package com.zerobase.market.product.service;

import com.zerobase.market.category.domain.Category;
import com.zerobase.market.category.exception.CategoryException;
import com.zerobase.market.category.repository.CategoryRepository;
import com.zerobase.market.product.domain.Product;
import com.zerobase.market.product.dto.ProductDto;
import com.zerobase.market.product.dto.ProductRequest;
import com.zerobase.market.product.exception.ProductException;
import com.zerobase.market.product.repository.ProductRepository;
import com.zerobase.market.user.exception.AuthException;
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

    public ProductDto registProduct(ProductDto productDto) {

        Category category = categoryRepository.findById(productDto.getCategoryId())
                .orElseThrow(() -> new CategoryException());

        Boolean authCheck = userRepository.findAdminByRole(productDto.getUserId());

        if (authCheck){
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
        }else{
            throw new AuthException();
        }
    }

    public ProductDto viewProduct(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new ProductException());
        return ProductDto.from(product);
    }

    public ProductDto updateProduct(Long productId, ProductRequest productRequest){
        Product product = productRepository.findById(productId).orElseThrow(() -> new ProductException());
        product.updateProduct(productRequest);
        return ProductDto.from(product);
    }

    public Long deleteProduct(Long productId){
        Product product = productRepository.findById(productId).orElseThrow(() -> new ProductException());
        return productRepository.deleteProduct(product.getId());
    }
}
