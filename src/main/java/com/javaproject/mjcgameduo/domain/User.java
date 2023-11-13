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
public class User {

    @Column(name="createnum", updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // 생성번호 고유값
    private int createnum;

    @Id
    @Column(name="hn", updatable = false, nullable = false)
    // 아이디 (학번) 고유값
    private String hn;

    @Column(name="pw", nullable = false)
    // 비밀번호
    private String pw;

    @Column(name = "name", nullable = false)
    // 이름
    private String name;

    @Column(name = "gender", nullable = false)
    // 성별
    private String gender;

    @Column(name = "nick", nullable = false)
    // 닉네임
    private String nick;

    @Column(name = "state", nullable = false)
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
}
