package com.filmrentalstore.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filmrentalstore.model.Film;
import com.filmrentalstore.model.Inventory;
import com.filmrentalstore.model.Store;
import com.filmrentalstore.repository.FilmRepo;
import com.filmrentalstore.repository.InventoryRepo;
import com.filmrentalstore.repository.StoreRepo;
import com.filmrentalstore.service.InventoryService;

@Service
public class InventoryImpl implements InventoryService{

	@Autowired
	private InventoryRepo repos;
	
	@Autowired
    private StoreRepo storeRepository;
	
	@Autowired
	private FilmRepo filmRepository;
	
	@Override
	public Inventory addInventory(Inventory inventory) {
		Optional<Store> storeOpt = storeRepository.findById(inventory.getStore().getStore_id());
		if (storeOpt.isEmpty()) {
	        throw new RuntimeException("Store not found for ID: " + inventory.getStore().getStore_id());
	    }
	    inventory.setLast_update(LocalDateTime.now());
	    return repos.save(inventory);
	}

	@Override
	public List<Object[]> getInventoryCountByFilm() {
		return repos.findInventoryCountByFilm();
	}

	@Override
	public List<Inventory> getInventoryByStoreId(long storeId) {
		Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new RuntimeException("Store not found with id: " + storeId));
        return repos.findByStore(store);
	}

	@Override
    public List<Object[]> getInventoryCountByFilmId(long filmId) {
        Film film = filmRepository.findById(filmId)
            .orElseThrow(() -> new RuntimeException("Film not found with id: " + filmId));
        List<Inventory> inventories = repos.findByFilm(film);
        Map<Store, Integer> storeInventoryMap = new HashMap<>();
        for (Inventory inventory : inventories) {
            Store store = inventory.getStore();
            storeInventoryMap.put(store, storeInventoryMap.getOrDefault(store, 0) + 1);
        }
        List<Object[]> result = new ArrayList<>();
        for (Map.Entry<Store, Integer> entry : storeInventoryMap.entrySet()) {
            Store store = entry.getKey();
            int count = entry.getValue();
            result.add(new Object[] {store.getAddress().toString(), count});
        }

        return result;
	}

	@Override
	public List<Inventory> fetchAll() {
		List <Inventory> list = repos.findAll();
		return list;
	}

}
