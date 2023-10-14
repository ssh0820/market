package com.zerobase.market.product.dto;


import com.zerobase.market.product.domain.Product;
import com.zerobase.market.product.domain.Status;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ProductDto {

    private Long id;

    private String name;

    private double price;

    private Long stock;

    private Status status;

    private LocalDateTime registDate;

    private LocalDateTime updateDate;

    private Long categoryId;

    private Long userId;

    public static ProductDto from(Product product){
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .stock(product.getStock())
                .status(product.getStatus())
                .registDate(product.getRegistDate())
                .updateDate(product.getUpdateDate())
                .categoryId(product.getCategory().getId())
                .userId(product.getUser().getId())
                .build();
    }

}
