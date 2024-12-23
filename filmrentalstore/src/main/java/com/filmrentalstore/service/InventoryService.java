package com.filmrentalstore.service;

import java.util.List;

import com.filmrentalstore.model.Inventory;

public interface InventoryService {
	public Inventory addInventory(Inventory inventory);
	public List<Object[]> getInventoryCountByFilm();
	public List<Inventory> getInventoryByStoreId(long storeId);
	public List<Object[]> getInventoryCountByFilmId(long filmId);
//	public List<Object[]> getInventoryCountByFilmAndStore(long filmId, long storeId);
	public List<Inventory> fetchAll();
}
