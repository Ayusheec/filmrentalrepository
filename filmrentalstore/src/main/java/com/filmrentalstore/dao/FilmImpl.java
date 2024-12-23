package com.filmrentalstore.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filmrentalstore.exception.InvalidException;
import com.filmrentalstore.model.Actor;
import com.filmrentalstore.model.Category;
import com.filmrentalstore.model.Film;
import com.filmrentalstore.model.Language;
import com.filmrentalstore.model.LanguageEnum;
import com.filmrentalstore.model.Rating;
import com.filmrentalstore.repository.ActorRepo;
import com.filmrentalstore.repository.CategoryRepo;
import com.filmrentalstore.repository.FilmActorRepo;
import com.filmrentalstore.repository.FilmRepo;
import com.filmrentalstore.repository.LanguageRepo;
import com.filmrentalstore.service.FilmService;

@Service
public class FilmImpl implements FilmService{
	@Autowired
    private FilmRepo filmRepo;
	
	@Autowired
    private CategoryRepo categoryRepository;
	
	@Autowired
	private ActorRepo actorRepository;
	
	@Autowired
	private FilmActorRepo filmActorRepo;
	
	@Autowired
	private LanguageRepo languageRepo;
	
    @Override
    public Film addFilm(Film film) {
        return filmRepo.save(film);
    }

	@Override
	public List<Film> searchFilmsByTitle(String title) {
		return filmRepo.findByTitle(title);
	}

	@Override
	public List<Film> getFilmsByYear(int releaseYear) {
		return filmRepo.findByReleaseYear(releaseYear);
	}

	@Override
	public List<Film> findByRentalDurationGreaterThan(int rentalDuration) {
		return filmRepo.findByRentalDurationGreaterThan(rentalDuration);
	}

	@Override
	public List<Film> getFilmsByRentalRateGreaterThan(long rentalRate) {
		return filmRepo.findByRentalRateGreaterThan(rentalRate);
	}

	@Override
	public List<Film> getFilmsByLengthGreaterThan(long length) {
		return filmRepo.findByLengthGreaterThan(length);
	}

	@Override
	public List<Film> getFilmsByRentalDurationLessThan(int rentalDuration) {
		return filmRepo.findByRentalDurationLessThan(rentalDuration);
	}

	@Override
	public List<Film> getFilmsByRentalRateLessThan(long rentalRate) {
		return filmRepo.findByRentalRateLessThan(rentalRate);
	}

	@Override
	public List<Film> getFilmsByLengthLessThan(long length) {
		return filmRepo.findByLengthLessThan(length);
	}

	@Override
	public List<Film> getFilmsByReleaseYearBetween(int from, int to) {
		return filmRepo.findByReleaseYearBetween(from, to);
	}

	@Override
	public List<Film> getFilmsByRatingLowerThan(Rating rating) {
	    return filmRepo.findByRatingLessThan(rating);
	}

	@Override
	public List<Film> getFilmsByRatingGreaterThan(Rating rating) {
		return filmRepo.findByRatingGreaterThan(rating);
	}
	
	@Override
	public List<Film> getFilmsByLanguage(LanguageEnum language) {
		return filmRepo.findByLanguage_Name(language);
	}


	@Override
    public List<Map<String, Object>> getFilmCountByYear() {
        List<Object[]> results = filmRepo.countFilmsByYear();
        List<Map<String, Object>> resultList = new ArrayList<>();
        for (Object[] result : results) {
            Map<String, Object> map = new HashMap<>();
            map.put("year", result[0]);
            map.put("count", result[1]);
            resultList.add(map);
        }
        return resultList;
	}

	@Override
	public List<Actor> getActorsForFilm(Long filmId) {
		Optional<Film> filmOptional = filmRepo.findById(filmId);
        if (filmOptional.isPresent()) {
            return filmOptional.get().getActors(); 
        } else {
            return null;
        }
	}

	@Override
	public List<Film> getFilmsByCategory(String categoryName) {
        Category category = categoryRepository.findByName(categoryName)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        return filmRepo.findByCategories(category);
    }
	
	@Override
	public Film updateFilmTitle(Long filmId, String newTitle) {
		Film film = filmRepo.findById(filmId)
                .orElseThrow(() -> new RuntimeException("Film not found"));
        film.setTitle(newTitle);
        return filmRepo.save(film);
	}

	@Override
	public Film updateReleaseYear(Long filmId, int releaseYear) {
		Film film = filmRepo.findById(filmId)
                .orElseThrow(() -> new RuntimeException("Film not found"));
        film.setReleaseYear(releaseYear);
        return filmRepo.save(film);
	}

	@Override
	public Film updateRentalDuration(Long filmId, int rentalDuration) {
		Film film = filmRepo.findById(filmId)
                .orElseThrow(() -> new RuntimeException("Film not found"));
        film.setRentalDuration(rentalDuration);
        return filmRepo.save(film);
	}

	@Override
	public Film updateRentalRate(Long filmId, double rentalRate) {
		Film film = filmRepo.findById(filmId)
                .orElseThrow(() -> new RuntimeException("Film not found"));
        film.setRentalRate(rentalRate);
        return filmRepo.save(film);
	}

	@Override
	public Film updateRating(Long filmId, Rating rating) {
		Film film = filmRepo.findById(filmId)
                .orElseThrow(() -> new RuntimeException("Film not found"));
        film.setRating(rating);
        return filmRepo.save(film);
	}

	@Override
	public Film updateLanguage(Long filmId, Long languageId) {
	    Film film = filmRepo.findById(filmId)
	            .orElseThrow(() -> new RuntimeException("Film not found"));
	    Language language = languageRepo.findById(languageId)
	            .orElseThrow(() -> new RuntimeException("Language not found"));
	    film.setLanguage(language);
	    return filmRepo.save(film);
	}

	@Override
	public Film updateCategory(Long filmId, Long categoryId) {
		Film film = filmRepo.findById(filmId).orElseThrow(() -> new RuntimeException("Film not found"));
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new RuntimeException("Category not found"));
        film.getCategories().clear();
        film.getCategories().add(category);
        return filmRepo.save(film);
	}

	@Override
	public List<Film> fetchAll() {
		List<Film> list =filmRepo.findAll();
		return list;
	}

	@Override
	public Film getById(long filmId) throws InvalidException {
		return filmRepo.findById(filmId)
                .orElseThrow(() -> new InvalidException("Film not found with id: " + filmId));
	}

	@Override
	public Film updateFilm(long filmId, Film film) {
		Optional<Film> existingFilmOpt = filmRepo.findById(filmId);
        if (existingFilmOpt.isPresent()) {
            Film existingFilm = existingFilmOpt.get();
            // Update fields
            existingFilm.setTitle(film.getTitle());
            existingFilm.setDescription(film.getDescription());
            existingFilm.setReleaseYear(film.getReleaseYear());
            existingFilm.setRentalDuration(film.getRentalDuration());
            existingFilm.setRentalRate(film.getRentalRate());
            existingFilm.setRating(film.getRating());
            // Save updated film
            return filmRepo.save(existingFilm);
        } else {
            // If film is not found, return null or handle appropriately
            return null;
        }
    }

	@Override
	public void deleteFilmById(long filmId) {
		if (filmRepo.existsById(filmId)) {
            filmRepo.deleteById(filmId);
        } else {
            throw new RuntimeException("Film not found with id: " + filmId);
        }
	}
}
