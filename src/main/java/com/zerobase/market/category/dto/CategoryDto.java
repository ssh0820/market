package com.zerobase.market.category.dto;

import com.zerobase.market.category.domain.Category;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class CategoryDto {
    private Long id;
    private String name;
    private LocalDateTime registDate;
    private LocalDateTime updateDate;

    public static CategoryDto from(Category category){
        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .registDate(category.getRegistDate())
                .updateDate(category.getUpdateDate())
                .build();
    }

}
