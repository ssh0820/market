package com.zerobase.market.product.domain;

import com.zerobase.market.basket.domain.Basket;
import com.zerobase.market.category.domain.Category;
import com.zerobase.market.product.dto.ProductRequest;
import com.zerobase.market.user.domain.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {

    @Id
    @Comment("상품ID")
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Comment("상품명")
    private String name;

    @Comment("가격")
    private double price;

    @Comment("재고")
    private Long stock;

    @Comment("상태")
    private Status status;

    @Comment("등록일")
    private LocalDateTime registDate;

    @Comment("수정일")
    private LocalDateTime updateDate;

    @OneToMany(mappedBy = "product")
    private List<Basket> basketList = new ArrayList<>();

    @Comment("카테고리ID")
    @JoinColumn(name = "category_id")
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Category category;

    @Comment("상품등록자ID")
    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private User user;

    public void updateProduct(ProductRequest productRequest){
        this.name = productRequest.getName();
        this.price = productRequest.getPrice();
        this.stock = productRequest.getStock();
        this.status = productRequest.getStatus();
        this.updateDate = LocalDateTime.now();
    }

}
