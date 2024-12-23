package com.filmrentalstore.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Entity
@Table(name = "film")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long film_id;
    
    private String title;
    
    private String description;

    @Column(name="release_year", nullable=false)
    private int releaseYear;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "language_id")
    @JsonIgnore
    private Language language;
    
    @Column(name="rental_duration")
    private int rentalDuration;
    
    @Column(name="rental_rate")
    private double rentalRate;

    private long length;
    
    private long replacement_cost;

    @Column(columnDefinition = "ENUM('G', 'PG', 'PG_13', 'R', 'NC_17') DEFAULT 'G'")
    @Enumerated(EnumType.STRING)
    private Rating rating = Rating.G;

    @Column(columnDefinition = "SET('Trailers', 'Commentaries', 'Deleted Scenes', 'Behind the Scenes')")
    private String specialFeatures;
    
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime last_update;
    
    @ManyToMany
    @JoinTable(name = "film_actor", joinColumns = @JoinColumn(name = "film_id"), inverseJoinColumns = @JoinColumn(name = "actor_id"))
    @JsonIgnore
    private List<Actor> actors=new ArrayList<>();

    // Many-to-many relationship with Category
    @ManyToMany
    @JoinTable(name = "film_category", joinColumns = @JoinColumn(name = "film_id"),inverseJoinColumns = @JoinColumn(name = "category_id",columnDefinition = "TINYINT UNSIGNED"))
    @JsonIgnore
    private List<Category> categories=new ArrayList<>();

    @OneToMany(mappedBy="film")
    @JsonIgnore
    private List<Inventory> inventories;
    
	public String getSpecialFeatures() {
		return specialFeatures;
	}

	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}

	public List<Inventory> getInventories() {
		return inventories;
	}

	public void setInventories(List<Inventory> inventories) {
		this.inventories = inventories;
	}

	public long getFilm_id() {
		return film_id;
	}

	public void setFilm_id(long film_id) {
		this.film_id = film_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public int getRentalDuration() {
		return rentalDuration;
	}

	public void setRentalDuration(int rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public double getRentalRate() {
		return rentalRate;
	}

	public void setRentalRate(double rentalRate2) {
		this.rentalRate = rentalRate2;
	}

	public long getLength() {
		return length;
	}

	public void setLength(long length) {
		this.length = length;
	}

	public long getReplacement_cost() {
		return replacement_cost;
	}

	public void setReplacement_cost(long replacement_cost) {
		this.replacement_cost = replacement_cost;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public String getSpecial_features() {
		return specialFeatures;
	}

	public void setSpecial_features(String special_features) {
		this.specialFeatures = special_features;
	}

	public LocalDateTime getLast_update() {
		return last_update;
	}

	public void setLast_update(LocalDateTime last_update) {
		this.last_update = last_update;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	@Override
	public String toString() {
		return "Film [film_id=" + film_id + ", title=" + title + ", description=" + description + ", releaseYear="
				+ releaseYear + ", language=" + language + ", rentalDuration=" + rentalDuration + ", rentalRate="
				+ rentalRate + ", length=" + length + ", replacement_cost=" + replacement_cost + ", rating=" + rating
				+ ", specialFeatures=" + specialFeatures + ", last_update=" + last_update + ", actors=" + actors
				+ ", categories=" + categories + ", inventories=" + inventories + ", getSpecialFeatures()="
				+ getSpecialFeatures() + ", getInventories()=" + getInventories() + ", getFilm_id()=" + getFilm_id()
				+ ", getTitle()=" + getTitle() + ", getDescription()=" + getDescription() + ", getReleaseYear()="
				+ getReleaseYear() + ", getLanguage()=" + getLanguage() + ", getRentalDuration()=" + getRentalDuration()
				+ ", getRentalRate()=" + getRentalRate() + ", getLength()=" + getLength() + ", getReplacement_cost()="
				+ getReplacement_cost() + ", getRating()=" + getRating() + ", getSpecial_features()="
				+ getSpecial_features() + ", getLast_update()=" + getLast_update() + ", getActors()=" + getActors()
				+ ", getCategories()=" + getCategories() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
    
    
    
}