package com.javaproject.mjcgameduo.controller;


import com.javaproject.mjcgameduo.domain.Board;
import com.javaproject.mjcgameduo.domain.User;
import com.javaproject.mjcgameduo.repository.BoardRepository;
import com.javaproject.mjcgameduo.repository.UserRepository;
import com.javaproject.mjcgameduo.service.BoardService;
import com.javaproject.mjcgameduo.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BoardViewController {

    @Autowired
    BoardService boardService;

    @Autowired
    UserService userService;

    @Autowired
    BoardRepository boardRepository;

    @GetMapping("/boardList")
    public String showBoardList(Model model, HttpSession session) { // 메인 페이지 이동

        String userId = (String)session.getAttribute("userId");

        if (userId == null) { // 로그인이 되어있지 않으면 홈페이지로 리다이렉트
            return "redirect:/";
        }
        List<Board> boards = boardService.findAll(); // 30분이 지난 게시글을 불러오지 않는 정보
        User user = userService.findUser(userId);
        List<Board> adminNotice = boardRepository.findByWriter_State(999); // 관리자의 Board 정보를 불러옴 이 게시글은 30분이 지나도 보임.
        model.addAttribute("user", user);
        model.addAttribute("boards", boards);
        model.addAttribute("notice", adminNotice); // 관리자의 공지사항만 따로 가져옴

        return "boardList";
    }

    @GetMapping("/boardList/{game}")
    public String showSearchBoardList(@PathVariable String game, Model model, HttpSession session) { // 메인 페이지 이동

        String userId = (String)session.getAttribute("userId");

        if (userId == null) { // 로그인이 되어있지 않으면 홈페이지로 리다이렉트
            return "redirect:/";
        }
        List<Board> boards = boardService.findByGameContaining(game); // 30분이 지난 게시글을 불러오지 않는 game이름의 게시글 정보
        User user = userService.findUser(userId);
        List<Board> adminNotice = boardRepository.findByWriter_State(999); // 관리자의 Board 정보를 불러옴 이 게시글은 30분이 지나도 보임.
        model.addAttribute("user", user);
        model.addAttribute("boards", boards);
        model.addAttribute("notice", adminNotice); // 관리자의 공지사항만 따로 가져옴

        return "boardList";
    }

    @GetMapping("/newBoard")
    public String newArticle(Model model, HttpSession session){ // 새로운 게시글 작성
        String userId = (String)session.getAttribute("userId");
        if (userId == null) { // 로그인이 되어있지 않으면 홈페이지로 리다이렉트
            return "redirect:/";
        }

        User user = userService.findUser(userId);
        model.addAttribute("user", user);
        return "newBoard";
    }
}
