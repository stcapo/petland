package com.petland.entity;

public class Admin {
    private Integer id;
    private Integer userId;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", userId=" + userId +
                ", user=" + user +
                '}';
    }
}
