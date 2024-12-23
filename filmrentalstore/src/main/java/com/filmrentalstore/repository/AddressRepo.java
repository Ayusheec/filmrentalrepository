package com.filmrentalstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.filmrentalstore.model.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address,Long>{
}
