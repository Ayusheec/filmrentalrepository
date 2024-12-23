package com.filmrentalstore.service;
import java.util.List;

import com.filmrentalstore.model.Country;
 
public interface CountryService {
	public Country addCountry(Country country);
	public List<Country> fetchAll();
}
 