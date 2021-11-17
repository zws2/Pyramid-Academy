package com.example.race_track_backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "notification")
public class Notification {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "user_username")
    private String user_username;

    @Column(name = "message")
    private String message;

    @Column(name = "is_read")
    private boolean is_read;

    public Notification() {
    }

    public Notification(int id, String user_username, String message, boolean is_read) {
        this.id = id;
        this.user_username = user_username;
        this.message = message;
        this.is_read = is_read;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "id=" + id +
                ", user_username='" + user_username + '\'' +
                ", message='" + message + '\'' +
                ", is_read=" + is_read +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_username() {
        return user_username;
    }

    public void setUser_username(String user_username) {
        this.user_username = user_username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isIs_read() {
        return is_read;
    }

    public void setIs_read(boolean is_read) {
        this.is_read = is_read;
    }
}
