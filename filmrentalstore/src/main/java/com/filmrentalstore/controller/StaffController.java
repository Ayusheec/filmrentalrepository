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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.filmrentalstore.exception.InvalidException;
import com.filmrentalstore.model.Staff;
import com.filmrentalstore.service.StaffService;

@RestController
@RequestMapping("/api/staff")
@CrossOrigin(origins = "http://localhost:5173")
public class StaffController {
	
	@Autowired
	  private StaffService service;
	
	@CrossOrigin(origins = "http://localhost:5173")
	  @PostMapping("/post")
	  public ResponseEntity<Staff> createStaff(@RequestBody Staff staffobj) {
		  System.out.println(staffobj);
	      Staff createdStaff = service.addStaff(staffobj);
	      return ResponseEntity.ok(createdStaff);
	  }

	   @GetMapping("/first_name/{fn}")
	   public List<Staff> searchByfirstName(@PathVariable("fn") String first_name) throws InvalidException{
			return service.searchByfirstName(first_name);
		}
	   
	   @GetMapping("/last_name/{fn}")
	   public List<Staff> searchByLastName(@PathVariable("fn") String last_name) throws InvalidException{
			return service.searchByLastName(last_name);
		}
	   @GetMapping("/email/{email}")
	   public Staff searchByEmail(@PathVariable("email") String email) throws InvalidException{
			return service.searchByEmail(email);
		}
	   
	   @GetMapping("/city/{city}")
	   public List<Staff> findStaffByCity(@PathVariable("city") String city)
	   {
		    return service.findStaffByCity(city);
	   }
	   
	   @GetMapping("/country/{country}")
	    public List<Staff> findStaffByCountry(@PathVariable("country") String country) {
	        return service.findStaffByCountry(country);
	    }
	   
	   @PutMapping("/{id}/{addressId}")
		public ResponseEntity<Staff> assignAddresstoStaff(@PathVariable("id")int staff_id,
				@PathVariable("addressId") long addressId) throws InvalidException{
		   Staff updateStaff= service.assignAddresstoStaff(staff_id, addressId);
			return ResponseEntity.ok(updateStaff);
		}
	   
	   @GetMapping("/search/phone/{phone}")
	    public List<Staff> searchByPhoneno(@PathVariable("phone") String phone) {
	        return service.searchByPhoneno(phone);
	    }
	   
	   @PutMapping("/update/{fn}/{id}")
		public ResponseEntity<Staff>updateFirstName(@PathVariable String fn,@PathVariable int id){
			Staff updatestaff=service.updateFirstName(id, fn);
			if(updatestaff==null) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok(updatestaff);
		}
	   
	   @PutMapping("/updatel/{ln}/{id}")
		public ResponseEntity<Staff>updateLastName(@PathVariable String ln,@PathVariable int id){
			Staff updatestaff=service.updateLastName(id, ln);
			if(updatestaff==null) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok(updatestaff);
		}
	   
	   @PutMapping("/updatep/{email}/{id}")
		public ResponseEntity<Staff>updateemail(@PathVariable String email,@PathVariable int id){
			Staff updatestaff=service.updateemail(id, email);
			if(updatestaff==null) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok(updatestaff);
		}

	   @PutMapping("/updatestore/{staffId}/{storeId}")
	    public Staff assignStoreToStaff(@PathVariable int staffId, @PathVariable long storeId) throws InvalidException {
	        return service.assignStoretoStaff(staffId, storeId);
	    } 
	   
	   @PutMapping("update/phone/{addressId}")
	    public ResponseEntity<Staff> updatePhoneNumberByAddressId(@PathVariable long addressId, @RequestParam String phone) {
	        try {
	            Staff updatedStaff = service.updatePhoneNumberByAddressId(addressId, phone);
	            return ResponseEntity.ok(updatedStaff);
	        } catch (InvalidException e) {
	            return ResponseEntity.badRequest().body(null);
	        }
	    }
	   
	   @CrossOrigin(origins = "http://localhost:5173")
	   @GetMapping("/fetchall")
		public ResponseEntity<List<Staff>> viewAll() {
		    List<Staff> staffList = service.fetchAll();
		    return ResponseEntity.ok(staffList);
		}

}