package com.javaproject.mjcgameduo.controller;

import com.javaproject.mjcgameduo.domain.Board;
import com.javaproject.mjcgameduo.dto.AddBoardRequest;
import com.javaproject.mjcgameduo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardController {

    @Autowired
    BoardService boardService;

    @PostMapping("/api/board/create")
    public ResponseEntity<Board> saveArticle(@RequestBody AddBoardRequest request) {
        Board savedRequest =  boardService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRequest);
    }
}
