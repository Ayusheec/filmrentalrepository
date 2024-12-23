package com.filmrentalstore.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Entity
@Table(name = "rental")
public class Rental {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long rental_id;
 
    private LocalDateTime rental_date;
 
    @ManyToOne
    @JoinColumn(name = "inventory_id")
    private Inventory inventory;
 
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
 
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime return_date;
 
    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Staff staff;
    
    @OneToMany(mappedBy = "rental")
    private List<Payment> payments=new ArrayList<>();
 
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime last_update;

	public long getRental_id() {
		return rental_id;
	}

	public void setRental_id(long rental_id) {
		this.rental_id = rental_id;
	}

	public LocalDateTime getRental_date() {
		return rental_date;
	}

	public void setRental_date(LocalDateTime rental_date) {
		this.rental_date = rental_date;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public LocalDateTime getReturn_date() {
		return return_date;
	}

	public void setReturn_date(LocalDateTime return_date) {
		this.return_date = return_date;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public LocalDateTime getLast_update() {
		return last_update;
	}

	public void setLast_update(LocalDateTime last_update) {
		this.last_update = last_update;
	}
    
    
 
}