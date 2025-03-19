package com.petland.entity;

public class Staff {
    private Integer id;
    private Integer userId;
    private String role;
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", userId=" + userId +
                ", role='" + role + '\'' +
                ", user=" + user +
                '}';
    }
}
