package com.javaproject.mjcgameduo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="createnum", updatable = false)
    // 생성번호 고유값
    private Long createnum;

    @Column(name="hn", nullable = false, unique = true)
    // 아이디 (학번) 고유값
    private String hn;

    @Column(name="pw")
    // 비밀번호
    private String pw;

    @Column(name = "name")
    // 이름bbbbbb
    private String name;

    @Column(name = "gender")
    // 성별
    private String gender;

    @Column(name = "nick")
    // 닉네임
    private String nick;

    @Column(name = "state")
    @ColumnDefault("0")
    // 상태
    private int state;


    public User(String hn, String pw, String name, String gender, String nick, int state){
        this.hn = hn;
        this.pw = pw;
        this.name = name;
        this.gender = gender;
        this.nick = nick;
        this.state = state;
    }

    public void update(String pw, String nick){
        this.pw = pw;
        this.nick = nick;
    }

    public void adminUpdate(String hn, String pw, String name, String gender, String nick, int state){
        this.hn = hn;
        this.pw = pw;
        this.name = name;
        this.gender = gender;
        this.nick = nick;
        this.state = state;
    }

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
