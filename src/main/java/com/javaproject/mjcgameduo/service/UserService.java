package com.javaproject.mjcgameduo.service;

import com.javaproject.mjcgameduo.domain.User;
import com.javaproject.mjcgameduo.dto.UserRequest;
import com.javaproject.mjcgameduo.dto.UserResponse;
import com.javaproject.mjcgameduo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public UserResponse join(UserRequest request){
        User checkUser = userRepository.findByHn(request.getHn());
        UserResponse response = new UserResponse();

        if(checkUser!=null){
            response.setSuccess(false);
            response.setMessage("이미 가입된 아이디 입니다.");
            return response;
        }

        User joinUser = userRepository.save(request.toEntity());
        response.setSuccess(true);
        response.setMessage("회원가입 완료");
        response.setUser(joinUser);
        return response;
    }

    public UserResponse login(UserRequest request){
        User checkUser = userRepository.findByHnAndPw(request.getHn(), request.getPw());
        UserResponse response = new UserResponse();
        if(checkUser==null){
            response.setSuccess(false);
            response.setMessage("아이디 또는 패스워드가 틀림");
            return response;
        }

        response.setSuccess(true);
        response.setMessage("로그인 성공");
        response.setUser(checkUser);
        return response;
    }

}
