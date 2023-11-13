package com.javaproject.mjcgameduo.dto;

import com.javaproject.mjcgameduo.domain.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddArticleRequest {
    private String name;
    private int price;

    public Article toEntity(){
        Article article = new Article(this.name, this.price);
        return article;
    }
}
