package com.zerobase.market.category.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class CategoryRequest {
    private Long id;
    private String name;
    private LocalDateTime updateDate;
}
