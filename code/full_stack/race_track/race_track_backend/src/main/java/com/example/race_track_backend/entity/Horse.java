package com.example.race_track_backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "horse")
public class Horse {

    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "fitness")
    private float fitness;

    @Column(name = "record")
    private String record;


    public Horse() {
    }

    public Horse(String name, float fitness, String record) {
        this.name = name;
        this.fitness = fitness;
        this.record = record;
    }

    @Override
    public String toString() {
        return "Horse{" +
                "name='" + name + '\'' +
                ", fitness=" + fitness +
                ", record='" + record + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getFitness() {
        return fitness;
    }

    public void setFitness(float fitness) {
        this.fitness = fitness;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }
}
