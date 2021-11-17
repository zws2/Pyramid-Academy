package com.example.race_track_backend.dao;

import com.example.race_track_backend.entity.Notification;

import java.util.List;

public interface NotificationDAO {
    List<Notification> findAll();
    Object findById(int id);
    void saveOrUpdate(Notification theNotification);
    void deleteById(int id);
}
