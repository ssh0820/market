package com.zerobase.market.category.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.persistence.EntityManager;

import static com.zerobase.market.category.domain.QCategory.category;

public class CategoryRepositoryImpl implements CategoryCustomRepository{

    private final JPAQueryFactory queryFactory;

    private final EntityManager em;

    public CategoryRepositoryImpl(EntityManager em){
        this.em = em;
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public Long deleteCategory(Long categoryId){
        return queryFactory.delete(category)
                .where(category.id.eq(categoryId)).execute();
    }

}
