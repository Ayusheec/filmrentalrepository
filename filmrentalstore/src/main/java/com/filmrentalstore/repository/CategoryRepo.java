package com.filmrentalstore.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.filmrentalstore.model.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category,Long> {
	Optional<Category> findByName(String name);
}
