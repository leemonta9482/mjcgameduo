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

    @GetMapping("/userList")
    public ModelAndView getArticles(){
        ModelAndView mav = new ModelAndView();
        List<User> user = userService.findAll();
        mav.addObject("users", user);
        mav.setViewName("userList");
        return mav;
    }

}
