package com.example.race_track_backend.dao;

import com.example.race_track_backend.entity.Bet;

import java.util.List;

public interface BetDAO {
    List<Bet> findAll();
    Object findById(int id);
    void saveOrUpdate(Bet theBet);
    void deleteById(int id);
}
