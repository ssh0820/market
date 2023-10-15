package com.zerobase.market.basket.repository;

import com.zerobase.market.basket.domain.Basket;
import com.zerobase.market.basket.dto.BasketRequest;
import com.zerobase.market.basket.dto.BasketSearch;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BasketCustomRepository {
    Basket registBasket(Basket basket);

    List<Basket> searchBasket(Pageable pageable, BasketSearch basketSearch);

    Basket updateBasket(Basket basket);

    Long deleteBasket(Long basketId);
}
