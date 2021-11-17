package com.example.race_track_backend.service;

import com.example.race_track_backend.entity.Notification;

import java.util.List;

public interface NotificationService {
    List<Notification> findAll();
    Object findById(int id);
    void saveOrUpdate(Notification theNotification);
    void deleteById(int id);
}
