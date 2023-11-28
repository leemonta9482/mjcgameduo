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
public class Board {

    @Id
    @Column(name="createnum", updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // 생성번호 고유값
    private long createnum;

    @Column(name="title", updatable = false, nullable = false)
    // 제목
    private String title;

    @Column(name="content", updatable = false, nullable = false)
    // 내용
    private String content;

    @Column(name="game", updatable = false, nullable = false)
    // 게임종류
    private String game;

    @Column(name="person", updatable = false, nullable = false)
    @ColumnDefault("1")
    // 모집인원 기본 한명
    private int person;

    @Column(name="nick", updatable = false, nullable = false)
    // 닉네임
    private String nick;

    @CreatedDate
    @Column(name="created_at")
    private LocalDateTime createdAt;

    @OneToOne
    @JoinColumn(name="writer_createnum")
    private User writer;

    public Board(String title, String content, String game, int person, String nick){
        this.title = title;
        this.content = content;
        this.game = game;
        this.person = person;
        this.nick = nick;
    }

    public String getFormattedCreateDate(){
        if(createdAt==null){
            return "";
        }
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return createdAt.format(pattern);
    }

    public long getCreatenum() {
        return createnum;
    }

    public void setCreatenum(long createnum) {
        this.createnum = createnum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public int getPerson() {
        return person;
    }

    public void setPerson(int person) {
        this.person = person;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public User getWriter() {
        return writer;
    }

    public void setWriter(User writer) {
        this.writer = writer;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
