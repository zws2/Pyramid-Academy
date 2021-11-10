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

    @GetMapping("/retrieveUser/{userId}")
    public User findUser(@PathVariable int userId) {
        return (User)userService.findById(userId);
    }

    //This is a POST request to add a new user.
    //http://localhost:8080/addUser
    @PostMapping("/addUser")
    public User addUser(@RequestBody User theUser) {
        theUser.setId(0);

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
    @DeleteMapping("/deleteUser/{userId}")
    public String deleteUser(@PathVariable int userId) {
        userService.deleteById(userId);
        return "Deleted user id : " + userId;
    }

}
