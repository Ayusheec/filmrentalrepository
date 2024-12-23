package com.filmrentalstore.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.filmrentalstore.exception.InvalidException;
import com.filmrentalstore.model.Address;
import com.filmrentalstore.model.Customer;
import com.filmrentalstore.model.Store;
import com.filmrentalstore.repository.AddressRepo;
import com.filmrentalstore.repository.CustomerRepo;
import com.filmrentalstore.repository.StoreRepo;
import com.filmrentalstore.service.CustomerService;

@Service
public class CustomerImpl implements CustomerService {
	
	@Autowired
	private CustomerRepo repos;//call to the repository (repos) to find
	
	@Autowired
	private AddressRepo addressRepos;
	
	@Autowired
	private StoreRepo storeRepos;
	
	public CustomerImpl(CustomerRepo repos, AddressRepo addressRepos) {
        this.repos = repos;
        this.addressRepos = addressRepos;
    }
	
	//saves a new Customer object to the database
	@Override
	public Customer addCustomer(Customer customer) {
		Customer custobj=repos.save(customer);
		return custobj;
	}
	
	@Override
	public List<Customer> getCustomerByFirstName(String firstName) {
		return repos.getCustomerByFirstName(firstName);
	}

	@Override
	public List<Customer> getCustomerByLastName(String lastName) {
		return repos.getCustomerByLastName(lastName);
	}

	@Override
	public List<Customer> getCustomerByEmail(String email) {
		return repos.gerCustomerByEmail(email);
	}

	@Override
	public Customer assignAddresstoCustomer(long customer_id, long address_id) {
		Optional<Customer> customerOpt = repos.findById(customer_id);
		if(!customerOpt.isPresent()) {
			throw new InvalidException("Customer not found");
		}
		Customer customer=customerOpt.get();
		Optional<Address> addressOpt=addressRepos.findById(address_id);
		if(!addressOpt.isPresent()) {
			throw new InvalidException("Address Not Found");
		}
		Address address = addressOpt.get();
		customer.setAddress(address);
		return repos.save(customer);
	}

	@Override
	public List<Customer> findCustomerByCity(String city) {
		return repos.findCustomerByCity(city);
	}

	@Override
	public List<Customer> findCustomerByCountry(String country) {
		return repos.findByAddress_City_Country_Country(country);
	}
	
	@Override
	public List<Customer> getActiveCustomers() {
		return repos.findByActive(1);
	}
	
	@Override
	public List<Customer> getInactiveCustomers() {
		return repos.findByActive(0);
	}

	@Override
	public List<Customer> findCustomersByPhone(String phone) {
		 return repos.findByAddress_Phone(phone);
	}
	
	@Override
	public Customer updateFirstName(long id, String firstName) {
		//call the repos to find a Customer by their unique id
		Customer customer= repos.findById(id).orElse(null);
		if(customer==null) {
			return null;
		}
		customer.setFirst_name(firstName);
		// Saves the updated customer object on database and return
		return repos.save(customer);
	}

	@Override
	public Customer updateLastName(long id, String lastName) {
		//call the repos to find a Customer by their unique id
		Customer customer=repos.findById(id).orElse(null);
		if(customer==null) {
			return null;
		}
		customer.setLast_name(lastName);
		// Saves the updated customer object on database and return
		return repos.save(customer);
	}

	@Override
	public Customer updatemail(long id, String email) {
		//call the repos to find a Customer by their unique id
		Customer customer=repos.findById(id).orElse(null);
		if(customer==null) {
			return null;
		}
		customer.setEmail(email);
		// Saves the updated customer object on database and return
		return repos.save(customer);
	}

	@Override
	public Customer assignStoreToCustomer(Long customerId, Long storeId) {
		Customer customer = repos.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        Store store = storeRepos.findById(storeId)
                .orElseThrow(() -> new RuntimeException("Store not found"));
        customer.setStore(store);
        return repos.save(customer);
	}

	@Override
	public Customer updateCustomerPhone(long customerId, String phone) {
		Optional<Customer> customerOptional = repos.findById(customerId);
        if (customerOptional.isEmpty()) {
            throw new RuntimeException("Customer not found");
        }
        Customer customer = customerOptional.get();
        Address address = customer.getAddress();
        if (address == null) {
            throw new RuntimeException("Address not found for customer");
        }
        address.setPhone(phone);
        address.setLast_update(LocalDateTime.now());
        return repos.save(customer);
	}

	@Override
	public List<Customer> fetchAll() {
		List<Customer> list =repos.findAll();
		return list;
	}
 
	@Override
	public Customer getById(long customer_id) {
		Optional<Customer> opt=repos.findById(customer_id);
		if(opt.isPresent()){
			return opt.get();
		}
		throw new InvalidException("Invalid Customer id error...");
	}
	
	@Override
	public void deleteById(Long id) {
		// Check if customer exists before attempting to delete
        if (!repos.existsById(id)) {
            throw new RuntimeException("Customer with ID " + id + " does not exist.");
        }
        repos.deleteById(id);  // Delete the customer by ID
	}
 
	@Override
	public Customer updateCustomer(Long customerId, Customer updatedCustomer) throws InvalidException {
		Customer existingCustomer = repos.findById(customerId).orElseThrow(() -> new InvalidException("Customer not found with ID: " + customerId));
        // Update fields
        existingCustomer.setFirst_name(updatedCustomer.getFirst_name());
        existingCustomer.setLast_name(updatedCustomer.getLast_name());
        existingCustomer.setEmail(updatedCustomer.getEmail());
        existingCustomer.setAddress(updatedCustomer.getAddress());
        existingCustomer.setStore(updatedCustomer.getStore());  // Assuming store is part of the Customer object
        existingCustomer.setActive(updatedCustomer.getActive());
        return repos.save(existingCustomer);
	}
}
