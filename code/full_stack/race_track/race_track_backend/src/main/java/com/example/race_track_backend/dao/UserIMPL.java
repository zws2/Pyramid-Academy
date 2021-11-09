package com.example.race_track_backend.dao;

//IMPORTANT If your code is not working your imports might be incorrect

import com.example.race_track_backend.dao.UserDAO;
import com.example.race_track_backend.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserIMPL implements UserDAO {

    //Define field for entity manager
    /*The EntityManager API is used to create and remove persistent entity instances,
        to find entities by their primary key, and to query over entities. */
    private final EntityManager entityManager;

    //Set up constructor injection
    @Autowired
    public UserIMPL(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional //Defines the scope of a single database transaction.
    public List<User> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<User> myQuery = currentSession.createQuery("from User");
        return myQuery.getResultList();
    }

    @Override
    @Transactional //Defines the scope of a single database transaction.
    public User findById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.get(User.class, theId);
    }

    @Override
    @Transactional //Defines the scope of a single database transaction.
    public void saveOrUpdate(User theUser) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(theUser);
    }

    @Override
    @Transactional //Defines the scope of a single database transaction.
    public void deleteById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        User myUser = currentSession.get(User.class, theId);
        currentSession.delete(myUser);
    }
}
