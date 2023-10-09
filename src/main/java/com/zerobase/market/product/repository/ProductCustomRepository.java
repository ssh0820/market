package com.zerobase.market.product.repository;

import com.zerobase.market.product.domain.Product;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductCustomRepository {

    public Product save(Product product);

    public List<Product> findAll(Pageable pageable);

    public Optional<Product> findById(Long id);

    public Product update(Product productDto);

    public Long deleteById(Long id);

}
