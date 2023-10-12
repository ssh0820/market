package com.zerobase.market.user.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.zerobase.market.user.domain.User;
import javax.persistence.EntityManager;
import java.util.Optional;

import static com.zerobase.market.user.domain.QUser.user;


public class UserRepositoryImpl implements UserCustomRepository{

    private final JPAQueryFactory queryFactory;

    private final EntityManager em;

    public UserRepositoryImpl(EntityManager em){
        this.em = em;
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public Optional<User> findAdminByRole(String username) {
        return queryFactory
                .select(user)
                .from(user)
                .stream()
                .filter(user1 -> user.userRole.equals("ADMIN"))
                .findAny();
    }
}
