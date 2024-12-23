package com.filmrentalstore.model;
import jakarta.persistence.*;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

 
@Entity
@Table(name = "inventory")
public class Inventory {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long inventory_id;
 
    @ManyToOne
    @JoinColumn(name = "film_id")
    @JsonIgnore
    private Film film;
 
    @ManyToOne
    @JoinColumn(name = "store_id")
    @JsonIgnore
    private Store store;
 
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime last_update;

	public long getInventory_id() {
		return inventory_id;
	}

	public void setInventory_id(long inventory_id) {
		this.inventory_id = inventory_id;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public LocalDateTime getLast_update() {
		return last_update;
	}

	public void setLast_update(LocalDateTime last_update) {
		this.last_update = last_update;
	}
    
    
}