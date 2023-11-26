package com.javaproject.mjcgameduo.controller;

import com.javaproject.mjcgameduo.domain.Board;
import com.javaproject.mjcgameduo.domain.User;
import com.javaproject.mjcgameduo.service.BoardService;
import com.javaproject.mjcgameduo.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserViewController {
    @Autowired
    UserService userService;

    @Autowired
    BoardService boardService;

    @GetMapping("/")
    public String indexView(){
        return "index";
    }

    @GetMapping("/register")
    public String registerView(){
        return "register";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // 세션을 완료하고 로그아웃 처리
        return "index";
    }

    @GetMapping("/mypage")
    public String mypage(Model model, HttpSession session){
        String userId = (String)session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/"; // 로그인이 되어있지 않으면 홈페이지로 리다이렉트
        }
        User user = userService.findUser(userId);
        model.addAttribute("user", user);

        return "mypage";
    }
}