package com.zerobase.market.basket.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;

@RequiredArgsConstructor
public class BasketRepositoryImpl implements BasketCustomRepository{
    private final JPAQueryFactory queryFactory;

    private final EntityManager em;

}
