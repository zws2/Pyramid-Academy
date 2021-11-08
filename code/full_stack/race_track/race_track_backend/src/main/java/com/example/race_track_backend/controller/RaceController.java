package com.example.race_track_backend.controller;

import com.example.race_track_backend.entity.Race;
import com.example.race_track_backend.service.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//This is to allow calls from React... NOT IMPORTANT RIGHT NOW
@CrossOrigin(origins = { "http://localhost:3000"})
@RestController
public class RaceController {

    private final RaceService raceService;

    //Constructor Injection: this is telling the spring framework to wire up your
    //dependencies for the raceService.
    @Autowired
    public RaceController(@Qualifier("raceServiceIMPL")RaceService raceService) {
        this.raceService = raceService;
    }

    //This is a GET request that will read a list of all the races.
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
        //also, just in case they pass an id in JSON .... set id to 0
        //this is to force a save of new item .... instead of update
        theRace.setId(0);

        //This will call the raceDqoImpl.save method to save a new race
        //through the raceService
        raceService.saveOrUpdate(theRace);
        return theRace;
    }

    //This is a PUT request to update an existing race.
    //http://localhost:8080/updateRace
    @PutMapping("/updateRace")
    public Race updateRace(@RequestBody Race updateRace) {
        //Notice theRace.setId(0); this will execute an update instead of a create
        raceService.saveOrUpdate(updateRace);
        return updateRace;
    }

    //This is a DELETE request to delete an existing race.
    //http://localhost:8080/deleteRace/1
    @DeleteMapping("/deleteRace/{raceId}")
    public String deleteRace(@PathVariable int raceId) {
        //This will execute the deleteByID.
        raceService.deleteById(raceId);
        return "Deleted race id : " + raceId;
    }

}
