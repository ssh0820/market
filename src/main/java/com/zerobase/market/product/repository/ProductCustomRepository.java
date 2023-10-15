package com.zerobase.market.product.repository;

import com.zerobase.market.product.domain.Product;
import com.zerobase.market.product.dto.ProductRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductCustomRepository {

    public Product registProduct(Product product);

    public List<Product> searchProduct(Pageable pageable, ProductRequest productRequest);

    public Product updateProduct(Product product);

    public Long deleteProduct(Long id);

}
