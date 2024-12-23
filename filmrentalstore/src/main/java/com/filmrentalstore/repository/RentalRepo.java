package com.filmrentalstore.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.filmrentalstore.model.Film;
import com.filmrentalstore.model.Rental;

 
@Repository
public interface RentalRepo extends JpaRepository<Rental,Long>{
	
	// query to fetch films based on the customer ID  
    @Query("SELECT r FROM Rental r JOIN r.inventory i JOIN i.film f WHERE r.customer.id = :customerId")
    List<Rental> findRentalsByCustomerId(@Param("customerId") long customerId);
    
    @Query("SELECT i.film FROM Rental r JOIN r.inventory i GROUP BY i.film ORDER BY COUNT(r) DESC")
    List<Film> findTopTenRentedFilms(Pageable pageable);
    
    @Query("SELECT i.film FROM Rental r JOIN r.inventory i WHERE r.inventory.store.id = :storeId GROUP BY i.film ORDER BY COUNT(r) DESC")
    List<Film> findTopTenRentedFilmsByStore(@Param("storeId") long storeId, Pageable pageable);
 
    @Query("SELECT r FROM Rental r JOIN FETCH r.inventory i JOIN FETCH i.film f WHERE r.customer.id = :customerId")
    List<Rental> findRentalsByCustomerId(@Param("customerId") Long customerId);
	
}