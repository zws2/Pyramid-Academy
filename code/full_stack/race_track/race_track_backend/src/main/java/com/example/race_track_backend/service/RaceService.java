package com.example.race_track_backend.service;

import com.example.race_track_backend.entity.Race;

import java.util.List;

public interface RaceService {
    List<Race> findAll();
    Object findById(int raceId);
    void saveOrUpdate(Race theRace);
    void deleteById(int raceId);
}
