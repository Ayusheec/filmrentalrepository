package com.filmrentalstore.service;

import java.util.List;

import com.filmrentalstore.model.Actor;
import com.filmrentalstore.model.Film;

public interface ActorService {
	public String addActor(Actor actor);
	public List<Actor> searchActorsByLastName(String lastName);
	public List<Actor> searchActorsByFirstName(String firstName);
	public Actor updateLastName(Long actorId, String newLastName);
	public Actor updateFirstName(Long actorId, String newFirstName);
	public List<Film> getFilmsByActorId(Long actorId);
    public List<Actor> fetchAll();
}