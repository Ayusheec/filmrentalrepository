package com.filmrentalstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.filmrentalstore.model.Country;

@Repository
public interface CountryRepo extends JpaRepository<Country,Integer>{

}
