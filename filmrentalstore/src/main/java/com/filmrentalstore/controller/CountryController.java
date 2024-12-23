package com.filmrentalstore.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import com.filmrentalstore.model.Country;
import com.filmrentalstore.service.CountryService;
 
@RestController
@RequestMapping("/api/country")
@CrossOrigin(origins = "http://localhost:5173")
public class CountryController {
	
       @Autowired
       private CountryService countryService;
       
       @PostMapping("/post")
       public Country createCountry(@RequestBody Country country)
       {
    	   return countryService.addCountry(country);
       }
}