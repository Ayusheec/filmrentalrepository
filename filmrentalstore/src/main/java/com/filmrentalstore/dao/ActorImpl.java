package com.filmrentalstore.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filmrentalstore.model.Actor;
import com.filmrentalstore.model.Film;
import com.filmrentalstore.repository.ActorRepo;
import com.filmrentalstore.service.ActorService;

@Service
public class ActorImpl implements ActorService {

	@Autowired
    private ActorRepo repos;
 
    @Override
    public String addActor(Actor actor) {
        try {
            repos.save(actor);
            return "Record Created Successfully";
        } catch (Exception e) {
            throw new RuntimeException("Error while creating record: " + e.getMessage());
        }
    }
 
    @Override
    public List<Actor> searchActorsByLastName(String lastName) {
        try {
            return repos.findByLastName(lastName);
        } catch (Exception e) {
            throw new RuntimeException("Error while fetching actors by last name: " + e.getMessage());
        }
    }
 
    @Override
    public List<Actor> searchActorsByFirstName(String firstName) {
        try {
            return repos.findByFirstName(firstName);
        } catch (Exception e) {
            throw new RuntimeException("Error while fetching actors by first name: " + e.getMessage());
        }
    }
 
    @Override
    public Actor updateLastName(Long actorId, String newLastName) {
        try {
            Optional<Actor> opt = repos.findById(actorId);
            if (opt.isPresent()) {
                Actor actor = opt.get();
                actor.setLastName(newLastName);
                return repos.save(actor);
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException("Error while updating last name: " + e.getMessage());
        }
    }
 
    @Override
    public Actor updateFirstName(Long actorId, String newFirstName) {
        try {
            Optional<Actor> opt = repos.findById(actorId);
            if (opt.isPresent()) {
                Actor actor = opt.get();
                actor.setFirstName(newFirstName);
                return repos.save(actor);
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException("Error while updating first name: " + e.getMessage());
        }
    }
 
    @Override
    public List<Film> getFilmsByActorId(Long actorId) {
        try {
            Optional<Actor> opt = repos.findById(actorId);
            if (opt.isPresent()) {
                Actor actor = opt.get();
                return actor.getFilms();
            } else {
                return List.of();
            }
        } catch (Exception e) {
            throw new RuntimeException("Error while fetching films by actor ID: " + e.getMessage());
        }
    }
    @Override
    public List<Actor> fetchAll() {
        return repos.findAll();
    }
	
}