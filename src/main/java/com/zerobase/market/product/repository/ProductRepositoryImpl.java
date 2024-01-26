package com.zerobase.market.product.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.zerobase.market.product.domain.Product;
import com.zerobase.market.product.dto.ProductSearch;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import java.util.List;

import static com.zerobase.market.product.domain.QProduct.product;

public class ProductRepositoryImpl implements ProductCustomRepository {

    private final JPAQueryFactory queryFactory;

    private final EntityManager em;

    public ProductRepositoryImpl(EntityManager em){
        this.em = em;
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public Product registProduct(Product product) {
        em.persist(product);
        return product;
    }

    @Override
    public List<Product> searchProduct(Pageable pageable, ProductSearch productSearch) {
        BooleanBuilder builder = new BooleanBuilder();

        if(productSearch.getName() != null){
            builder.and(product.name.like(productSearch.getName()));
        }
        if(productSearch.getStatus() != null){
            builder.and(product.status.eq(productSearch.getStatus()));
        }
        if(productSearch.getUserId() != null){
            builder.and(product.user.id.eq(productSearch.getUserId()));
        }

        return queryFactory.selectFrom(product)
                .where(builder)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(product.name.desc())
                .fetch();
    }

    @Override
    public Product updateProduct(Product product) {
        return em.merge(product);
    }

    @Override
    public Long deleteProduct(Long productId) {
        return queryFactory.delete(product)
                .where(product.id.eq(productId)).execute();
    }
}
