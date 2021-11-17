package com.example.race_track_backend.service;

import com.example.race_track_backend.dao.NotificationDAO;
import com.example.race_track_backend.entity.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceIMPL implements NotificationService {

    // Injecting the notification dao layer
    private final NotificationDAO notificationDAO;

    @Autowired
    public NotificationServiceIMPL(NotificationDAO notificationDAO) {
        this.notificationDAO = notificationDAO;
    }

    @Override
    public List<Notification> findAll() {
        return notificationDAO.findAll();
    }

    @Override
    public Object findById(int id) {
        return notificationDAO.findById(id);
    }

    @Override
    public void saveOrUpdate(Notification theNotification) {
        notificationDAO.saveOrUpdate(theNotification);
    }

    @Override
    public void deleteById(int id) {
        notificationDAO.deleteById(id);
    }
}
