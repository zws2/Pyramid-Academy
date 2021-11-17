package com.example.race_track_backend.entity;

import javax.persistence.*;

@Entity
@Table(name = "race")
public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "time")
    private String time;

    @Column(name = "horses")
    private String horses;

    @Column(name = "results")
    private String results;

    //default constructor
    public Race() {
    }

    public Race(int id, String time, String horses, String results) {
        this.id = id;
        this.time = time;
        this.horses = horses;
        this.results = results;
    }

    @Override
    public String toString() {
        return "Race{" +
                "id=" + id +
                ", time='" + time + '\'' +
                ", horses='" + horses + '\'' +
                ", results='" + results + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getHorses() {
        return horses;
    }

    public void setHorses(String horses) {
        this.horses = horses;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }
}
