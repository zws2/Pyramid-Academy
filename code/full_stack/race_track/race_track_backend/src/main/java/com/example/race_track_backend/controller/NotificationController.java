package com.example.race_track_backend.controller;

import com.example.race_track_backend.entity.Notification;
import com.example.race_track_backend.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "http://localhost:3000"})
@RestController
public class NotificationController {

    private final NotificationService notificationService;

    @Autowired
    public NotificationController(@Qualifier("notificationServiceIMPL") NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    //http://localhost:8080/retrieveAllNotifications
    @GetMapping("/retrieveAllNotifications")
    public List<Notification> findAll() {
        return notificationService.findAll();
    }

    @GetMapping("/retrieveNotification/{id}")
    public Notification findNotification(@PathVariable int id) {
        return (Notification)notificationService.findById(id);
    }

    //This is a POST request to add a new notification.
    //http://localhost:8080/addNotification
    @PostMapping("/addNotification")
    public Notification addNotification(@RequestBody Notification theNotification) {
        notificationService.saveOrUpdate(theNotification);
        return theNotification;
    }

    //http://localhost:8080/updateNotification
    @PutMapping("/updateNotification")
    public Notification updateNotification(@RequestBody Notification updateNotification) {
        notificationService.saveOrUpdate(updateNotification);
        return updateNotification;
    }

    //http://localhost:8080/deleteNotification/1
    @DeleteMapping("/deleteNotification/{id}")
    public String deleteNotification(@PathVariable int id) {
        notificationService.deleteById(id);
        return "Deleted notification id : " + id;
    }

}
