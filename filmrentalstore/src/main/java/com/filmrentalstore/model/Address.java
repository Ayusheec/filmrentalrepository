package com.filmrentalstore.model;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class Address {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long address_id;

	    private String address;
	    
	    private String address2;

	    private String district;

	    @ManyToOne
	    @JoinColumn(name = "city_id")
	    @JsonIgnore
	    private City city;

	    private String postal_code;
	    
	    private String phone;

	    private LocalDateTime last_update;

	    @OneToMany(mappedBy = "address")
	    @JsonIgnore
	    private List<Customer> customers=new ArrayList<>();

	    @OneToMany(mappedBy = "address")
	    @JsonIgnore
	    private List<Staff> staff=new ArrayList<>();

	    @OneToMany(mappedBy = "address")
	    @JsonIgnore
	    private List<Store> stores=new ArrayList<>();

		public long getAddress_id() {
			return address_id;
		}

		public void setAddress_id(long address_id) {
			this.address_id = address_id;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getAddress2() {
			return address2;
		}

		public void setAddress2(String address2) {
			this.address2 = address2;
		}

		public String getDistrict() {
			return district;
		}

		public void setDistrict(String district) {
			this.district = district;
		}

		public City getCity() {
			return city;
		}

		public void setCity(City city) {
			this.city = city;
		}

		public String getPostal_code() {
			return postal_code;
		}

		public void setPostal_code(String postal_code) {
			this.postal_code = postal_code;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public LocalDateTime getLast_update() {
			return last_update;
		}

		public void setLast_update(LocalDateTime last_update) {
			this.last_update = last_update;
		}

		public List<Customer> getCustomers() {
			return customers;
		}

		public void setCustomers(List<Customer> customers) {
			this.customers = customers;
		}

		public List<Staff> getStaff() {
			return staff;
		}

		public void setStaff(List<Staff> staff) {
			this.staff = staff;
		}

		public List<Store> getStores() {
			return stores;
		}

		public void setStores(List<Store> stores) {
			this.stores = stores;
		}

		@Override
		public String toString() {
			return "Address [address_id=" + address_id + ", address=" + address + ", address2=" + address2
					+ ", district=" + district + ", city=" + city + ", postal_code=" + postal_code + ", phone=" + phone
					+ ", last_update=" + last_update + ", customers=" + customers + ", staff=" + staff + ", stores="
					+ stores + ", getAddress_id()=" + getAddress_id() + ", getAddress()=" + getAddress()
					+ ", getAddress2()=" + getAddress2() + ", getDistrict()=" + getDistrict() + ", getCity()="
					+ getCity() + ", getPostal_code()=" + getPostal_code() + ", getPhone()=" + getPhone()
					+ ", getLast_update()=" + getLast_update() + ", getCustomers()=" + getCustomers() + ", getStaff()="
					+ getStaff() + ", getStores()=" + getStores() + ", getClass()=" + getClass() + ", hashCode()="
					+ hashCode() + ", toString()=" + super.toString() + "]";
		}
	    

}