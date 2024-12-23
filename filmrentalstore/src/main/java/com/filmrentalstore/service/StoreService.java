package com.filmrentalstore.service;

import java.util.List;

import com.filmrentalstore.exception.InvalidException;
import com.filmrentalstore.model.Customer;
import com.filmrentalstore.model.Staff;
import com.filmrentalstore.model.Store;

public interface StoreService {
	public Store addStore(Store store);
	public Store assignAddresstoStore(long store_id, long address_id) throws InvalidException;
	public List<Store> findStoreByCity(String city);
	public List<Store> findStoreByCountry(String country);
	public List<Store> searchByPhoneno(String phone);
	public Store updateStorePhoneNumber(long storeId, String phone) throws InvalidException;
	public Store assignManagerToStore(long storeId, int managerStaffId) throws InvalidException;
	public List<Staff> getAllStaffOfStore(long storeId);
	public List<Customer>getAllCustomerOfStore(long storeId);
	public Staff getManagerByStoreId(long storeId);
	public List<Store> fetchAll();
}
