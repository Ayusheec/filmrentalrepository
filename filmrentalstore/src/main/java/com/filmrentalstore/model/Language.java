package com.filmrentalstore.model;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
 
@Entity
@Table(name = "language")
public class Language {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="language_id")
    private Long languageId;

	@Enumerated(EnumType.STRING)
    private LanguageEnum name;
	
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime last_update;

    @OneToMany(mappedBy = "language")
    private List<Film> films=new ArrayList<>();

	public LanguageEnum getName() {
		return name;
	}

	public void setName(LanguageEnum name) {
		this.name = name;
	}

	public Long getLanguage_id() {
		return languageId;
	}

	public void setLanguage_id(Long language_id) {
		this.languageId = language_id;
	}

	public LocalDateTime getLast_update() {
		return last_update;
	}

	public void setLast_update(LocalDateTime last_update) {
		this.last_update = last_update;
	}

	public List<Film> getFilms() {
		return films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}

	@Override
	public String toString() {
		return "Language [language_id=" + languageId + ", name=" + name + ", last_update=" + last_update + ", films="
				+ films + ", getName()=" + getName() + ", getLanguage_id()=" + getLanguage_id() + ", getLast_update()="
				+ getLast_update() + ", getFilms()=" + getFilms() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}	
}