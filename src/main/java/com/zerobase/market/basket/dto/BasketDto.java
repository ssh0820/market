package com.zerobase.market.basket.dto;

import com.zerobase.market.basket.domain.Basket;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class BasketDto {
    private Long id;
    private Long quantity;
    private LocalDateTime registDate;
    private LocalDateTime updateDate;
    private Long userId;
    private Long productId;

    public static BasketDto from(Basket basket){
        return BasketDto.builder()
                .id(basket.getId())
                .quantity(basket.getQuantity())
                .registDate(basket.getRegistDate())
                .updateDate(basket.getUpdateDate())
                .userId(basket.getUser().getId())
                .productId(basket.getProduct().getId())
                .build();
    }

}
