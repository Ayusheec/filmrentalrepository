package com.filmrentalstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.filmrentalstore.model.Staff;
import com.filmrentalstore.model.Store;

@Repository
public interface StoreRepo extends JpaRepository<Store,Long>{
	
	@Query("SELECT s FROM Store s WHERE s.address.city.city = ?1")
    List<Store> findStoreByCity(String city);
	
	List<Store> findByAddress_City_Country_Country(String country);
	
	 @Query("SELECT s FROM Store s WHERE s.address.phone = :phone")
	 List<Store> findByPhoneNumber(String phone);
	 
	 Store findByStoreId(long storeId);
	 
	 @Query("SELECT s.Manager_staff_id FROM Store s WHERE s.storeId = :storeId")
	 Staff findManagerByStoreId(long storeId);
}
