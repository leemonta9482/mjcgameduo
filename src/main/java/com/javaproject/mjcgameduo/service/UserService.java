package com.javaproject.mjcgameduo.service;

import com.javaproject.mjcgameduo.domain.User;
import com.javaproject.mjcgameduo.dto.UpdateUserRequest;
import com.javaproject.mjcgameduo.dto.UserRequest;
import com.javaproject.mjcgameduo.dto.UserResponse;
import com.javaproject.mjcgameduo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public UserResponse register(UserRequest request){
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
        User user = userRepository.findByHn(request.getHn());
        response.setSuccess(true);
        response.setMessage("로그인 성공");
        response.setUser(checkUser);
        response.setAdmin(user.getState());
        return response;
    }

    @Transactional // springframework에 존재하는 라이브러리로 어노테이션 해야함
    public User update(String hn, UpdateUserRequest request){
        User user = userRepository.findByHn(hn);
        user.update(request.getPw(), request.getNick());
        return user;
    }

    public User findUser(String hn){
        return userRepository.findByHn(hn);
    }

    public List<User> findAllUser(){
        return userRepository.findAll();
    }
}
