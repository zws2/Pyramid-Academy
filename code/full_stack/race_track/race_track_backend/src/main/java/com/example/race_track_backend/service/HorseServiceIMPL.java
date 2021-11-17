package com.example.race_track_backend.service;

import com.example.race_track_backend.dao.HorseDAO;
import com.example.race_track_backend.entity.Horse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorseServiceIMPL implements HorseService {

    // Injecting the horse dao layer
    private final HorseDAO horseDAO;

    @Autowired
    public HorseServiceIMPL(HorseDAO horseDAO) {
        this.horseDAO = horseDAO;
    }

    @Override
    public List<Horse> findAll() {
        return horseDAO.findAll();
    }

    @Override
    public Object findById(String name) {
        return horseDAO.findById(name);
    }

    @Override
    public void saveOrUpdate(Horse theHorse) {
        horseDAO.saveOrUpdate(theHorse);
    }

    @Override
    public void deleteById(String name) {
        horseDAO.deleteById(name);
    }
}
