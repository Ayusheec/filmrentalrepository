package com.filmrentalstore.model;
import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class FilmActorId implements Serializable {
	private long actorId;
    private long filmId;
    
	public long getActorId() {
		return actorId;
	}
	public void setActorId(long actorId) {
		this.actorId = actorId;
	}
	public long getFilmId() {
		return filmId;
	}
	public void setFilmId(long filmId) {
		this.filmId = filmId;
	}
	@Override
	public int hashCode() {
		return Objects.hash(actorId, filmId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FilmActorId other = (FilmActorId) obj;
		return actorId == other.actorId && filmId == other.filmId;
	}
	
    
} 
