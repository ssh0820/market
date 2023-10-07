package com.zerobase.market.category.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;

@RequiredArgsConstructor
public class CategoryRepositoryImpl implements CategoryCustomRepository{

    private final JPAQueryFactory queryFactory;

    private final EntityManager em;

}
