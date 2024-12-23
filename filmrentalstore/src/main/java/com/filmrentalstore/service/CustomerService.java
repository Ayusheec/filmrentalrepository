package com.filmrentalstore.service;

import java.util.List;

import com.filmrentalstore.exception.InvalidException;
import com.filmrentalstore.model.Customer;

public interface CustomerService {
	public Customer addCustomer(Customer customer);
	public List<Customer> getCustomerByFirstName(String firstName);
	public List<Customer> getCustomerByLastName(String lastName);
	public List<Customer> getCustomerByEmail(String email);
	public Customer assignAddresstoCustomer(long customer_id, long address_id);
	public List<Customer> findCustomerByCity(String city);
	public List<Customer> findCustomerByCountry(String country);
	public List<Customer> getActiveCustomers();
	public List<Customer> getInactiveCustomers();
	public List<Customer> findCustomersByPhone(String phone);
	public Customer updateFirstName(long id,String firstName);
	public Customer updateLastName(long id,String lastName);
	public Customer updatemail(long id,String email);
	public Customer assignStoreToCustomer(Long customerId, Long storeId);
	public Customer updateCustomerPhone(long customerId, String phone);
	public List<Customer>fetchAll();
	public Customer getById(long customer_id);
	public void deleteById(Long id);
	public Customer updateCustomer(Long customerId, Customer updatedCustomer) throws InvalidException;
}
