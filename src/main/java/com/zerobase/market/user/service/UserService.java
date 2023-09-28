package com.zerobase.market.user.service;

import com.zerobase.market.user.domain.User;
import com.zerobase.market.user.dto.Auth;
import com.zerobase.market.user.dto.UserDto;
import com.zerobase.market.user.dto.UserRequest;
import com.zerobase.market.user.exception.UserException;
import com.zerobase.market.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserDto resistUser(Auth.SignUp user){
        boolean usernameCheck = false;
        usernameCheck = userRepository.existsByUsername(user.getUsername());

        if(usernameCheck){
            throw new UserException();
        }else{
            String encodePw = passwordEncoder.encode(user.getPassword());
            return UserDto.builder()
                    .username(user.getUsername())
                    .password(encodePw)
                    .email(user.getEmail())
                    .gender(user.getGender())
                    .phoneNumber(user.getPhoneNumber())
                    .birthDate(user.getBirthDate())
                    .registDate(user.getRegistDate())
                    .updateDate(user.getUpdateDate())
                    .build();
        }
    }

    public UserDto userCheck(Auth.SignIn user){
        User findUser = userRepository.findByUsername(user.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("해당 유저를 찾을 수 없습니다."));
        if(findUser.getPassword().equals(user.getPassword())){
            throw new NotYetImplementedException();
        }else {
            return UserDto.from(findUser);
        }
    }

    public UserDto updateUser(String username, UserRequest request){
        User user = userRepository.findByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException("해당 사용자를 찾을 수 없습니다."));

        user.updateUser(
                username,
                request.getPhoneNumber(),
                request.getEmail(),
                request.getGender(),
                request.getBirthDate(),
                request.getUpdateDate()
        );

        return UserDto.from(user);
    }

    public UserDto updatePassword(String username, String password){
        User user = userRepository.findByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException("해당 사용자를 찾을 수 없습니다."));

        String encodePw = passwordEncoder.encode(password);
        user.updatePassword(username, encodePw);

        return UserDto.from(user);
    }

    public int deleteUser(String username){
        User user = userRepository.findByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException("해당 사용자를 찾을 수 없습니다."));
        return userRepository.deleteByUsername(user.getUsername());
    }

}
