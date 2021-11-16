package com.example.race_track_backend.controller;

import com.example.race_track_backend.entity.Horse;
import com.example.race_track_backend.service.HorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "http://localhost:3000"})
@RestController
public class HorseController {

    private final HorseService horseService;

    @Autowired
    public HorseController(@Qualifier("horseServiceIMPL")HorseService horseService) {
        this.horseService = horseService;
    }

    //http://localhost:8080/retrieveAllHorses
    @GetMapping("/retrieveAllHorses")
    public List<Horse> findAll() {
        return horseService.findAll();
    }

    @GetMapping("/retrieveHorse/{id}")
    public Horse findHorse(@PathVariable int id) {
        return (Horse)horseService.findById(id);
    }

    //This is a POST request to add a new horse.
    //http://localhost:8080/addHorse
    @PostMapping("/addHorse")
    public Horse addHorse(@RequestBody Horse theHorse) {
        horseService.saveOrUpdate(theHorse);
        return theHorse;
    }

    //http://localhost:8080/updateHorse
    @PutMapping("/updateHorse")
    public Horse updateHorse(@RequestBody Horse updateHorse) {
        horseService.saveOrUpdate(updateHorse);
        return updateHorse;
    }

    //http://localhost:8080/deleteHorse/1
    @DeleteMapping("/deleteHorse/{id}")
    public String deleteHorse(@PathVariable int id) {
        horseService.deleteById(id);
        return "Deleted horse id : " + id;
    }

}
