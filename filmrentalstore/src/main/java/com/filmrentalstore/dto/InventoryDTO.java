package com.filmrentalstore.dto;

import java.time.LocalDateTime;

public class InventoryDTO {
	private long inventoryId;
    private Long filmId;
    private Long storeId;
    private LocalDateTime lastUpdate;
 
    public InventoryDTO() {}
 
    public InventoryDTO(long inventoryId, Long filmId, Long storeId, LocalDateTime lastUpdate) {
        this.inventoryId = inventoryId;
        this.filmId = filmId;
        this.storeId = storeId;
        this.lastUpdate = lastUpdate;
    }
 
    public long getInventoryId() {
        return inventoryId;
    }
 
    public void setInventoryId(long inventoryId) {
        this.inventoryId = inventoryId;
    }
 
    public Long getFilmId() {
        return filmId;
    }
 
    public void setFilmId(Long filmId) {
        this.filmId = filmId;
    }
 
    public Long getStoreId() {
        return storeId;
    }
 
    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }
 
    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }
 
    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
