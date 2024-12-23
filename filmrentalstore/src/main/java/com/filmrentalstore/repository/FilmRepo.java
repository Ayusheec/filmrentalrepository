package com.filmrentalstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.filmrentalstore.model.Category;
import com.filmrentalstore.model.Film;
import com.filmrentalstore.model.LanguageEnum;
import com.filmrentalstore.model.Rating;

@Repository
public interface FilmRepo extends JpaRepository<Film,Long>{

	List<Film> findByTitle(String title);

	List<Film> findByReleaseYear(int releaseYear);

	List<Film> findByRentalDurationGreaterThan(int rentalDuration);

	List<Film> findByRentalRateGreaterThan(long rentalRate);

	List<Film> findByLengthGreaterThan(long length);

	List<Film> findByRentalDurationLessThan(int rentalDuration);

	List<Film> findByRentalRateLessThan(long rentalRate);

	List<Film> findByLengthLessThan(long length);

	List<Film> findByReleaseYearBetween(int from, int to);

	List<Film> findByRatingLessThan(Rating rating);

	List<Film> findByRatingGreaterThan(Rating rating);

	List<Film> findByLanguage_Name(LanguageEnum language);
	
	@Query("SELECT f.releaseYear, COUNT(f) FROM Film f GROUP BY f.releaseYear ORDER BY f.releaseYear DESC")
    List<Object[]> countFilmsByYear();

	List<Film> findByCategories(Category category);
	
}
