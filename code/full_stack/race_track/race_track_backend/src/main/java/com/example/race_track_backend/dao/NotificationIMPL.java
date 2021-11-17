package com.example.race_track_backend.dao;

//IMPORTANT If your code is not working your imports might be incorrect

import com.example.race_track_backend.entity.Notification;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class NotificationIMPL implements NotificationDAO {

    //Define field for entity manager
    /*The EntityManager API is used to create and remove persistent entity instances,
        to find entities by their primary key, and to query over entities. */
    private final EntityManager entityManager;

    //Set up constructor injection
    @Autowired
    public NotificationIMPL(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional //Defines the scope of a single database transaction.
    public List<Notification> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Notification> myQuery = currentSession.createQuery("from Notification");
        return myQuery.getResultList();
    }

    @Override
    @Transactional //Defines the scope of a single database transaction.
    public Notification findById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.get(Notification.class, id);
    }

    @Override
    @Transactional //Defines the scope of a single database transaction.
    public void saveOrUpdate(Notification theNotification) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(theNotification);
    }

    @Override
    @Transactional //Defines the scope of a single database transaction.
    public void deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Notification myNotification = currentSession.get(Notification.class, id);
        currentSession.delete(myNotification);
    }
}
