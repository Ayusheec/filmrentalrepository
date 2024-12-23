package com.filmrentalstore.dao;
 
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
 
import com.filmrentalstore.model.Film;
import com.filmrentalstore.model.Rental;
import com.filmrentalstore.repository.RentalRepo;
import com.filmrentalstore.service.RentalService;
 
@Service
public class RentalImpl implements RentalService {
 
    @Autowired
    private RentalRepo repos;

 
    @Override
    public Rental addRental(Rental rental) {
        return repos.save(rental);
    }
 
    @Override
    public List<Film> getFilmsRentedByCustomer(long customerId) {
        List<Rental> rentals = repos.findRentalsByCustomerId(customerId);
 
        List<Film> films = new ArrayList<>();
        for (Rental rental : rentals) {
            films.add(rental.getInventory().getFilm());
        }
        return films;
    }
 
    @Override
    public List<Film> getTopTenRentedFilms() {
        Pageable pageable = PageRequest.of(0, 10); // Get the top 10 results
        return repos.findTopTenRentedFilms(pageable);
    }
 
	@Override
	public List<Film> getTopTenRentedFilmsByStore(long storeId) {
		Pageable pageable = PageRequest.of(0, 10);  // First page, 10 results per page
	    return repos.findTopTenRentedFilmsByStore(storeId, pageable);
	}
 
	
	@Override
	public Rental updateReturnDate(Long rentalId, LocalDateTime returnDate) {
        // Fetch rental by ID
        Rental rental = repos.findById(rentalId)
                .orElseThrow(() -> new RuntimeException("Rental not found with ID: " + rentalId));
 
        // Validate return date
        if (returnDate.isBefore(rental.getRental_date())) {
            throw new RuntimeException("Return date cannot be earlier than rental date.");
        }
 
        // Update fields
        rental.setReturn_date(returnDate);
        rental.setLast_update(LocalDateTime.now());
 
        // Save and return updated rental
        return repos.save(rental);
    }
	public List<Rental> fetchAll() {
		List<Rental> list =repos.findAll();
		return list;
		}
}