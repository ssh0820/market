package com.zerobase.market.user.controller;

import com.zerobase.market.common.security.TokenProvider;
import com.zerobase.market.user.dto.Auth;
import com.zerobase.market.user.dto.UserDto;
import com.zerobase.market.user.dto.UserRequest;
import com.zerobase.market.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final TokenProvider tokenProvider;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody Auth.SignUp request) {
        return ResponseEntity.ok(userService.resistUser(request));
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestBody Auth.SignIn request) {
        UserDto userDto = userService.userCheck(request);
        return ResponseEntity.ok(tokenProvider.generateToken(userDto.getUsername(), userDto.getUserRole()));
    }

    @PostMapping("/{username}")
    public ResponseEntity<?> updateUser(@PathVariable String username, @RequestBody UserRequest request) {
        return ResponseEntity.ok(userService.updateUser(username,request));
    }

    @PostMapping("/password/{username}")
    public ResponseEntity<?> updatePassword(@PathVariable String username, String password) {
        return ResponseEntity.ok(userService.updatePassword(username,password));
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<?> deleteUser(@PathVariable String username) {
        return ResponseEntity.ok(userService.deleteUser(username));
    }

}
