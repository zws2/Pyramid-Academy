package com.example.race_track_backend.entity;

import javax.persistence.*;
import java.sql.Blob;

//Race Entity
@Entity //This will let Java know that this is an entity that we are going to map to a database table.
@Table(name = "race") //This is for the actual name of the database table we are mapping to the class.
public class Race {

    //Define fields
    @Id //This will map the primary key.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //This will auto increment your primary key
    @Column(name = "id") //This is mapping the primary key to the id column in the table.
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "time")
    private String time;

    @Column(name = "horses")
    private String horses;

    @Column(name = "results")
    private String results;

    //default constructor
    public Race() {
    }

    public Race(int id, String title, String time, String horses, String results) {
        this.id = id;
        this.title = title;
        this.time = time;
        this.horses = horses;//json.parse
        this.results = results;//json.parse
    }

    @Override
    public String toString() {
        return "Race{" +
                "id=" + id +
                ", title='" + title + '\'' +
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
