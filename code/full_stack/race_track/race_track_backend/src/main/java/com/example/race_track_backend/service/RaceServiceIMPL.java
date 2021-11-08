package com.example.race_track_backend.service;

import com.example.race_track_backend.dao.RaceDAO;
import com.example.race_track_backend.entity.Race;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaceServiceIMPL implements RaceService {

    // Injecting the race dao layer
    private final RaceDAO raceDAO;

    @Autowired
    public RaceServiceIMPL(RaceDAO raceDAO) {
        this.raceDAO = raceDAO;
    }

    @Override
    public List<Race> findAll() {
        return raceDAO.findAll();
    }

    @Override
    public Object findById(int raceId) {
        return raceDAO.findById(raceId);
    }

    @Override
    public void saveOrUpdate(Race theRace) {
        raceDAO.saveOrUpdate(theRace);
    }

    @Override
    public void deleteById(int raceId) {
        raceDAO.deleteById(raceId);
    }
}
