package com.javaproject.mjcgameduo.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.javaproject.mjcgameduo.domain.User;
import com.javaproject.mjcgameduo.dto.UpdateAdminUpdate;
import com.javaproject.mjcgameduo.dto.UpdateUserRequest;
import com.javaproject.mjcgameduo.dto.UserRequest;
import com.javaproject.mjcgameduo.dto.UserResponse;
import com.javaproject.mjcgameduo.service.BoardService;
import com.javaproject.mjcgameduo.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    BoardService boardService;

    @PostMapping("/api/register")
    public ResponseEntity<UserResponse> register(@RequestBody UserRequest request){
        UserResponse response = userService.register(request);
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

    @PutMapping("/api/update/{hn}")
    public ResponseEntity<User> updateUser(
            @PathVariable String hn,
            @RequestBody UpdateUserRequest request
    ){
        User user = userService.update(hn, request);
        return ResponseEntity.ok().body(user);
    }

    @PutMapping("/api/admin/update/{createnum}")
    public ResponseEntity<User> updateUser(
            @PathVariable Long createnum,
            @RequestBody UpdateAdminUpdate request
    ){
        User user = userService.adminUpdate(createnum, request);
        return ResponseEntity.ok().body(user);
    }

    @DeleteMapping("/api/admin/delete/{createnum}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long createnum){
        User user = userService.findUser(createnum);
        boardService.deleteAllByWriterHn(user.getHn());
        userService.deleteAllByCreatenum(createnum);
        return ResponseEntity.ok().build();
    }
}