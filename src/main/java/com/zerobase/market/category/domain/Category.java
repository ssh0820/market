package com.zerobase.market.category.domain;

import com.zerobase.market.category.dto.CategoryRequest;
import com.zerobase.market.product.domain.Product;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Category {

    @Id
    @Comment("카테고리ID")
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Comment("카테고리명")
    @Column(unique = true)
    private String name;

    @Comment("등록일")
    private LocalDateTime registDate;

    @Comment("수정일")
    private LocalDateTime updateDate;

    @OneToMany(mappedBy = "category")
    private List<Product> productList = new ArrayList<>();

    public void updateCategory(CategoryRequest categoryRequest){
        this.name = categoryRequest.getName();
        this.updateDate = LocalDateTime.now();
    }

}
