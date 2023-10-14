package com.zerobase.market.user.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.zerobase.market.user.domain.User;
import com.zerobase.market.user.domain.UserRole;

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
    public Boolean findAdminByRole(Long userId) {

        boolean authCheck = false;

        Optional<User> findUser = queryFactory
                .select(user)
                .from(user)
                .where(
                        user.id.eq(userId),
                        user.userRole.eq(UserRole.ADMIN)
                ).stream().findAny();

        if(!findUser.isEmpty()){
            authCheck = true;
        }

        return authCheck;
    }
}
