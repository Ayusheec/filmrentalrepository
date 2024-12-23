package com.filmrentalstore.repository;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.filmrentalstore.model.Language;
 
@Repository
public interface LanguageRepo extends JpaRepository<Language,Long> {
	Language findByName(String name);
}