package com.zerobase.market.basket.domain;

import com.zerobase.market.product.domain.Product;
import com.zerobase.market.user.domain.User;
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
import java.time.LocalDateTime;

@Entity
public class Basket {

    @Id
    @Comment("장바구니ID")
    @Column(name = "market_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Comment("수량")
    private Long quantity;

    @Comment("등록일")
    private LocalDateTime registDate;

    @Comment("수정일")
    private LocalDateTime updateDate;

    @Comment("사용자ID")
    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private User user;

    @Comment("상품ID")
    @JoinColumn(name = "product_id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Product product;
}
