package com.demo.entity;

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

    @Column(name = "type") //This will map the jobTitle field to the column named type in the table.
    private String type;

    @Column(name = "name") //This will map the firstName field to the column named name in the table.
    private String name;

    @Column(name = "year") //This will map the lastName field to the column named year in the table.
    private String year;

    @Column(name = "manufacturer") //This will map the email field to the column named manufacturer in the table.
    private String manufacturer;

    @Column(name = "condition") //This will map the email field to the column named condition in the table.
    private String condition;

    //default constructor
    public Part() {
    }

    public Part(int id, String type, String name, String year, String manufacturer, String condition) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.year = year;
        this.manufacturer = manufacturer;
        this.condition = condition;
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "Part{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", year='" + year + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", condition='" + condition + '\'' +
                '}';
    }
}
