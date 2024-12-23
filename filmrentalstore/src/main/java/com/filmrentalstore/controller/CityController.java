package com.filmrentalstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filmrentalstore.model.City;
import com.filmrentalstore.service.CityService;

@RestController
@RequestMapping("/api/city")
@CrossOrigin(origins="http://localhost:5173")
public class CityController {
	
	@Autowired
	private CityService cityService;
	
	@PostMapping("/post")
	public City createCity(@RequestBody City city) {
		return cityService.addCity(city);
	}
	
}
