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

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<Board> findAll() { // 30분 지나면 불러오지 않음.
        List<Board> board = boardRepository.findAll();
        LocalDateTime time = LocalDateTime.now();
        List<Board> recentBoard = board.stream()
                .filter(board1 -> board1.getCreatedAt().plusMinutes(30).isAfter(time))
                .sorted(Comparator.comparing(Board::getCreatedAt).reversed()) // 등록날짜의 역순으로 정렬
                .toList();
        return recentBoard;
    }

    public Long getBoardCountByUser(User user) {
        return boardRepository.countByWriter(user);
    }

    @Transactional
    public void deleteAllByWriterHn(String writerHn) {
        boardRepository.deleteByWriter_Hn(writerHn);
    }
}
