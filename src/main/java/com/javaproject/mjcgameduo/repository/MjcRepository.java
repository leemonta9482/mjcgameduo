package com.javaproject.mjcgameduo.repository;

import com.javaproject.mjcgameduo.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MjcRepository extends JpaRepository<Article, Long> {
}
