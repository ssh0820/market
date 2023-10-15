package com.zerobase.market.basket.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BasketRequest {
    private Long quantity;
    private LocalDateTime registDate;
    private LocalDateTime updateDate;
    private Long userId;
    private Long productId;

}
