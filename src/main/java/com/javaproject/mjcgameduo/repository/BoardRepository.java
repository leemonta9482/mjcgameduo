package com.javaproject.mjcgameduo.repository;

import com.javaproject.mjcgameduo.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
