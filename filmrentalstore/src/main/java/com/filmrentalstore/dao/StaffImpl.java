package com.filmrentalstore.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.filmrentalstore.exception.InvalidException;
import com.filmrentalstore.model.Address;
import com.filmrentalstore.model.Staff;
import com.filmrentalstore.model.Store;
import com.filmrentalstore.repository.AddressRepo;
import com.filmrentalstore.repository.StaffRepo;
import com.filmrentalstore.repository.StoreRepo;
import com.filmrentalstore.service.StaffService;

@Service
public class StaffImpl implements StaffService {
	
	@Autowired
	private StaffRepo repos;
	private AddressRepo addressRepos;
	private StoreRepo storerepos;
	
	public StaffImpl(StaffRepo repos, AddressRepo addressRepos,StoreRepo st) {
	    this.repos = repos;
	    this.addressRepos = addressRepos;
	    this.storerepos=st;
	}
 
	@Override
	public Staff addStaff(Staff staff)  {
	    return repos.save(staff);
	}
	
	@Override
	public List<Staff> searchByfirstName(String firstName) throws InvalidException  {
		 List<Staff> name=repos.findByfirstName(firstName);
		 if (name.isEmpty()) {
	            throw new InvalidException("Staff with first name " + firstName + " not found.");
	        }
		 return name;
	}
	
	@Override
	public List<Staff> searchByLastName(String lastName) throws InvalidException  {
		 List<Staff> name=repos.findBylastName(lastName);
		 if (name.isEmpty()) {
	            throw new InvalidException("Staff with last name " + lastName + " not found.");
	        }
		 return name;
	}
 
	@Override
	public Staff searchByEmail(String email)  throws InvalidException {
		Staff check=repos.getStaffByEmail(email);
		if(check==null)
		{
			throw new InvalidException("Staff with email " + email + " not found.");
		}
		return check;
	}
	
	@Override
	public List<Staff> searchByPhoneno(String phone) {
		return repos.findByPhoneNumber(phone);
	}

	@Override
	public List<Staff> findStaffByCity(String city){
		return repos.findStaffByCity(city);
	}
	public List<Staff> findStaffByCountry(String country) {
        return repos.findByAddress_City_Country_Country(country);
    }

	@Override
	public Staff assignAddresstoStaff(int staff_id, long address_id) throws InvalidException{
	    Optional<Staff> staffOpt = repos.findById(staff_id);
	    if (!staffOpt.isPresent()) {
	        throw new InvalidException("Staff not found with ID:");
	    }
	    Staff staff = staffOpt.get();
 
	    Optional<Address> addressOpt =addressRepos.findById(address_id);
	    if (!addressOpt.isPresent()) {
	        throw new InvalidException("Address not found with ID: " + address_id);
	    }
	    Address address = addressOpt.get();
	    staff.setAddress(address);
	    return repos.save(staff); 
	}

	@Override
	public Staff assignStoretoStaff(int staff_id, long store_id) throws InvalidException {
		 Optional<Staff> staffOpt = repos.findById(staff_id);
		    if (!staffOpt.isPresent()) {
		        throw new InvalidException("Staff not found with ID: " + staff_id);
		    }
		    Staff staff = staffOpt.get();
 
		    Optional<Store> storeOpt = storerepos.findById(store_id);
		    if (!storeOpt.isPresent()) {
		        throw new InvalidException("Store not found with ID: " + store_id);
		    }
		    Store store = storeOpt.get();
		    staff.setStore(store);
		    return repos.save(staff);
	}
	
	@Override
	public Staff updateFirstName(int id,String firstname) {
		Staff staff= repos.findById(id).orElse(null);
		if(staff==null) {
			return null;
		}
		staff.setFirst_name(firstname);
		return repos.save(staff);
	}
	
	@Override
	public Staff updateLastName(int id,String lastname) {
		Staff staff= repos.findById(id).orElse(null);
		if(staff==null) {
			return null;
		}
		staff.setLast_name(lastname);
		return repos.save(staff);
	}
	
	@Override
	public Staff updateemail(int id,String email) {
		Staff staff= repos.findById(id).orElse(null);
		if(staff==null) {
			return null;
		}
		staff.setEmail(email);
		return repos.save(staff);
	}
	
	@Override
    public Staff updatePhoneNumberByAddressId(long addressId, String phone) throws InvalidException {
        Optional<Address> addressOpt =  addressRepos.findById(addressId);
        if (!addressOpt.isPresent()) {
            throw new InvalidException("Address not found with ID: " + addressId);
        }
        Address address = addressOpt.get();
        if (address.getStaff().isEmpty()) {
            throw new InvalidException("No staff associated with this address ID: " + addressId);
        }
        address.setPhone(phone);
        addressRepos.save(address);
        Staff staff = address.getStaff().get(0);
        return repos.save(staff);
    }
	
	@Override
	public List<Staff> fetchAll() {
		List<Staff> list =repos.findAll();
		return list;
	}
	
}
