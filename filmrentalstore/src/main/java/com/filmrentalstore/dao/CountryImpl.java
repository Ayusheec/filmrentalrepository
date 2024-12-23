package com.filmrentalstore.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.filmrentalstore.model.Country;
import com.filmrentalstore.repository.CountryRepo;
import com.filmrentalstore.service.CountryService;
 
@Service
public class CountryImpl implements CountryService{
	
	@Autowired
	private CountryRepo countryRepo;
	
	public Country addCountry(Country country)
	{
		return countryRepo.save(country);
	}

	@Override
	public List<Country> fetchAll() {
		List<Country> list=countryRepo.findAll();
		return list;
	}

 
}