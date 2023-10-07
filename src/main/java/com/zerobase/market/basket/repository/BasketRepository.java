package com.zerobase.market.basket.repository;

import com.zerobase.market.basket.domain.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepository extends JpaRepository<Basket, Long>, BasketCustomRepository {

}
