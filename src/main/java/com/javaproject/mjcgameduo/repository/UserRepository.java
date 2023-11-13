package com.javaproject.mjcgameduo.repository;

import com.javaproject.mjcgameduo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
