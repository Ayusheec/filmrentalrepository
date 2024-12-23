package com.filmrentalstore.service;
 
import java.time.LocalDateTime;
import java.util.List;
 
import com.filmrentalstore.model.Film;
import com.filmrentalstore.model.Rental;
 
public interface RentalService {
	public Rental addRental(Rental rental);	
	public List<Film> getFilmsRentedByCustomer(long customerId);
	public List<Film> getTopTenRentedFilms();
	public List<Film> getTopTenRentedFilmsByStore(long storeId);
	public Rental updateReturnDate(Long rentalId, LocalDateTime returnDate);
	public List<Rental> fetchAll();
}