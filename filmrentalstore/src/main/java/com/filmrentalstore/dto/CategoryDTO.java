package com.filmrentalstore.dto;
import java.time.LocalDateTime;
import java.util.List;
public class CategoryDTO {
    private long categoryId;
    private String name;
    private LocalDateTime lastUpdate;
    private List<Long> filmIds; // Representing films by their IDs
    public long getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
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
        return "CategoryDTO{" +
                "categoryId=" + categoryId +
                ", name='" + name + '\'' +
                ", lastUpdate=" + lastUpdate +
                ", filmIds=" + filmIds +
                '}';
    }
}