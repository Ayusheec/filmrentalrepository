package com.filmrentalstore.dto;
 
import java.time.LocalDateTime;
import java.util.List;
 
public class ActorDTO {
 
    private long actorId;
    private String firstName;
    private String lastName;
    private LocalDateTime lastUpdate;
    private List<Long> filmIds; // Representing Films by their IDs
 
    public long getActorId() {
        return actorId;
    }
 
    public void setActorId(long actorId) {
        this.actorId = actorId;
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
 
    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }
 
    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
 
    public List<Long> getFilmIds() {
        return filmIds;
    }
 
    public void setFilmIds(List<Long> filmIds) {
        this.filmIds = filmIds;
    }
 
    @Override
    public String toString() {
        return "ActorDTO{" +
                "actorId=" + actorId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", lastUpdate=" + lastUpdate +
                ", filmIds=" + filmIds +
                '}';
    }
}