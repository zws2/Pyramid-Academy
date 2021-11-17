package com.example.race_track_backend.controller;

import com.example.race_track_backend.entity.User;
import com.example.race_track_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "http://localhost:3000"})
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(@Qualifier("userServiceIMPL")UserService userService) {
        this.userService = userService;
    }

    //http://localhost:8080/retrieveAllUsers
    @GetMapping("/retrieveAllUsers")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/retrieveUser/{username}")
    public User findUser(@PathVariable String username) {
        return (User)userService.findById(username);
    }

    //This is a POST request to add a new user.
    //http://localhost:8080/addUser
    @PostMapping("/addUser")
    public User addUser(@RequestBody User theUser) {
        userService.saveOrUpdate(theUser);
        return theUser;
    }

    //http://localhost:8080/updateUser
    @PutMapping("/updateUser")
    public User updateUser(@RequestBody User updateUser) {
        userService.saveOrUpdate(updateUser);
        return updateUser;
    }

    //http://localhost:8080/deleteUser/1
    @DeleteMapping("/deleteUser/{username}")
    public String deleteUser(@PathVariable String username) {
        userService.deleteById(username);
        return "Deleted user id : " + username;
    }

}
