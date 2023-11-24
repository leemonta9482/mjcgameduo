package com.javaproject.mjcgameduo.dto;

import com.javaproject.mjcgameduo.domain.Board;

public class BoardResponse {
    private boolean success;
    private String message;
    private Board board;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}
