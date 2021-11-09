package com.example.race_track_backend.service;

import com.example.race_track_backend.dao.UserDAO;
import com.example.race_track_backend.entity.User;
import com.example.race_track_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceIMPL implements UserService {

    // Injecting the user dao layer
    private final UserDAO userDAO;

    @Autowired
    public UserServiceIMPL(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public Object findById(int userId) {
        return userDAO.findById(userId);
    }

    @Override
    public void saveOrUpdate(User theUser) {
        userDAO.saveOrUpdate(theUser);
    }

    @Override
    public void deleteById(int userId) {
        userDAO.deleteById(userId);
    }
}
