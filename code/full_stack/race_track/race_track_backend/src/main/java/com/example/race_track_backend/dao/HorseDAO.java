package com.example.race_track_backend.dao;

import com.example.race_track_backend.entity.Horse;

import java.util.List;

public interface HorseDAO {
    List<Horse> findAll();
    Object findById(String name);
    void saveOrUpdate(Horse theHorse);
    void deleteById(String name);
}
