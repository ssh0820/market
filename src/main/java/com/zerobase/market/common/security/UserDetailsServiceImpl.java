package com.zerobase.market.common.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserDetailsServiceImpl implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;

    public UserDetailsServiceImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 실제 사용자 데이터베이스에서 사용자 정보를 가져오는 로직을 구현해야 합니다.
        // 여기서는 간단한 하드 코딩 예제를 제공합니다.
        if ("yourUsername".equals(username)) {
            return User.builder()
                    .username(username)
                    .password(passwordEncoder.encode("password")) // 패스워드를 인코딩합니다.
                    .roles("USER")
                    .build();
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}
