package com.javaproject.mjcgameduo.service;

import com.javaproject.mjcgameduo.domain.Board;
import com.javaproject.mjcgameduo.domain.User;
import com.javaproject.mjcgameduo.dto.BoardRequest;
import com.javaproject.mjcgameduo.repository.BoardRepository;
import com.javaproject.mjcgameduo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    UserRepository userRepository;

    public Board save(BoardRequest request, String userId){
        User loginUser = userRepository.findByHn(userId);
        Board board = request.toEntity();
        board.setWriter(loginUser);
        return boardRepository.save(board);
    }
    public List<Board> findAll(){
        return boardRepository.findAll();
    }
}
