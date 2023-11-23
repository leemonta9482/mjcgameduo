package com.javaproject.mjcgameduo.controller;


import com.javaproject.mjcgameduo.domain.Board;
import com.javaproject.mjcgameduo.domain.User;
import com.javaproject.mjcgameduo.repository.UserRepository;
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
public class BoardViewController {

    @Autowired
    BoardService boardService;

    @Autowired
    UserService userService;

    @GetMapping("/boardList")
    public String showBoardList(Model model, HttpSession session) {
        String userId = (String)session.getAttribute("userId");

        if (userId == null) {
            return "redirect:/"; // 로그인이 되어있지 않으면 홈페이지로 리다이렉트
        }
        List<Board> boards = boardService.findAll();
        User user = userService.findUser(userId);

        model.addAttribute("user", user);
        model.addAttribute("boards", boards);

        return "boardList";
    }

    @GetMapping("/admin")
    public String adminPage(Model model, HttpSession session) {
        String userId = (String)session.getAttribute("userId");

        if(userId == null){
            return "redirect:/"; // 로그인이 되어있지 않으면 홈페이지로 리다이렉트
        }
        List<User> users = userService.findAllUser();
        model.addAttribute("user", users);
        return "admin";
    }
}
