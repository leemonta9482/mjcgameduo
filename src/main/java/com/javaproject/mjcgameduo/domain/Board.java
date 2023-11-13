package com.javaproject.mjcgameduo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Board {

    @Id
    @Column(name="createnum", updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // 생성번호 고유값
    private int createnum;

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

    public Board(String title, String content, String game, int person, String nick){
        this.title = title;
        this.content = content;
        this.game = game;
        this.person = person;
        this.nick = nick;
    }
}
