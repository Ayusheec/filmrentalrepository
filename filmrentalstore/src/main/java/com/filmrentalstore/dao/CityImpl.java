package com.filmrentalstore.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filmrentalstore.model.City;
import com.filmrentalstore.repository.CityRepo;
import com.filmrentalstore.service.CityService;

@Service
public class CityImpl implements CityService{
	
	@Autowired
	private CityRepo cityRepo;
	
	@Override
    public City addCity(City city) {
        if (city == null) {
            throw new IllegalArgumentException("City cannot be null");
        }
        return cityRepo.save(city);
    }

	@Override
	public List<City> fetchAll() {
		List<City> list=cityRepo.findAll();
		return list;
	}
}
