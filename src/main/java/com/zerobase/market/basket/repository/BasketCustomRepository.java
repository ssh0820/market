package com.zerobase.market.basket.repository;

import com.zerobase.market.basket.domain.Basket;
import com.zerobase.market.basket.dto.BasketRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BasketCustomRepository {
    Basket registBasket(Basket basket);

    List<Basket> searchBasket(Pageable pageable, BasketRequest basketRequest);

    Basket updateBasket(Basket basket);

    Long deleteBasket(Long basketId);
}
