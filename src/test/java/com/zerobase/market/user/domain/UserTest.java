package com.zerobase.market.user.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class UserTest {

    @Autowired
    EntityManager em;

    @Test
    public void testEntity(){
        User.builder()
                .username("test")
                .password("password")
                .email("email")
                .phoneNumber("phoneNumber")
                .gender(Gender.MALE)
                .registDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .userRole(UserRole.ADMIN)
                .build();


    }

}