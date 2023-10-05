package com.zerobase.market.category.domain;

import com.zerobase.market.product.domain.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
@Getter
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

    @Builder
    public void updateCategory(String name, LocalDateTime updateDate){
        this.name = name;
        this.updateDate = updateDate;
    }

}