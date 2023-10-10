package com.zerobase.market.product.controller;

import com.zerobase.market.product.dto.ProductDto;
import com.zerobase.market.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/")
    public ResponseEntity<?> resistProduct(ProductDto productDto){
        return ResponseEntity.ok(productService.save(productDto.getCategoryId(), productDto));
    }
}
