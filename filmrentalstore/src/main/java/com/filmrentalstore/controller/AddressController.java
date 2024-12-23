package com.filmrentalstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filmrentalstore.exception.InvalidException;
import com.filmrentalstore.model.Address;
import com.filmrentalstore.service.AddressService;

@RestController
@RequestMapping("api/address")
@CrossOrigin(origins = "http://localhost:5173")
public class AddressController {
	@Autowired
	private AddressService addressService;
	
	@PostMapping("/post")
	public Address getAddress(@RequestBody Address address) {
		return addressService.addAddress(address);
	}
	
	@GetMapping("/{addressId}")
	public Address getAddressById(@PathVariable long addressId){
		return addressService.getAddressById(addressId).
				orElseThrow(()-> new InvalidException("Address not found"));
	}
}
