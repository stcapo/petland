package com.petland.entity;

import java.util.Date;

public class Reservation {
    private Integer id;
    private Integer userId;
    private Integer petId;
    private String type;
    private String status;
    private Date reservationTime;
    private Date createdAt;
    private User user;
    private Pet pet;

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

    public Integer getPetId() {
        return petId;
    }

    public void setPetId(Integer petId) {
        this.petId = petId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(Date reservationTime) {
        this.reservationTime = reservationTime;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", userId=" + userId +
                ", petId=" + petId +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                ", reservationTime=" + reservationTime +
                ", createdAt=" + createdAt +
                ", user=" + user +
                ", pet=" + pet +
                '}';
    }
}
