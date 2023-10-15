package com.zerobase.market.product.controller;

import com.zerobase.market.product.dto.ProductDto;
import com.zerobase.market.product.dto.ProductRequest;
import com.zerobase.market.product.service.ProductService;
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
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/")
    public ResponseEntity<?> productList(Pageable pageable, ProductRequest productRequest){
        return ResponseEntity.ok(productService.productList(pageable, productRequest));
    }

    @GetMapping("/{productId}")
    public ResponseEntity<?> viewProduct(@PathVariable Long productId){
        return ResponseEntity.ok(productService.viewProduct(productId));
    }

    @PostMapping("/")
    public ResponseEntity<?> registProduct(ProductDto productDto){
        return ResponseEntity.ok(productService.registProduct(productDto));
    }

    @PostMapping("/{productId}")
    public ResponseEntity<?> updateProduct(@PathVariable Long productId, ProductRequest productRequest){
        return ResponseEntity.ok(productService.updateProduct(productId, productRequest));
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long productId){
        return ResponseEntity.ok(productService.deleteProduct(productId));
    }
}
