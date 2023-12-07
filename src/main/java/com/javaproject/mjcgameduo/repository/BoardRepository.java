package com.javaproject.mjcgameduo.repository;

import com.javaproject.mjcgameduo.domain.Board;
import com.javaproject.mjcgameduo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> {
    Long countByWriter(User user);
    void deleteByWriter_Hn(String hn);
    List<Board> findByWriter_State(int state);
    List<Board> findByGameContaining(String game);
}
