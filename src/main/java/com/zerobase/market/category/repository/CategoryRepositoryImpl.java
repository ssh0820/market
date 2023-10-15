package com.zerobase.market.category.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.zerobase.market.category.domain.Category;
import com.zerobase.market.category.dto.CategorySearch;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;

import java.util.List;

import static com.zerobase.market.category.domain.QCategory.category;

public class CategoryRepositoryImpl implements CategoryCustomRepository{

    private final JPAQueryFactory queryFactory;

    private final EntityManager em;

    public CategoryRepositoryImpl(EntityManager em){
        this.em = em;
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<Category> searchCategory(Pageable pageable, CategorySearch categorySearch){

        BooleanBuilder builder = new BooleanBuilder();

        if(categorySearch.getName() != null){
            builder.and(category.name.like(categorySearch.getName()));
        }

        return queryFactory.selectFrom(category)
                .where(builder)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(category.id.desc())
                .fetch();
    }

    @Override
    public Long deleteCategory(Long categoryId){
        return queryFactory.delete(category)
                .where(category.id.eq(categoryId)).execute();
    }

}
