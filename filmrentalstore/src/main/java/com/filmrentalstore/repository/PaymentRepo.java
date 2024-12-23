package com.filmrentalstore.repository;
 
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.filmrentalstore.model.Film;
import com.filmrentalstore.model.Payment;
import com.filmrentalstore.model.Store;
 
@Repository
public interface PaymentRepo extends JpaRepository<Payment,Long>{
	
	@Query("SELECT p.paymentDate, SUM(p.amount) FROM Payment p GROUP BY p.paymentDate ORDER BY p.paymentDate")
    List<Object[]> calculateRevenueByDate();
    
    @Query("SELECT p.paymentDate, SUM(p.amount) " +
            "FROM Payment p " +
            "JOIN p.rental r " +          
            "JOIN r.inventory i " +       
            "JOIN i.store s " +           
            "WHERE s.storeId = :storeId " +
            "GROUP BY p.paymentDate " +
            "ORDER BY p.paymentDate")
     List<Object[]> calculateRevenueByDate(@Param("storeId") long storeId);
     
     @Query("SELECT f.title, SUM(p.amount) " +
             "FROM Payment p " +
             "JOIN p.rental r " +
             "JOIN r.inventory i " +
             "JOIN i.film f " +
             "GROUP BY f.title")
      List<Object[]> getFilmwiseRevenue();
      
      @Query("SELECT s.address, SUM(p.amount) " +
              "FROM Payment p " +
              "JOIN p.rental r " +
              "JOIN r.inventory i " +
              "JOIN i.store s " +
              "WHERE i.film = :film " +
              "GROUP BY s.address")
      List<Object[]> findCumulativeRevenueByFilm(Film film);
      
      @Query("SELECT f.title, SUM(p.amount) " +
              "FROM Payment p " +
              "JOIN p.rental r " +
              "JOIN r.inventory i " +
              "JOIN i.film f " +
              "JOIN i.store s " +
              "WHERE s = :store " +
              "GROUP BY f.title")
      List<Object[]> findCumulativeRevenueByStore(Store store);
}