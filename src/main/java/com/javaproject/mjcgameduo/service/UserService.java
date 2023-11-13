package com.javaproject.mjcgameduo.service;

import com.javaproject.mjcgameduo.domain.User;
import com.javaproject.mjcgameduo.dto.AddUserRequest;
import com.javaproject.mjcgameduo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public User save(AddUserRequest request){
        return userRepository.save(request.toEntity());
    }
    public List<User> findAll(){
        return userRepository.findAll();
    }
}
