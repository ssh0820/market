package com.zerobase.market.product.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.zerobase.market.product.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.zerobase.market.product.domain.QProduct.product;

@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductCustomRepository {

    private final JPAQueryFactory queryFactory;

    private final EntityManager em;

    public ProductRepositoryImpl(EntityManager em){
        this.em = em;
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public Product save(Product product) {
        em.persist(product);
        return product;
    }

    @Override
    public List<Product> findAll(Pageable pageable) {
        return queryFactory.selectFrom(product).fetch();
    }

    @Override
    public Optional<Product> findById(Long id) {
         Product findProduct = queryFactory.selectFrom(product)
                .where(product.id.eq(id))
                .fetchOne();
        return Optional.ofNullable(findProduct);
    }

    @Override
    public Product update(Product productDto) {
        return em.merge(productDto);
    }

    @Override
    public Long deleteById(Long id) {
        return queryFactory.delete(product)
                .where(product.id.eq(id)).execute();
    }
}
