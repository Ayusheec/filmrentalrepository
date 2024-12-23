package com.filmrentalstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.filmrentalstore.model.FilmActor;

@Repository
public interface FilmActorRepo extends JpaRepository<FilmActor,Long> {

}
