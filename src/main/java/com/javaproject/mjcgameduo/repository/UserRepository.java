package com.javaproject.mjcgameduo.repository;

import com.javaproject.mjcgameduo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByHn(String hn);
    public User findByHnAndPw(String hn, String pw);
}