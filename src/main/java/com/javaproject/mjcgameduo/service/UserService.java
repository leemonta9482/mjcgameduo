package com.javaproject.mjcgameduo.service;

import com.javaproject.mjcgameduo.domain.User;
import com.javaproject.mjcgameduo.dto.UpdateAdminUpdate;
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
    public void UserResponse(UserRequest request) {
        // 유효성 검사
        Object checkuser = null;
        if (!isValidHn(checkuser.getHn())) {
            throw new IllegalArgumentException("유효하지 않은 아아디입니다.");
        }

        Object cehckuser = null;
        if (!isValidPw(cehckuser.getpw())) {
            throw new IllegalArgumentException("유효하지 않은 비밀번호입니다.");
        }

        // 회원가입 로직
        User user = new User();
        user.setHn(checkuser.gethn());
        user.setPw(cehcksuer.getpw());

        // 데이터베이스에 저장
        userRepository.save(user);
    }

    private boolean isValidHn(String Hn) {
        // 아아디 주소의 정규식 패턴
        String hnPattern = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$";
        return hnPattern.matches(hnPattern);
    }

    private boolean isValidPw(String pw) {
        // 비밀번호의 정규식 패턴
        String pwPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        return pwPattern.matches(pwPattern);
    }


    @Transactional // springframework에 존재하는 라이브러리로 어노테이션 해야함
    public User update(String hn, UpdateUserRequest request){
        User user = userRepository.findByHn(hn);
        user.update(request.getPw(), request.getNick());
        return user;
    }

    @Transactional // springframework에 존재하는 라이브러리로 어노테이션 해야함
    public User adminUpdate(Long createnum, UpdateAdminUpdate request){
        User user = userRepository.findByCreatenum(createnum);
        user.adminUpdate(request.getHn(), request.getPw(), request.getName(), request.getGender(),
                request.getNick(), request.getState());
        return user;
    }

    public User findUser(String hn){
        return userRepository.findByHn(hn);
    }

    public User findUser(Long createnum){
        return userRepository.findByCreatenum(createnum);
    }

    public List<User> findAllUser(){
        return userRepository.findAll();
    }

    @Transactional
    public void deleteAllByCreatenum(Long createnum) {
        userRepository.deleteByCreatenum(createnum);
    }
}
