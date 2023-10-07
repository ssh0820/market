package com.zerobase.market.user.repository;

import com.zerobase.market.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>, UserCustomRepository{

    // 해당 사용자 검색
    Optional<User> findByUsername(String username);

    // 사용자 유무 체크
    boolean existsByUsername(String username);

    //사용자 삭제
    int deleteByUsername(String username);
}
