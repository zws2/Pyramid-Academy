package com.demo.controller;

import com.demo.entity.Part;
import com.demo.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//This is to allow calls from React... NOT IMPORTANT RIGHT NOW
@CrossOrigin(origins = { "http://localhost:3000"})
@RestController
public class PartController {

    private final PartService partService;

    //Constructor Injection: this is telling the spring framework to wire up your
    //dependencies for the partService.
    @Autowired
    public PartController(@Qualifier("partServiceIMPL") PartService partService) {
        this.partService = partService;
    }

    //This is a GET request that will read a list of all the parts.
    //http://localhost:8080/retrieveAllParts
    @GetMapping("/retrieveAllParts")
    public List<Part> findAll() {
        return partService.findAll();
    }

    //This is a GET request that will read a list of all the parts.
    //http://localhost:8080/retrievePart/0
    @GetMapping("/retrievePart/{partId}")
    public Object findPart(@PathVariable int partId) {
        return partService.findById(partId);
    }

    //This is a POST request to add a new part.
    //http://localhost:8080/addPart
    @PostMapping("/addPart/{id}/{type}/{name}/{year}/{manufacturer}/{condition}")
    public Part addPart(@PathVariable int id, @PathVariable String type, @PathVariable String name,
                        @PathVariable String year, @PathVariable String manufacturer, @PathVariable String condition) {
        //also, just in case they pass an id in JSON .... set id to 0
        //this is to force a save of new item .... instead of update
        Part p = new Part(id, type, name, year, manufacturer, condition);

        //This will call the partDqoImpl.save method to save a new part
        //through the partService
        System.out.println(p);
        partService.saveOrUpdate(p);
        return p;
    }

    //This is a PUT request to update an existing part.
    //http://localhost:8080/updatePart
    @PutMapping("/updatePart")
    public Part updatePart(@RequestBody Part updatePart) {
        //Notice thePart.setId(0); this will execute an update instead of a create
        partService.saveOrUpdate(updatePart);
        return updatePart;
    }

    //This is a DELETE request to delete an existing part.
    //http://localhost:8080/deletePart/1
    @DeleteMapping("/deletePart/{partId}")
    public String deletePart(@PathVariable int partId) {
        //This will execute the deleteByID.
        partService.deleteById(partId);
        return "Deleted part id : " + partId;
    }

}
