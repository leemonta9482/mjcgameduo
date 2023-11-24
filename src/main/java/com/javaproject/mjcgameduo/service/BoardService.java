package com.javaproject.mjcgameduo.service;

import com.javaproject.mjcgameduo.domain.Board;
import com.javaproject.mjcgameduo.domain.User;
import com.javaproject.mjcgameduo.dto.BoardRequest;
import com.javaproject.mjcgameduo.dto.BoardResponse;
import com.javaproject.mjcgameduo.repository.BoardRepository;
import com.javaproject.mjcgameduo.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    public Board findOne(long createnum){
        Board board = boardRepository.findById(createnum).orElseThrow();
        return board;
    }

    public Long getBoardCountByUser(User user) {
        return boardRepository.countByWriter(user);
    }

    @Transactional
    public void deleteAllByWriterHn(String writerHn) {
        boardRepository.deleteByWriter_Hn(writerHn);
    }
}
