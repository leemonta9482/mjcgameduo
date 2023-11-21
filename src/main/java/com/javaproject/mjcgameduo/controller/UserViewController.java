package com.javaproject.mjcgameduo.controller;

import com.javaproject.mjcgameduo.domain.User;
import com.javaproject.mjcgameduo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserViewController {
    @Autowired
    UserService userService;

    @GetMapping("/")
    public ModelAndView indexView(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        return mav;
    }

    @GetMapping("/register")
    public ModelAndView registerView(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("register");
        return mav;
    }
}