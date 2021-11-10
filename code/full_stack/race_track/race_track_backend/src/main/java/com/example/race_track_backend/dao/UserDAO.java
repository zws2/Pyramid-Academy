package com.example.race_track_backend.dao;

import com.example.race_track_backend.entity.User;

import java.util.List;

public interface UserDAO {
    List<User> findAll();
    Object findById(int theId);
    void saveOrUpdate(User theUser);
    void deleteById(int theId);
}
