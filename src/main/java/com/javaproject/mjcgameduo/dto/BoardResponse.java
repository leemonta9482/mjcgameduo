package com.javaproject.mjcgameduo.dto;

import com.javaproject.mjcgameduo.domain.Board;

public class BoardResponse {
    private boolean success;
    private String massage;
    private Board board;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}
