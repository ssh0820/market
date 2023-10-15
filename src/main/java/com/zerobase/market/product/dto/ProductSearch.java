package com.zerobase.market.product.dto;

import com.zerobase.market.product.domain.Status;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductSearch {
    private String name;
    private Status status;
    private Long userId;
}
