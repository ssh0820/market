package com.zerobase.market.user.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.zerobase.market.user.domain.User;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import java.util.Optional;

import static com.zerobase.market.user.domain.QUser.user;


@RequiredArgsConstructor
public class UserRepositoryImpl implements UserCustomRepository{

    private final JPAQueryFactory jpaQueryFactory;

    private final EntityManager em;

    @Override
    public Optional<User> findAdminByRole(String username) {
        return jpaQueryFactory
                .select(user)
                .from(user)
                .stream()
                .filter(user1 -> user.roles.equals("ADMIN"))
                .findAny();
    }
}
