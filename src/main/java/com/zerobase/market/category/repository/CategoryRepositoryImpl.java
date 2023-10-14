package com.zerobase.market.category.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.persistence.EntityManager;

public class CategoryRepositoryImpl implements CategoryCustomRepository{

    private final JPAQueryFactory queryFactory;

    private final EntityManager em;

    public CategoryRepositoryImpl(EntityManager em){
        this.em = em;
        this.queryFactory = new JPAQueryFactory(em);
    }

}
