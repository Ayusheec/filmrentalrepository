package com.filmrentalstore.model;
import java.time.LocalDateTime;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

//JPA annotations map the class to a database table
import jakarta.persistence.*;

// Class Declaration
@Entity
@Table(name = "customer")
public class Customer {
	
	//Variables
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long customer_id;

    @ManyToOne
    @JoinColumn(name = "store_id")
    @JsonIgnore
    private Store store;

    private String first_name;

    private String last_name;

    private String email;
    
    @ManyToOne
    @JoinColumn(name = "address_id")
    @JsonIgnore
    private Address address;
    
    @OneToMany(mappedBy = "customer")
    @JsonManagedReference
    @JsonIgnore
    private List<Payment> payments=new ArrayList<>();
    
    @OneToMany(mappedBy = "customer")
    @JsonManagedReference
    @JsonIgnore
    private List<Rental> rentals=new ArrayList<>();

    private long active;
    
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime create_date;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime last_update;

	public long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(long customer_id) {
		this.customer_id = customer_id;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public List<Rental> getRentals() {
		return rentals;
	}

	public void setRentals(List<Rental> rentals) {
		this.rentals = rentals;
	}

	public long getActive() {
		return active;
	}

	public void setActive(long active) {
		this.active = active;
	}

	public LocalDateTime getCreate_date() {
		return create_date;
	}

	public void setCreate_date(LocalDateTime create_date) {
		this.create_date = create_date;
	}

	public LocalDateTime getLast_update() {
		return last_update;
	}

	public void setLast_update(LocalDateTime last_update) {
		this.last_update = last_update;
	}

	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", store=" + store + ", first_name=" + first_name
				+ ", last_name=" + last_name + ", email=" + email + ", address=" + address + ", payments=" + payments
				+ ", rentals=" + rentals + ", active=" + active + ", create_date=" + create_date + ", last_update="
				+ last_update + ", getCustomer_id()=" + getCustomer_id() + ", getStore()=" + getStore()
				+ ", getFirst_name()=" + getFirst_name() + ", getLast_name()=" + getLast_name() + ", getEmail()="
				+ getEmail() + ", getAddress()=" + getAddress() + ", getPayments()=" + getPayments() + ", getRentals()="
				+ getRentals() + ", getActive()=" + getActive() + ", getCreate_date()=" + getCreate_date()
				+ ", getLast_update()=" + getLast_update() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
}