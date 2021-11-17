package com.example.race_track_backend.controller;

import com.example.race_track_backend.service.BetService;
import com.example.race_track_backend.entity.Bet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "http://localhost:3000"})
@RestController
public class BetController {

    private final BetService betService;

    @Autowired
    public BetController(@Qualifier("betServiceIMPL")BetService betService) {
        this.betService = betService;
    }

    //http://localhost:8080/retrieveAllBets
    @GetMapping("/retrieveAllBets")
    public List<Bet> findAll() {
        return betService.findAll();
    }

    @GetMapping("/retrieveBet/{id}")
    public Bet findBet(@PathVariable int id) {
        return (Bet)betService.findById(id);
    }

    //This is a POST request to add a new bet.
    //http://localhost:8080/addBet
    @PostMapping("/addBet")
    public Bet addBet(@RequestBody Bet theBet) {
        betService.saveOrUpdate(theBet);
        return theBet;
    }

    //http://localhost:8080/updateBet
    @PutMapping("/updateBet")
    public Bet updateBet(@RequestBody Bet updateBet) {
        betService.saveOrUpdate(updateBet);
        return updateBet;
    }

    //http://localhost:8080/deleteBet/1
    @DeleteMapping("/deleteBet/{id}")
    public String deleteBet(@PathVariable int id) {
        betService.deleteById(id);
        return "Deleted bet id : " + id;
    }

}
