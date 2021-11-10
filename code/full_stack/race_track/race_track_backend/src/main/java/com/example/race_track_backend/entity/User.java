package com.example.race_track_backend.entity;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "credits")
    private String credits;

    @Column(name = "bets")
    private String bets;

    public User() {
    }

    public User(String username, String password, String email, String credits, String bets) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.credits = credits;
        this.bets = bets;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", credits='" + credits + '\'' +
                ", bets='" + bets + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCredits() {
        return credits;
    }

    public void setCredits(String credits) {
        this.credits = credits;
    }

    public String getBets() {
        return bets;
    }

    public void setBets(String bets) {
        this.bets = bets;
    }
}
