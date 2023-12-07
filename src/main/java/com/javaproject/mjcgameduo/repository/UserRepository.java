package com.javaproject.mjcgameduo.repository;

import com.javaproject.mjcgameduo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByHn(String hn);
    public User findByCreatenum(Long createnum);
    public User findByHnAndPw(String hn, String pw);
    public List<User> findByHnContaining(String hn);
    void deleteByCreatenum(Long createnum);
}