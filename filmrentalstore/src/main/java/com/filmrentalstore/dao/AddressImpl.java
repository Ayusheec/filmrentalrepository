package com.filmrentalstore.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filmrentalstore.model.Address;
import com.filmrentalstore.repository.AddressRepo;
import com.filmrentalstore.service.AddressService;

@Service
public class AddressImpl implements AddressService{
	@Autowired
	private AddressRepo addressRepo;
	
	public Optional<Address> getAddressById(long address){
		return addressRepo.findById(address);
	}

	@Override
	public Address addAddress(Address address) {
		Address custobj=addressRepo.save(address);
		return custobj;
	}

	@Override
	public List<Address> fetchAll() {
		List<Address> list= addressRepo.findAll();
		return list;
	}
	
}
