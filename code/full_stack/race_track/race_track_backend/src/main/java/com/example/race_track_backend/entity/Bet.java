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

    @Column(name = "amount_bet")
    private double amount_bet;

    @Column(name = "timestamp")
    private String timestamp;

    @Column(name = "user_username")
    private String user_username;

    @Column(name = "horse_name")
    private String horse_name;

    @Column(name = "race_id")
    private int race_id;

    public Bet() {
    }

    public Bet(int id, double amount_bet, String timestamp, String user_username, String horse_name, int race_id) {
        this.id = id;
        this.amount_bet = amount_bet;
        this.timestamp = timestamp;
        this.user_username = user_username;
        this.horse_name = horse_name;
        this.race_id = race_id;
    }

    @Override
    public String toString() {
        return "Bet{" +
                "id=" + id +
                ", amount_bet=" + amount_bet +
                ", timestamp='" + timestamp + '\'' +
                ", user_username='" + user_username + '\'' +
                ", horse_name='" + horse_name + '\'' +
                ", race_id=" + race_id +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount_bet() {
        return amount_bet;
    }

    public void setAmount_bet(double amount_bet) {
        this.amount_bet = amount_bet;
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

    public String getHorse_name() {
        return horse_name;
    }

    public void setHorse_name(String horse_name) {
        this.horse_name = horse_name;
    }

    public int getRace_id() {
        return race_id;
    }

    public void setRace_id(int race_id) {
        this.race_id = race_id;
    }
}
