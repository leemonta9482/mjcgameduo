package com.javaproject.mjcgameduo.controller;

import com.javaproject.mjcgameduo.domain.User;
import com.javaproject.mjcgameduo.dto.UserRequest;
import com.javaproject.mjcgameduo.dto.UserResponse;
import com.javaproject.mjcgameduo.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/api/join")
    public ResponseEntity<UserResponse> join(@RequestBody UserRequest request){
        UserResponse response = userService.join(request);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/api/login")
    public ResponseEntity<UserResponse> login(@RequestBody UserRequest request,
                                              HttpServletRequest httpServletRequest){
        HttpSession session = httpServletRequest.getSession(true);
        UserResponse response = userService.login(request);

        if(!response.isSuccess()){ // 로그인에 실패
            return ResponseEntity.ok().body(response);
        }
        // 로그인 성공
        session.setAttribute("userId", response.getUser().getHn());
        return ResponseEntity.ok().body(response);
    }
}