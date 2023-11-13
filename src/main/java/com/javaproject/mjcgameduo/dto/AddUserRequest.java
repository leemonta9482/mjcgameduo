package com.javaproject.mjcgameduo.dto;

import com.javaproject.mjcgameduo.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddUserRequest {
    private String hn;
    private String pw;
    private String name;
    private String gender;
    private String nick;
    private int state;

    public User toEntity(){
        User user = new User(hn,  pw, name, gender, nick, state);
        return user;
    }
}
