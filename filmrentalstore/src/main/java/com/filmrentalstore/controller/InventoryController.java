package com.filmrentalstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filmrentalstore.model.Inventory;
import com.filmrentalstore.service.InventoryService;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
	@Autowired
	private InventoryService service;
	
	@PostMapping("/add")
	 public Inventory createInventory(@RequestBody Inventory inventoryobj)
	  {
		  return service.addInventory(inventoryobj);
	  }
	
	@GetMapping("/films")
    public List<Object[]> getInventoryCountByFilm() {
        return service.getInventoryCountByFilm();
    }
	
    @GetMapping("/store/{id}")
    public List<Inventory> getInventoryByStore(@PathVariable("id") long storeId) {
        return service.getInventoryByStoreId(storeId);
    }
    
    @GetMapping("/film/{id}")
    public List<Object[]> getInventoryCountByFilm(@PathVariable("id") long filmId) {
        return service.getInventoryCountByFilmId(filmId);
    }
    
//    @GetMapping("/film/{filmId}/store/{storeId}")
//    public ResponseEntity<List<Object[]>> getInventoryCountByFilmAndStore(
//            @PathVariable long filmId,
//            @PathVariable long storeId) {
//        List<Object[]> result = service.getInventoryCountByFilmAndStore(filmId, storeId);
//        return ResponseEntity.ok(result);
//    }
}
