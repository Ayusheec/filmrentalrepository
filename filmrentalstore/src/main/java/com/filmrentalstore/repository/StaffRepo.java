package com.filmrentalstore.repository;
 
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
 
import com.filmrentalstore.model.Staff;
 
@Repository
public interface StaffRepo extends JpaRepository<Staff,Integer>{
	
	@Query("select c from Staff c where c.first_name=?1")
	List<Staff> findByfirstName(String firstName);
	
	@Query("select c from Staff c where c.last_name=?1")
	List<Staff> findBylastName(String lastName);
 
	@Query("select c from Staff c where c.email=?1")
	Staff getStaffByEmail(String email);
 
	@Query("SELECT s FROM Staff s WHERE s.address.city.city = ?1")
     List<Staff> findStaffByCity(String city);
	
	List<Staff> findByAddress_City_Country_Country(String country);
	
	 @Query("SELECT s FROM Staff s WHERE s.address.phone = :phone")
	 List<Staff> findByPhoneNumber(String phone);
	
	 List<Staff> findByStoreStoreId(long storeId);
}