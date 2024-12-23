package com.filmrentalstore.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.filmrentalstore.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Long>{
	@Query("select c from Customer c where c.first_name=?1")
	List<Customer> getCustomerByFirstName(String firstName);
	
	@Query("select c from Customer c where c.last_name=?1")
	List<Customer> getCustomerByLastName(String lasttName);
	
	@Query("select c from Customer c where c.email=?1")
	List<Customer> gerCustomerByEmail(String email);
	
	@Query("select c from Customer c where c.address.city.city= ?1")
	List<Customer> findCustomerByCity(String city);
	
	List<Customer> findByAddress_City_Country_Country(String country);
	
	List<Customer> findByActive(long active);
	
	List<Customer> findByAddress_Phone(String phone);

	List<Customer> findByStoreStoreId(long storeId);
}
