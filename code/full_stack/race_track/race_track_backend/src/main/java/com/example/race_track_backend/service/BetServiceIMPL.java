package com.example.race_track_backend.service;

import com.example.race_track_backend.dao.BetDAO;
import com.example.race_track_backend.entity.Bet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BetServiceIMPL implements BetService {

    // Injecting the bet dao layer
    private final BetDAO betDAO;

    @Autowired
    public BetServiceIMPL(BetDAO betDAO) {
        this.betDAO = betDAO;
    }

    @Override
    public List<Bet> findAll() {
        return betDAO.findAll();
    }

    @Override
    public Object findById(int id) {
        return betDAO.findById(id);
    }

    @Override
    public void saveOrUpdate(Bet theBet) {
        betDAO.saveOrUpdate(theBet);
    }

    @Override
    public void deleteById(int id) {
        betDAO.deleteById(id);
    }
}
