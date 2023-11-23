package com.javaproject.mjcgameduo.dto;

import com.javaproject.mjcgameduo.domain.User;

public class UserResponse {
    private boolean success;
    private String message;
    private User user;
    private int admin;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getAdmin() {
        return admin;
    }
    public void setAdmin(int admin) {
        this.admin = admin;
    }
}
