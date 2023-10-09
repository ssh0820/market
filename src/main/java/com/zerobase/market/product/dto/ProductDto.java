package com.zerobase.market.product.dto;


import com.zerobase.market.product.domain.Status;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ProductDto {

    private Long id;

    private String name;

    private Long price;

    private Long stock;

    private Status status;

    private LocalDateTime registDate;

    private LocalDateTime updateDate;

    private String categoryId;
}
