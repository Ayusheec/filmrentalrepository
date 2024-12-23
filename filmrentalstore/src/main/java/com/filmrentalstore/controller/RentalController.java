package com.filmrentalstore.controller;
 
import java.time.LocalDateTime;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import com.filmrentalstore.model.Film;
import com.filmrentalstore.model.Rental;
import com.filmrentalstore.service.RentalService;
 
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/rental")
public class RentalController {
	@Autowired
	private RentalService rental;
 
	// Rent a film
		@PostMapping("/add")
		public ResponseEntity<Rental> createRental(@RequestBody Rental rentalobj) {
			Rental result = rental.addRental(rentalobj);
			return ResponseEntity.ok(result);
		}
		// Display all Films rented to a customer	
		@GetMapping("/customer/{id}")
		public ResponseEntity<List<Film>> getFilmsRentedByCustomer(@PathVariable("id") long customerId) {
	        List<Film> result = rental.getFilmsRentedByCustomer(customerId);
	        return ResponseEntity.ok(result);
	    }
		// Display top 10 most rented Films	
		@GetMapping("/toptenfilms")
		public ResponseEntity<List<Film>> getTopTenRentedFilms() {
		    List<Film> result = rental.getTopTenRentedFilms();
		    return ResponseEntity.ok(result);
		}
		// Display top 10 most rented Films of a Store
		@GetMapping("/toptenfilms/store/{id}")
		public ResponseEntity<List<Film>> getTopTenRentedFilmsByStore(@PathVariable("id") long storeId) {
		    List<Film> result = rental.getTopTenRentedFilmsByStore(storeId);
		    return ResponseEntity.ok(result);
		}
 
 
	// Update the return_date of a rental (using POST)
		 @PostMapping("/update/returndate/{id}")
		    public ResponseEntity<Rental> updateReturnDate(
		            @PathVariable("id") Long rentalId,
		            @RequestBody LocalDateTime returnDate) {
		        Rental updatedRental = rental.updateReturnDate(rentalId, returnDate);
		        return ResponseEntity.ok(updatedRental);
		    }
		@GetMapping("/fetchall")
		public ResponseEntity<List<Rental>> viewAll() {
		    List<Rental> customers = rental.fetchAll();
		    return ResponseEntity.ok(customers);
		}

 
}