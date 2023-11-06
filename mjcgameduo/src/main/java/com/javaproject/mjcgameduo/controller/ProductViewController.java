package com.javaproject.mjcgameduo.controller;

import com.javaproject.mjcgameduo.domain.Article;
import com.javaproject.mjcgameduo.service.MjcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductViewController {
    @Autowired
    MjcService mjcService;

    @GetMapping("/products")
    public ModelAndView getArticles(){
        ModelAndView mav = new ModelAndView();
        List<Article> articles = mjcService.findAll();
        mav.addObject("articles", articles);
        mav.setViewName("products");
        return mav;
    }

}
