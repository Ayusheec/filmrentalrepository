package com.filmrentalstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.filmrentalstore.model.Actor;
import com.filmrentalstore.model.Film;
import com.filmrentalstore.service.ActorService;

@RestController
@RequestMapping("/api/actors")
@CrossOrigin(origins = "http://localhost:5173")
public class ActorController {

	@Autowired
    private ActorService service;
 
    @PostMapping("/post")
    public ResponseEntity<String> addActor(@RequestBody Actor actor) {
        try {
            String result = service.addActor(actor);
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create record: " + e.getMessage());
        }
    }
 
    @GetMapping("/lastname/{ln}")
    public ResponseEntity<List<Actor>> getActorsByLastName(@PathVariable("ln") String lastName) {
        try {
            List<Actor> actors = service.searchActorsByLastName(lastName);
            return ResponseEntity.ok(actors);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
 
    @GetMapping("/firstname/{fn}")
    public ResponseEntity<List<Actor>> getActorsByFirstName(@PathVariable("fn") String firstName) {
        try {
            List<Actor> actors = service.searchActorsByFirstName(firstName);
            return ResponseEntity.ok(actors);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
 
    @PutMapping("/update/lastname/{id}")
    public ResponseEntity<Actor> updateLastName(@PathVariable("id") Long actorId, @RequestParam String lastName) {
        try {
            Actor updatedActor = service.updateLastName(actorId, lastName);
            if (updatedActor != null) {
                return ResponseEntity.ok(updatedActor);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
 
    @PutMapping("/update/firstname/{id}")
    public ResponseEntity<Actor> updateFirstName(@PathVariable("id") Long actorId, @RequestParam String firstName) {
        try {
            Actor updatedActor = service.updateFirstName(actorId, firstName);
            if (updatedActor != null) {
                return ResponseEntity.ok(updatedActor);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
 
    @GetMapping("/{id}/films")
    public ResponseEntity<List<Film>> getFilmsByActorId(@PathVariable("id") Long actorId) {
        try {
            List<Film> films = service.getFilmsByActorId(actorId);
            if (!films.isEmpty()) {
                return ResponseEntity.ok(films);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping
    public ResponseEntity<List<Actor>> fetchAllActors() {
        List<Actor> actors = service.fetchAll();
        return ResponseEntity.ok(actors);
    }
}