package com.zerobase.market.user.dto;

import com.zerobase.market.user.domain.Gender;
import com.zerobase.market.user.domain.UserRole;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Auth {

    @Data
    public static class SignIn {
        private String username;
        private String password;
    }

    @Data
    @Builder
    public static class SignUp {
        private String username;
        private String password;
        private String email;
        private Gender gender;
        private String phoneNumber;
        private LocalDate birthDate;
        private LocalDateTime registDate;
        private LocalDateTime updateDate;
        private UserRole userRole;
    }
}
