package com.example.race_track_backend.dao;

//IMPORTANT If your code is not working your imports might be incorrect

import com.example.race_track_backend.entity.Race;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class RaceIMPL implements RaceDAO {

    //Define field for entity manager
    /*The EntityManager API is used to create and remove persistent entity instances,
        to find entities by their primary key, and to query over entities. */
    private final EntityManager entityManager;

    //Set up constructor injection
    @Autowired
    public RaceIMPL(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional //Defines the scope of a single database transaction.
    public List<Race> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Race> myQuery = currentSession.createQuery("from Race");
        return myQuery.getResultList();
    }

    @Override
    @Transactional //Defines the scope of a single database transaction.
    public Race findById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.get(Race.class, theId);
    }

    @Override
    @Transactional //Defines the scope of a single database transaction.
    public void saveOrUpdate(Race theRace) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(theRace);
    }

    @Override
    @Transactional //Defines the scope of a single database transaction.
    public void deleteById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Race myRace = currentSession.get(Race.class, theId);
        currentSession.delete(myRace);
    }
}
