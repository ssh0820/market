package com.zerobase.market.product.repository;

import com.zerobase.market.product.domain.Product;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductCustomRepository {

    public Product regisProduct(Product product);

    public List<Product> searchProduct(Pageable pageable);

    public Optional<Product> findById(Long id);

    public Product updateProduct(Product productDto);

    public Long deleteProduct(Long id);

}
