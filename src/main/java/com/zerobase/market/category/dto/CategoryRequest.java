package com.zerobase.market.category.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CategoryRequest {
    private String name;
    private LocalDateTime updateDate;
}
