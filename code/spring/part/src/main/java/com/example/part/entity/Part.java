package com.example.part.entity;

import javax.persistence.*;

//Part Entity
@Entity //This will let Java know that this is an entity that we are going to map to a database table.
@Table(name = "part") //This is for the actual name of the database table we are mapping to the class.
public class Part {

    //Define fields
    @Id //This will map the primary key.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //This will auto increment your primary key
    @Column(name = "id") //This is mapping the primary key to the id column in the table.
    private int id;

    @Column(name = "type") //This will map the jobTitle field to the column named job_title in the table.
    private String type;

    //default constructor
    public Part() {
    }

    public Part(int id, String type) {
        this.id = id;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Part{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
