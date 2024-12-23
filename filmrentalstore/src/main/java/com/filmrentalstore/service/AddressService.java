package com.filmrentalstore.service;

import java.util.List;
import java.util.Optional;

import com.filmrentalstore.model.Address;

public interface AddressService {
	public Optional<Address> getAddressById(long addressId);
	public Address addAddress(Address address);
	public List<Address>fetchAll();
}
