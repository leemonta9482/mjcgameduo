package com.javaproject.mjcgameduo.controller;


import com.javaproject.mjcgameduo.domain.Board;
import com.javaproject.mjcgameduo.service.BoardService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BoardViewController {

    @Autowired
    BoardService boardService;

    @GetMapping("/boardList")
    public ModelAndView test(HttpSession session){
        ModelAndView mav = new ModelAndView();
        List<Board> board = boardService.findAll();
        Object userId = session.getAttribute("userId");
        if (userId == null) {
            mav.setViewName("index");
            return mav;
        }
        mav.addObject("user", userId);
        mav.addObject("boards", board);
        mav.setViewName("boardList");
        return mav;
    }
}
