package com.filmrentalstore.model;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
 
@Embeddable
public class FilmCategoryId implements Serializable {
    
	private long film_id;
    private long category_id;
}