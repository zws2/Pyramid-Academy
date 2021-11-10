package com.example.race_track_backend.service;

import com.example.race_track_backend.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    Object findById(int userId);
    void saveOrUpdate(User theUser);
    void deleteById(int userId);
}
