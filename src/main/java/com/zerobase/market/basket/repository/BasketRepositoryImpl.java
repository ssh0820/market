package com.zerobase.market.basket.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.persistence.EntityManager;

public class BasketRepositoryImpl implements BasketCustomRepository {
    private final JPAQueryFactory queryFactory;

    private final EntityManager em;

    public BasketRepositoryImpl(EntityManager em){
        this.em = em;
        this.queryFactory = new JPAQueryFactory(em);
    }
}
