package com.javaproject.mjcgameduo.service;

import com.javaproject.mjcgameduo.domain.Article;
import com.javaproject.mjcgameduo.dto.AddArticleRequest;
import com.javaproject.mjcgameduo.repository.MjcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MjcService {
    @Autowired
    MjcRepository mjcRepository;
    public Article save(AddArticleRequest request){
        return mjcRepository.save(request.toEntity());
    }
    public List<Article> findAll(){
        return mjcRepository.findAll();
    }
}
