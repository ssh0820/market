package com.zerobase.market.product.dto;

import com.zerobase.market.product.domain.Status;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductRequest {
    private String name;
    private double price;
    private Long stock;
    private Status status;
    private LocalDateTime updateDate;
}
