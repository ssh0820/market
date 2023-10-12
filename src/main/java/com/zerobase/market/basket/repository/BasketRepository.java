package com.zerobase.market.basket.repository;

import com.zerobase.market.basket.domain.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketRepository extends JpaRepository<Basket, Long>, BasketCustomRepository {

}
