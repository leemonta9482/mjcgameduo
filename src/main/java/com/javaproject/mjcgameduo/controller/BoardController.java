package com.javaproject.mjcgameduo.controller;

import com.javaproject.mjcgameduo.domain.Board;
import com.javaproject.mjcgameduo.domain.User;
import com.javaproject.mjcgameduo.dto.BoardRequest;
import com.javaproject.mjcgameduo.dto.BoardResponse;
import com.javaproject.mjcgameduo.repository.BoardRepository;
import com.javaproject.mjcgameduo.repository.UserRepository;
import com.javaproject.mjcgameduo.service.BoardService;
import com.javaproject.mjcgameduo.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
public class BoardController {

    @Autowired
    BoardService boardService;

    @Autowired
    UserService userService;

    @Autowired
    BoardRepository boardRepository;

    @PostMapping("/api/board/create")
    public ResponseEntity<BoardResponse> saveArticle(@RequestBody BoardRequest request,
                                                     HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession(true);
        String userId = (String)session.getAttribute("userId");

        BoardResponse response = new BoardResponse();
        if(userId==null){ // 로그인 되어 있지 않음
            response.setSuccess(false);
            response.setMessage("로그인 해주세요.");
            return ResponseEntity.ok().body(response);
        }

        User user = userService.findUser(userId);
        Long count = boardService.getBoardCountByUser(user);

        if(count>=1){
            boardService.deleteAllByWriterHn(user.getHn());
        }

        response.setSuccess(true);
        response.setMessage("글 작성이 완료됨");
        Board savedRequest = boardService.save(request, userId);
        response.setBoard(savedRequest);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/api/board/delete/{id}")
    public ResponseEntity<Void> deleteBoard(@PathVariable String id, HttpServletRequest httpServletRequest){
        HttpSession session = httpServletRequest.getSession(true);
        String LogineduserId = (String)session.getAttribute("userId");

        boardService.deleteAllByWriterHn(id);
        return ResponseEntity.ok().build();
    }
}
