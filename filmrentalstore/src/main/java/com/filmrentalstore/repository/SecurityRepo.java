package com.filmrentalstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.filmrentalstore.model.Security;

@Repository
public interface SecurityRepo extends JpaRepository<Security,Integer> {

	Security findByUsername(String username);

}
