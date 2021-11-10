package com.example.race_track_backend.controller;

import com.example.race_track_backend.entity.Race;
import com.example.race_track_backend.service.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "http://localhost:3000"})
@RestController
public class RaceController {

    private final RaceService raceService;

    @Autowired
    public RaceController(@Qualifier("raceServiceIMPL")RaceService raceService) {
        this.raceService = raceService;
    }

    //http://localhost:8080/retrieveAllRaces
    @GetMapping("/retrieveAllRaces")
    public List<Race> findAll() {
        return raceService.findAll();
    }

    @GetMapping("/retrieveRace/{raceId}")
    public Race findRace(@PathVariable int raceId) {
        return (Race)raceService.findById(raceId);
    }

    //This is a POST request to add a new race.
    //http://localhost:8080/addRace
    @PostMapping("/addRace")
    public Race addRace(@RequestBody Race theRace) {
        theRace.setId(0);

        raceService.saveOrUpdate(theRace);
        return theRace;
    }

    //http://localhost:8080/updateRace
    @PutMapping("/updateRace")
    public Race updateRace(@RequestBody Race updateRace) {
        raceService.saveOrUpdate(updateRace);
        return updateRace;
    }

    //http://localhost:8080/deleteRace/1
    @DeleteMapping("/deleteRace/{raceId}")
    public String deleteRace(@PathVariable int raceId) {
        raceService.deleteById(raceId);
        return "Deleted race id : " + raceId;
    }

}
