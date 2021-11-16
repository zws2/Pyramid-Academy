package com.example.race_track_backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bet")
public class Bet {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "amount")
    private double amount;

    @Column(name = "timestamp")
    private String timestamp;

    @Column(name = "user_username")
    private String user_username;

    @Column(name = "horse_id")
    private int horse_id;

    @Column(name = "race_id")
    private int race_id;

    public Bet() {
    }

    public Bet(int id, double amount, String timestamp, String user_username, int horse_id, int race_id) {
        this.id = id;
        this.amount = amount;
        this.timestamp = timestamp;
        this.user_username = user_username;
        this.horse_id = horse_id;
        this.race_id = race_id;
    }

    @Override
    public String toString() {
        return "Bet{" +
                "id=" + id +
                ", amount=" + amount +
                ", timestamp='" + timestamp + '\'' +
                ", user_username='" + user_username + '\'' +
                ", horse_id=" + horse_id +
                ", race_id=" + race_id +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getUser_username() {
        return user_username;
    }

    public void setUser_username(String user_username) {
        this.user_username = user_username;
    }

    public int getHorse_id() {
        return horse_id;
    }

    public void setHorse_id(int horse_id) {
        this.horse_id = horse_id;
    }

    public int getRace_id() {
        return race_id;
    }

    public void setRace_id(int race_id) {
        this.race_id = race_id;
    }
}
