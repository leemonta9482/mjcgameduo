package com.javaproject.mjcgameduo.service;

import com.javaproject.mjcgameduo.domain.Board;
import com.javaproject.mjcgameduo.dto.AddBoardRequest;
import com.javaproject.mjcgameduo.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    BoardRepository boardRepository;

    public Board save(AddBoardRequest request){
        return boardRepository.save(request.toEntity());
    }
    public List<Board> findAll(){
        return boardRepository.findAll();
    }
}
