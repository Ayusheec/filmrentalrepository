package com.filmrentalstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.filmrentalstore.model.Actor;

@Repository
public interface ActorRepo extends JpaRepository<Actor,Long>{
	List<Actor> findByLastName(String lastName);
	List<Actor> findByFirstName(String firstName);  
}
