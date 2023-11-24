package com.javaproject.mjcgameduo.repository;

import com.javaproject.mjcgameduo.domain.Board;
import com.javaproject.mjcgameduo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
    Long countByWriter(User user);
    void deleteByWriter_Hn(String hn);

}
