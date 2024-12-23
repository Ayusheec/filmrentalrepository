package com.filmrentalstore.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filmrentalstore.exception.InvalidException;
import com.filmrentalstore.model.Address;
import com.filmrentalstore.model.Customer;
import com.filmrentalstore.model.Staff;
import com.filmrentalstore.model.Store;
import com.filmrentalstore.repository.AddressRepo;
import com.filmrentalstore.repository.CustomerRepo;
import com.filmrentalstore.repository.StaffRepo;
import com.filmrentalstore.repository.StoreRepo;
import com.filmrentalstore.service.StoreService;

@Service
public class StoreImpl implements StoreService{
	
	@Autowired
	private StoreRepo repos;
	
	@Autowired
	private AddressRepo addressRepos;
	
	@Autowired
	private CustomerRepo CustomerRepo;
	
	@Autowired
	private StaffRepo staffrepo;
	public StoreImpl(StoreRepo repos, AddressRepo addressRepos,CustomerRepo CustomerRepo,StaffRepo staffrepo) {
	    this.repos = repos;
	    this.addressRepos = addressRepos;
	    this.CustomerRepo=CustomerRepo;
	    this.staffrepo=staffrepo;
	}
	
	@Override
	public Store addStore(Store store) {
		return repos.save(store);
	}
 
	@Override
	public  Store assignAddresstoStore(long store_id, long address_id) throws InvalidException {
		Optional<Store> storeOpt = repos.findById(store_id);
	    if (!storeOpt.isPresent()) {
	        throw new InvalidException("Store not found with ID: " + store_id);
	    }
	    Store store = storeOpt.get();
	    Optional<Address> addressOpt = addressRepos.findById(address_id);
	    if (!addressOpt.isPresent()) {
	        throw new InvalidException("Address not found with ID: " + address_id);
	    }
	    Address address = addressOpt.get();
	    store.setAddress(address);
	    return repos.save(store);
	}
 
	@Override
	public List<Store> findStoreByCity(String city) {
		return repos.findStoreByCity(city);
	}
 
	@Override
	public List<Store> findStoreByCountry(String country) {
		 return repos.findByAddress_City_Country_Country(country);
	}
 
	@Override
	public List<Store> searchByPhoneno(String phone) {
		return repos.findByPhoneNumber(phone);
	}
	
	@Override
    public Store updateStorePhoneNumber(long storeId, String phone) throws InvalidException {
        Store store = repos.findById(storeId).orElseThrow(() -> new InvalidException("Store not found with ID: " + storeId));
        store.getAddress().setPhone(phone);  
        return repos.save(store);  
    }
	
	@Override
    public Store assignManagerToStore(long storeId, int managerStaffId) throws InvalidException {
        Store store = repos.findById(storeId).orElseThrow(() -> new InvalidException("Store not found with ID: " + storeId));
        Staff staff = staffrepo.findById(managerStaffId).orElseThrow(() -> new InvalidException("Staff not found with ID: " + managerStaffId));
        store.setManager_staff_id(staff);
        store.setLast_update(LocalDateTime.now()); 
        return repos.save(store);
    }
	
	@Override
    public List<Staff> getAllStaffOfStore(long storeId) {
        return staffrepo.findByStoreStoreId(storeId);
    }
	
	@Override
	public List<Customer>getAllCustomerOfStore(long storeId){
		return CustomerRepo.findByStoreStoreId(storeId);
	}
	
	@Override
    public Staff getManagerByStoreId(long storeId) {
        return repos.findManagerByStoreId(storeId);
    }
 
	public List<Store> fetchAll() {
		List<Store> list =repos.findAll();
		return list;
	}
}
