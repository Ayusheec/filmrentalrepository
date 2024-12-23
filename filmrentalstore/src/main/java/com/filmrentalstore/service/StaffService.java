package com.filmrentalstore.service;

import java.util.List;

import com.filmrentalstore.exception.InvalidException;
import com.filmrentalstore.model.Staff;

public interface StaffService {
	public Staff addStaff(Staff staff);
	public List<Staff> searchByfirstName(String firstname) throws InvalidException;
	public List<Staff> searchByLastName(String lastName) throws InvalidException;
    public Staff searchByEmail(String email) throws InvalidException;
	public List<Staff> findStaffByCity(String city);
	public Staff updateFirstName(int id,String firstname);
	public Staff updateLastName(int id,String lastname);
	public Staff updateemail(int id,String lastname);
	public List<Staff> findStaffByCountry(String country);
	public Staff assignAddresstoStaff(int staff_id, long address_id) throws InvalidException;
	public List<Staff> searchByPhoneno(String phone);
	public Staff assignStoretoStaff(int staff_id,long store_id) throws InvalidException;
	public Staff updatePhoneNumberByAddressId(long addressId, String phone) throws InvalidException;
	public List<Staff>fetchAll();
}
