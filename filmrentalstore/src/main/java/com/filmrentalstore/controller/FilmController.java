package com.filmrentalstore.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.filmrentalstore.exception.InvalidException;
import com.filmrentalstore.model.Actor;
import com.filmrentalstore.model.Film;
import com.filmrentalstore.model.LanguageEnum;
import com.filmrentalstore.model.Rating;
import com.filmrentalstore.repository.LanguageRepo;
import com.filmrentalstore.service.FilmService;

@RestController
@RequestMapping(value = "/api/films")
@CrossOrigin(origins = "http://localhost:5173")
public class FilmController {
	
	@Autowired
	private FilmService service;
		
	@Autowired
	private LanguageRepo languageRepo;
	
	@PostMapping("/post")
	public ResponseEntity<Film> createFilm(@RequestBody Film film) {
	    Film createdFilm = service.addFilm(film);
	    return new ResponseEntity<>(createdFilm, HttpStatus.CREATED);
	}
	
	@GetMapping("/title/{title}")
    public ResponseEntity<List<Film>> getFilmsByTitle(@PathVariable String title) {
        List<Film> films = service.searchFilmsByTitle(title);
        if (films.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(films);
    }
	
	@GetMapping("/year/{releaseYear}")
	public ResponseEntity<List<Film>> getFilmsByYear(@PathVariable int releaseYear) {
        List<Film> films = service.getFilmsByYear(releaseYear);
        if (films.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(films);
    }
	
	@GetMapping("/duration/gt/{rd}")
    public ResponseEntity<List<Film>> getFilmsByRentalDurationGreaterThan(@PathVariable int rd) {
        List<Film> films = service.findByRentalDurationGreaterThan(rd);
        if (films.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(films);
    }
	
	@GetMapping("/rate/gt/{rate}")
    public ResponseEntity<List<Film>> getFilmsByRentalRateGreaterThan(@PathVariable long rate) {
        List<Film> films = service.getFilmsByRentalRateGreaterThan(rate);
        if (films.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(films);
    }
	
	@GetMapping("/length/gt/{length}")
    public ResponseEntity<List<Film>> getFilmsByLengthGreaterThan(@PathVariable long length) {
        List<Film> films = service.getFilmsByLengthGreaterThan(length);
        if (films.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(films);
    }
	
	@GetMapping("/duration/lt/{rd}")
    public ResponseEntity<List<Film>> getFilmsByRentalDurationLessThan(@PathVariable int rd) {
        List<Film> films = service.getFilmsByRentalDurationLessThan(rd);
        if (films.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(films);
    }
	
	@GetMapping("/rate/lt/{rate}")
    public ResponseEntity<List<Film>> getFilmsByRentalRateLessThan(@PathVariable long rate) {
        List<Film> films = service.getFilmsByRentalRateLessThan(rate);
        if (films.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(films);
    }
	
	@GetMapping("/length/lt/{length}")
    public ResponseEntity<List<Film>> getFilmsByLengthLessThan(@PathVariable long length) {
        List<Film> films = service.getFilmsByLengthLessThan(length);
        if (films.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(films);
    }
	
	@GetMapping("/betweenyear/{from}/{to}")
    public ResponseEntity<List<Film>> getFilmsByReleaseYearBetween(@PathVariable int from, @PathVariable int to) {
        List<Film> films = service.getFilmsByReleaseYearBetween(from, to);
        if (films.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(films);
    }
	
	@GetMapping("/rating/lt/{rating}")
	public ResponseEntity<List<Film>> getFilmsByRatingLowerThan(@PathVariable Rating rating) {
	    List<Film> films = service.getFilmsByRatingLowerThan(rating);
	    return ResponseEntity.ok(films);
	}	
	
	@GetMapping("/rating/gt/{rating}")
    public ResponseEntity<List<Film>> getFilmsByRatingGreaterThan(@PathVariable Rating rating) {
        List<Film> films = service.getFilmsByRatingGreaterThan(rating);
        return ResponseEntity.ok(films);
    }
	       
	@GetMapping("/language/{lang}")
    public ResponseEntity<List<Film>> getFilmsByLanguage(@PathVariable("lang") LanguageEnum lang) {
        List<Film> films = service.getFilmsByLanguage(lang);
        return ResponseEntity.ok(films);
    }
    
    @GetMapping("/countbyyear")
    public ResponseEntity<List<Map<String, Object>>> getFilmCountByYear() {
        List<Map<String, Object>> filmCountByYear = service.getFilmCountByYear();
        return ResponseEntity.ok(filmCountByYear);
    }
    
    @GetMapping("/{id}/actors")
    public ResponseEntity<List<Actor>> getActorsByFilmId(@PathVariable Long id) {
        List<Actor> actors = service.getActorsForFilm(id);

        if (actors == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        
        return ResponseEntity.status(HttpStatus.OK).body(actors);
    }
    
    @GetMapping("/category/{category}")
    public List<Film> getFilmsByCategory(@PathVariable String category) {
        return service.getFilmsByCategory(category);
    }
    @GetMapping("/fetchall")
    public ResponseEntity<List<Film>> viewAll() {
        List<Film> films = service.fetchAll();
        if (films.isEmpty()) {
            return ResponseEntity.noContent().build(); // Return 204 if no films found
        } else {
            return ResponseEntity.ok(films); // Return 200 with the list of films
        }
    }
    
//    @PutMapping("/update/actor/{filmId}")
//    public ResponseEntity<Film> assignActorToFilm(@PathVariable("filmId") Long filmId, @RequestParam("actorId") Long actorId) {
//        Film updatedFilm = service.assignActorToFilm(filmId, actorId);
//        return ResponseEntity.ok(updatedFilm);
//    }
    
//  http://localhost:8080/api/films/update/title/1?title=New Film Title
    @PutMapping("/update/title/{id}")
    public Film updateFilmTitle(@PathVariable("id") Long filmId, @RequestParam("title") String newTitle) {
        return service.updateFilmTitle(filmId, newTitle);
    }
    
//    http://localhost:8080/api/films/update/releaseyear/1?year=2024
    @PutMapping("/update/releaseyear/{id}")
    public Film updateReleaseYear(@PathVariable("id") Long filmId, @RequestParam("year") int releaseYear) {
        return service.updateReleaseYear(filmId, releaseYear);
    }
    
//    http://localhost:8080/api/films/update/rentalduration/1?duration=7
    @PutMapping("/update/rentalduration/{id}")
    public ResponseEntity<Film> updateRentalDuration(@PathVariable("id") Long filmId, 
                                                     @RequestParam("duration") int rentalDuration) {
        Film updatedFilm = service.updateRentalDuration(filmId, rentalDuration);
        
        // Return a ResponseEntity with status 200 OK if the update is successful
        if (updatedFilm != null) {
            return ResponseEntity.ok(updatedFilm);
        } else {
            // Return a ResponseEntity with status 404 NOT FOUND if the film is not found
            return ResponseEntity.notFound().build();
        }
    }
    
//    http://localhost:8080/api/films/update/rentalrate/1?rate=4.99
    @PutMapping("/update/rentalrate/{id}")
    public Film updateRentalRate(@PathVariable("id") Long filmId, @RequestParam("rate") double rentalRate) {
        return service.updateRentalRate(filmId, rentalRate);
    }
    
//    http://localhost:8080/api/films/update/rating/1?rating=PG_13
    @PutMapping("/update/rating/{id}")
    public Film updateRating(@PathVariable Long id, @RequestParam Rating rating) {
        return service.updateRating(id, rating);
    }
    
//    http://localhost:8080/api/films/update/language/1/2
    @PutMapping("/update/language/{filmId}/{languageId}")
    public ResponseEntity<Film> updateLanguage(
        @PathVariable("filmId") Long filmId, 
        @PathVariable("languageId") Long languageId) {
        Film updatedFilm = service.updateLanguage(filmId, languageId);
        return ResponseEntity.ok(updatedFilm);
    }
    
//    http://localhost:8080/api/films/update/category/1?categoryId=2
    @PutMapping("/update/category/{id}")
    public ResponseEntity<Film> updateCategory(@PathVariable("id") Long filmId, @RequestParam("categoryId") Long categoryId) {
        Film updatedFilm = service.updateCategory(filmId, categoryId);
        return ResponseEntity.ok(updatedFilm);
    }
    
    // Endpoint to get a Film by ID
    @GetMapping("/films/{id}")
    public ResponseEntity<?> getFilmById(@PathVariable long id) {
        try {
            Film film = service.getById(id);  // Call the service layer
            return ResponseEntity.ok(film);  // Return 200 OK with the film object
        } catch (InvalidException e) {
            return ResponseEntity.status(404).body(e.getMessage());  // Return 404 with error message
        }
    }
       
    @CrossOrigin(origins = "http://localhost:5173")
    @PutMapping("/update/details/{filmId}")
    public ResponseEntity<Film> updateFilm(@PathVariable("filmId") long filmId, @RequestBody Film film) {
        Film updatedFilm = service.updateFilm(filmId, film);
        if (updatedFilm != null) {
            return ResponseEntity.ok(updatedFilm);
        } else {
            return ResponseEntity.notFound().build(); // If the film is not found, return 404
        }
    }
    
    @CrossOrigin("http://localhost:5173")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFilm(@PathVariable("id") long id) {
        try {
            service.deleteFilmById(id);
            return ResponseEntity.ok("Film deleted successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}
