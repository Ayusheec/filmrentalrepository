package com.filmrentalstore.model;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "actor")
public class Actor {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long actor_id;

	@Column(name="first_name")
    private String firstName;
    
    @Column(name="last_name")
    private String lastName;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate lastUpdate;
    
    @ManyToMany
    @JsonManagedReference
    @JoinTable(name = "film_actor", joinColumns = @JoinColumn(name = "actor_id"), inverseJoinColumns = @JoinColumn(name = "film_id"))
    private List<Film> films = new ArrayList<>();

	public long getActor_id() {
		return actor_id;
	}

	public void setActor_id(long actor_id) {
		this.actor_id = actor_id;
	}

	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	public List<Film> getFilms() {
		return films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}

	public LocalDate getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(LocalDate lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Override
	public String toString() {
		return "Actor [actor_id=" + actor_id + ", firstName=" + firstName + ", lastName=" + lastName + ", lastUpdate="
				+ lastUpdate + ", films=" + films + ", getActor_id()=" + getActor_id() + ", getFirstName()="
				+ getFirstName() + ", getLastName()=" + getLastName() + ", getFilms()=" + getFilms()
				+ ", getLastUpdate()=" + getLastUpdate() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	
    
}  