package com.filmrentalstore.service;

import java.util.List;

import com.filmrentalstore.model.City;

public interface CityService {
	public City addCity(City city);
	public List<City> fetchAll();
}
