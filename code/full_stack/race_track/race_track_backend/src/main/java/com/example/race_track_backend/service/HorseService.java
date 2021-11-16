package com.example.race_track_backend.service;

import com.example.race_track_backend.entity.Horse;

import java.util.List;

public interface HorseService {
    List<Horse> findAll();
    Object findById(int id);
    void saveOrUpdate(Horse theHorse);
    void deleteById(int id);
}
