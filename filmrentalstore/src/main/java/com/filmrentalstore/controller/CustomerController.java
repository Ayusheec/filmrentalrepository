package com.filmrentalstore.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.filmrentalstore.exception.InvalidException;
import com.filmrentalstore.model.Customer;
import com.filmrentalstore.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
@CrossOrigin(origins = "http://localhost:5173")
public class CustomerController {
	@Autowired
	private CustomerService service;
	
	@PostMapping("/post")
	public Customer createCustomer(@RequestBody Customer customer) {
		return service.addCustomer(customer);
	}
	
	@GetMapping("/firstname/{ln}")
	public List<Customer> getCustomerByFistName(@PathVariable("ln") String first_name){
		return service.getCustomerByFirstName(first_name);
	}
	
	@GetMapping("/lastname/{ln}")
	public List<Customer> getCustomerByLastName(@PathVariable("ln") String last_name){
		return service.getCustomerByLastName(last_name);
	}
	
	@GetMapping("email/{email}")
	public List<Customer> getCustmerByEmail(@PathVariable("email") String email){
		return service.getCustomerByEmail(email);
	}
	
	@PutMapping("/{id}/{addressId}")
	public ResponseEntity<Customer> assignAddressToCustomer(@PathVariable("id")long customer_id,@PathVariable("addressId") long addressId){
		Customer updateCustomer= service.assignAddresstoCustomer(customer_id, addressId);
		return ResponseEntity.ok(updateCustomer);
	}
	
	@GetMapping("/city/{city}")
	public List<Customer> findCustomerByCity(@PathVariable("city") String city){
		return service.findCustomerByCity(city);
	}
	
//	http://localhost:8080/api/customers/country/USA
	@GetMapping("/country/{country}")
    public List<Customer> findCustomerByCountry(@PathVariable("country") String country) {
        return service.findCustomerByCountry(country);
    }
	
	@GetMapping("/active")
	public List<Customer> getActiveCustomer(){
		return service.getActiveCustomers();
	}
	
	@GetMapping("/inactive")
	public List<Customer> getInactiveCustomer(){
		return service.getInactiveCustomers();
	}
	
//	http://localhost:8080/api/customers/phone/123-456-7890
	@GetMapping("/phone/{phone}")
    public ResponseEntity<List<Customer>> getCustomersByPhone(@PathVariable("phone") String phone) {
        List<Customer> customers = service.findCustomersByPhone(phone);
        return ResponseEntity.ok(customers);
    }
	
	@PutMapping("/update/{id}/{fn}")
	public ResponseEntity<Customer>updateFirstName(@PathVariable long id,@PathVariable String fn){
		Customer updatecustomer=service.updateFirstName(id, fn);
		if(updatecustomer==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(updatecustomer);
	}
	
	@PutMapping("/updatel/{id}/{ln}")
	public ResponseEntity<Customer>updateLastName(@PathVariable long id,@PathVariable String ln){
		Customer updatecustomer=service.updateLastName(id, ln);
		if(updatecustomer==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(updatecustomer);
	}
	
	@PutMapping("/updatee/{id}/{email}")
	public ResponseEntity<Customer>updatemail(@PathVariable long id,@PathVariable String email){
		Customer updatecustomer=service.updatemail(id, email);
		if(updatecustomer==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(updatecustomer);
	}
	
//	http://localhost:8080/api/customers/update/19/store?storeId=2
	@PutMapping("/update/{id}/store")
    public ResponseEntity<Customer> assignStoreToCustomer(@PathVariable("id") Long customerId, 
                                                           @RequestParam("storeId") Long storeId) {
        Customer updatedCustomer = service.assignStoreToCustomer(customerId, storeId);
        return ResponseEntity.ok(updatedCustomer);
    }
	
//	http://localhost:8080/api/customers/update/19/phone?phone=1234567890
	@PutMapping("/update/{id}/phone")
    public ResponseEntity<Customer> updateCustomerPhone(@PathVariable("id") long customerId,
                                                        @RequestParam("phone") String phone) {
        Customer updatedCustomer = service.updateCustomerPhone(customerId, phone);
        return ResponseEntity.ok(updatedCustomer);
    }
	
	@CrossOrigin(origins = "http://localhost:5173")
	@GetMapping("/fetchall")
    public ResponseEntity<List<Customer>> viewAll() {
        List<Customer> customers = service.fetchAll();
        return ResponseEntity.ok(customers);
    }
   
    @GetMapping("/find-by-id/{fid}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable long fid) {
        try {
            Customer customer = service.getById(fid);
            return ResponseEntity.ok(customer); // Return 200 OK with customer data
        } catch (InvalidException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND) // Return 404 Not Found
                                 .body(null); // No body as it’s an error case
        }
    }
   
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
        try {
            service.deleteById(id);  // Call the service to delete the customer
            return ResponseEntity.ok("Customer deleted successfully.");
        } catch (RuntimeException e) {
            // Return an error response if the customer was not found
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
   
    @PutMapping("/update/{customerId}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable long customerId,
                                                   @RequestBody Customer updatedCustomer) {
        try {
            // Update the customer details
            Customer updated = service.updateCustomer(customerId, updatedCustomer);
            return new ResponseEntity<>(updated, HttpStatus.OK); // Return the updated customer
        } catch (InvalidException ex) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND); // If customer is not found
        }
    }
}
