package com.filmrentalstore.model;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import jakarta.persistence.*;

@Entity
@Table(name = "category")
public class Category {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id")
    private long categoryId;

    private String name;
    
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

    @ManyToMany
    @JoinTable(name = "film_category",joinColumns = @JoinColumn(name = "category_id"),inverseJoinColumns = @JoinColumn(name = "film_id"))
    private List<Film> films=new ArrayList<>();

	public long getCategory_id() {
		return categoryId;
	}

	public void setCategory_id(long category_id) {
		this.categoryId = category_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getLast_update() {
		return lastUpdate;
	}

	public void setLast_update(LocalDateTime last_update) {
		this.lastUpdate = last_update;
	}

	public List<Film> getFilms() {
		return films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}
    
    

}