package com.zerobase.market.user.dto;

import com.zerobase.market.user.domain.Gender;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class UserRequest {
    private String password;
    private String phoneNumber;
    private String email;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDateTime updateDate;
}
