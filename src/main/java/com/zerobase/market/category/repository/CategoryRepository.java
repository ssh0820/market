package com.zerobase.market.category.repository;

import com.zerobase.market.category.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>, CategoryCustomRepository {

    Optional<Category> findByName(String name);
    boolean existsByName(String name);
    int deleteByName(String name);

}
