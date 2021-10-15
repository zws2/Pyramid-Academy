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

    @Column(name = "type")
    private String type;

    @Column(name = "name")
    private String name;

    @Column(name = "make")
    private String make;

    @Column(name = "year")
    private String year;

    @Column(name = "part_condition")
    private String part_condition;

    //default constructor
    public Part() {
    }

    public Part(int id, String type, String name, String make, String year, String part_condition) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.make = make;
        this.year = year;
        this.part_condition = part_condition;
    }

    @Override
    public String toString() {
        return "Part{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", make='" + make + '\'' +
                ", year='" + year + '\'' +
                ", condition='" + part_condition + '\'' +
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPart_condition() {
        return part_condition;
    }

    public void setPart_condition(String part_condition) {
        this.part_condition = part_condition;
    }
}
