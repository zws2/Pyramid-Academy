package com.example.race_track_backend.dao;

import com.example.race_track_backend.entity.User;

import java.util.List;

public interface UserDAO {
    List<User> findAll();
    Object findById(String username);
    void saveOrUpdate(User theUser);
    void deleteById(String username);
}
