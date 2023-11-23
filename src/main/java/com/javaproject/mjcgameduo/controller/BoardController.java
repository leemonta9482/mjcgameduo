package com.javaproject.mjcgameduo.controller;

import com.javaproject.mjcgameduo.domain.Board;
import com.javaproject.mjcgameduo.dto.BoardRequest;
import com.javaproject.mjcgameduo.dto.BoardResponse;
import com.javaproject.mjcgameduo.service.BoardService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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
    public ResponseEntity<BoardResponse> saveArticle(@RequestBody BoardRequest request,
                                                     HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession(true);
        String userId = (String)session.getAttribute("userId");

        BoardResponse response = new BoardResponse();
        if(userId==null){ // 로그인 되어 있지 않음
            response.setSuccess(false);
            response.setMassage("로그인 해주세요.");
            return ResponseEntity.ok().body(response);
        }
        Board savedRequest =  boardService.save(request, userId);
        response.setSuccess(true);
        response.setMassage("글 작성이 완료됨");
        response.setBoard(savedRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
