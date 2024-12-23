package com.filmrentalstore.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.filmrentalstore.exception.InvalidException;
import com.filmrentalstore.model.Actor;
import com.filmrentalstore.model.Film;
import com.filmrentalstore.model.LanguageEnum;
import com.filmrentalstore.model.Rating;

public interface FilmService {
	public Film addFilm(Film film);
	public List<Film> searchFilmsByTitle(String title);
	public List<Film> getFilmsByYear(int releaseYear);
	public List<Film> findByRentalDurationGreaterThan(int rentalDuration);
	public List<Film> getFilmsByRentalRateGreaterThan(long rentalRate);
	public List<Film> getFilmsByLengthGreaterThan(long length);
	public List<Film> getFilmsByRentalDurationLessThan(int rentalDuration);
	public List<Film> getFilmsByRentalRateLessThan(long rentalRate);
	public List<Film> getFilmsByLengthLessThan(long length);
	public List<Film> getFilmsByReleaseYearBetween(int from, int to);
	public List<Film> getFilmsByRatingLowerThan(Rating rating);
	public List<Film> getFilmsByRatingGreaterThan(Rating rating);
	public List<Film> getFilmsByLanguage(LanguageEnum language);
	public List<Map<String, Object>> getFilmCountByYear();
	public List<Actor> getActorsForFilm(Long filmId);
	public List<Film> getFilmsByCategory(String categoryName);
//	public Film assignActorToFilm(Long filmId, Long actorId);
	public Film updateFilmTitle(Long filmId, String newTitle);
	public Film updateReleaseYear(Long filmId, int releaseYear);
	public Film updateRentalDuration(Long filmId, int rentalDuration);
	public Film updateRentalRate(Long filmId, double rentalRate);
	public Film updateRating(Long filmId, Rating rating);
	public Film updateLanguage(Long filmId, Long languageId);
	public Film updateCategory(Long filmId, Long categoryId);
	public List<Film> fetchAll();
	public Film getById(long filmId) throws InvalidException;
	public Film updateFilm(long filmId, Film film);
	public void deleteFilmById(long filmId);
}
