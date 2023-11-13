package com.javaproject.mjcgameduo.controller;


import com.javaproject.mjcgameduo.domain.Board;
import com.javaproject.mjcgameduo.service.BoardService;
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
    public ModelAndView getArticles(){
        ModelAndView mav = new ModelAndView();
        List<Board> board = boardService.findAll();
        mav.addObject("boards", board);
        mav.setViewName("boardList");
        return mav;
    }
}
