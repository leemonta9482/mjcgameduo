package com.javaproject.mjcgameduo.dto;

public class UpdateAdminUpdate {
    private Long createnum;
    private String hn;
    private String pw;
    private String name;
    private String gender;
    private String nick;
    private int state;

    public Long getCreatenum() {
        return createnum;
    }

    public void setCreatenum(Long createnum) {
        this.createnum = createnum;
    }

    public String getHn() {
        return hn;
    }

    public void setHn(String hn) {
        this.hn = hn;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
