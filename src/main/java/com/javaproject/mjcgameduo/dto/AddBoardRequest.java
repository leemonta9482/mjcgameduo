package com.javaproject.mjcgameduo.dto;

import com.javaproject.mjcgameduo.domain.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddBoardRequest {

    private String title;
    private String content;
    private String game;
    private int person;
    private String nick;

    public Board toEntity(){
        Board board = new Board(title,  content, game, person, nick);
        return board;
    }
}
