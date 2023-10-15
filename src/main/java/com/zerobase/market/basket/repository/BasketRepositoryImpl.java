package com.zerobase.market.basket.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.zerobase.market.basket.domain.Basket;
import com.zerobase.market.basket.dto.BasketSearch;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;

import java.util.List;

import static com.zerobase.market.basket.domain.QBasket.basket;

public class BasketRepositoryImpl implements BasketCustomRepository {
    private final JPAQueryFactory queryFactory;

    private final EntityManager em;

    public BasketRepositoryImpl(EntityManager em){
        this.em = em;
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public Basket registBasket(Basket basket){
        em.persist(basket);
        return basket;
    }

    @Override
    public List<Basket> searchBasket(Pageable pageable, BasketSearch basketSearch){

        BooleanBuilder builder = new BooleanBuilder();

        if(basketSearch.getProductNm() != null){
            builder.and(basket.product.name.like(basketSearch.getProductNm()));
        }

        return queryFactory.selectFrom(basket)
                .where(builder)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(basket.product.name.desc())
                .fetch();
    }


    @Override
    public Basket updateBasket(Basket basket){
        return em.merge(basket);
    }

    @Override
    public Long deleteBasket(Long basketId){
        return queryFactory.delete(basket)
                .where(basket.id.eq(basketId)).execute();
    }

}
