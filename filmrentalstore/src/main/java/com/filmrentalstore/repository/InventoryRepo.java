package com.filmrentalstore.repository;
 
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.filmrentalstore.model.Film;
import com.filmrentalstore.model.Inventory;
import com.filmrentalstore.model.Store;
 
@Repository
public interface InventoryRepo extends JpaRepository<Inventory,Long>{

	@Query("SELECT i.film.title AS title, COUNT(i) AS copies FROM Inventory i GROUP BY i.film.title")
	List<Object[]> findInventoryCountByFilm();

	List<Inventory> findByStore(Store store);

	List<Inventory> findByFilm(Film film);

//	List<Inventory> findByFilmAndStore(Film film, Store store);

}