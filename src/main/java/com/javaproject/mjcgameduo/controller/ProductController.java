package com.javaproject.mjcgameduo.controller;

import com.javaproject.mjcgameduo.domain.Article;
import com.javaproject.mjcgameduo.dto.AddArticleRequest;
import com.javaproject.mjcgameduo.service.MjcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    MjcService mjcService;

    @PostMapping("/api/products")
    public ResponseEntity<Article> saveArticle(@RequestBody AddArticleRequest request) {
        Article savedRequest =  mjcService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRequest);
    }
}