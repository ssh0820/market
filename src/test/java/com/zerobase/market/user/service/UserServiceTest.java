package com.zerobase.market.user.service;

import com.zerobase.market.user.domain.Gender;
import com.zerobase.market.user.domain.User;
import com.zerobase.market.user.domain.UserRole;
import com.zerobase.market.user.dto.Auth;
import com.zerobase.market.user.dto.UserDto;
import com.zerobase.market.user.repository.UserRepository;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import static com.zerobase.market.user.domain.Gender.MALE;
import static com.zerobase.market.user.domain.UserRole.ADMIN;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
@Transactional
class UserServiceTest {
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserService userService;

    private PasswordEncoder passwordEncoder;

    @Test
    @DisplayName("사용자 조회 성공")
    void 사용자조회(){
        User registUser = User.builder()
                .username("test")
                .password(passwordEncoder.encode("12345678"))
                .email("12345@gamil.com")
                .phoneNumber("01012345678")
                .gender(MALE)
                .birthDate(LocalDate.now())
                .registDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .userRole(ADMIN)
                .build();
        //given
        given(userRepository.findById(ArgumentMatchers.anyLong()))
                .willReturn(Optional.of(registUser));

        ArgumentCaptor<Long> captor = ArgumentCaptor.forClass(Long.class);

        Auth.SignIn authUser = new Auth.SignIn();
        authUser.setUsername(registUser.getUsername());
        authUser.setPassword(registUser.getPassword());

        //when
        UserDto userDto = userService.userCheck(authUser);

        //then
        Mockito.verify(userRepository, times(1)).findById(captor.capture());
        Mockito.verify(userRepository, times(0)).save(any());
        assertEquals(4555L, captor.getValue());
        assertNotEquals(45515L,captor.getValue());
        assertEquals("test", userDto.getUsername());
        assertEquals(passwordEncoder.encode("12345678"),userDto.getPassword());
        assertEquals("12345@gamil.com",userDto.getEmail());
        assertEquals(ADMIN,userDto.getUserRole());
        assertEquals("01012345678",userDto.getPhoneNumber());
        assertEquals(MALE,userDto.getGender());
    }

}