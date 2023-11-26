package com.javaproject.mjcgameduo.dto;

public class UpdateUserRequest {
    private String pw;
    private String nick;

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }
}
