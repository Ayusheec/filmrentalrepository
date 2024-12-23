package com.filmrentalstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filmrentalstore.exception.InvalidException;
import com.filmrentalstore.model.Customer;
import com.filmrentalstore.model.Staff;
import com.filmrentalstore.model.Store;
import com.filmrentalstore.service.StoreService;

@RestController
@RequestMapping("/api/store")
@CrossOrigin(origins = "http://localhost:5173")
public class StoreController {
	@Autowired
	  private StoreService storeService;
	  
	  @PostMapping("/post")
	  public Store createStore(@RequestBody Store store) {
	      Store addedStore = storeService.addStore(store);
	      return addedStore;
	  }
	  
	  @PutMapping("/{storeId}/address/{addressId}")
		public ResponseEntity<Store> assignAddresstoStore(@PathVariable("storeId")long store_id,
				@PathVariable("addressId") long addressId) throws InvalidException{
		   Store updateStore= storeService.assignAddresstoStore(store_id, addressId);
			return ResponseEntity.ok(updateStore);
		}
    
	  @GetMapping("/city/{city}")
	   public List<Store> findStoreByCity(@PathVariable("city") String city)
	   {
		    return storeService.findStoreByCity(city);
	   }
	  
	  @GetMapping("/country/{country}")
	    public List<Store> findStoreByCountry(@PathVariable("country") String country) {
	        return storeService.findStoreByCountry(country);
	    }
	  
	   @GetMapping("/search/phone/{phone}")
	    public List<Store> searchByPhoneno(@PathVariable("phone") String phone) {
	        return storeService.searchByPhoneno(phone);
	    }
	   
	   @PutMapping("/update/{storeId}/{phone}")
	    public ResponseEntity<Store> updateStorePhoneNumber(@PathVariable("storeId") long storeId,
	                                                         @PathVariable("phone") String phone) throws InvalidException {
	        Store updatedStore = storeService.updateStorePhoneNumber(storeId, phone);
	        return ResponseEntity.ok(updatedStore);
	    }
	   
	    @PutMapping("/{storeId}/manager/{manager_staff_id}")
	    public ResponseEntity<Store> assignManagerToStore(@PathVariable("storeId") long storeId,
	                                                      @PathVariable("manager_staff_id") int managerStaffId) throws InvalidException {
	        Store updatedStore = storeService.assignManagerToStore(storeId, managerStaffId);
	        return ResponseEntity.ok(updatedStore);
	    }
	   
	    @GetMapping("/staff/{storeId}")
	    public List<Staff> getAllStaffOfStore(@PathVariable long storeId) {
	        return storeService.getAllStaffOfStore(storeId);
	    }
	   
	    @GetMapping("customer/{storeId}")
	    public List<Customer>getAllCustomerOfStore(@PathVariable long storeId)
	    {
	    	return storeService.getAllCustomerOfStore(storeId);
	    }
	    
	    @GetMapping("/api/store/manager/{storeId}")
	    public Staff getManagerOfStore(@PathVariable long storeId) {
	        return storeService.getManagerByStoreId(storeId);
	    }
	    
	    @GetMapping("/fetch-store")
	    public ResponseEntity<List<Store>> viewAll() {
	        List<Store> storeList = storeService.fetchAll();
	        return ResponseEntity.ok(storeList);
	    }
}
