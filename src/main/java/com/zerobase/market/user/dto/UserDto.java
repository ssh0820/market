package com.zerobase.market.user.dto;

import com.zerobase.market.user.domain.Gender;
import com.zerobase.market.user.domain.User;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class UserDto {

    private String username;
    private String password;
    private String phoneNumber;
    private String email;
    private Gender gender;
    private List<String> roles;
    private LocalDate birthDate;
    private LocalDateTime registDate;
    private LocalDateTime updateDate;

    public static UserDto from(User user){
        return UserDto.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .phoneNumber(user.getPhoneNumber())
                .email(user.getEmail())
                .gender(user.getGender())
                .roles(user.getRoles())
                .birthDate(user.getBirthDate())
                .registDate(user.getRegistDate())
                .updateDate(user.getUpdateDate())
                .build();
    }

}
