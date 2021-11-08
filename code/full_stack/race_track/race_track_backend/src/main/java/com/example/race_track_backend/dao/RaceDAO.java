package com.example.race_track_backend.dao;

import com.example.race_track_backend.entity.Race;

import java.util.List;

public interface RaceDAO {
    List<Race> findAll();
    Object findById(int theId);
    void saveOrUpdate(Race theRace);
    void deleteById(int theId);
}
