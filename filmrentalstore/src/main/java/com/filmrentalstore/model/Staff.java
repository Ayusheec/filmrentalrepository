package com.filmrentalstore.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Entity
@Table(name = "staff")
public class Staff {
 
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int staff_id;
 
    private String first_name;
 
    private String last_name;
 
    @ManyToOne
    @JoinColumn(name = "address_id",referencedColumnName = "address_id")
    @JsonIgnore
    private Address address;
 
    private String email;
 
    @ManyToOne
    @JoinColumn(name = "store_id", referencedColumnName = "store_id")
    @JsonIgnore
    private Store store;
 
    private long active;
 
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime last_update;
 
    @OneToMany(mappedBy = "staff")
    @JsonIgnore
    private List<Payment> payment;
 
    public int getStaff_id() {
        return staff_id;
    }
 
    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
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
 
    public Address getAddress() {
        return address;
    }
 
    public void setAddress(Address address) {
        this.address = address;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public Store getStore() {
        return store;
    }
 
    public void setStore(Store store) {
        this.store = store;
    }
 
    public long getActive() {
        return active;
    }
 
    public void setActive(long active) {
        this.active = active;
    }
 
    public LocalDateTime getLast_update() {
        return last_update;
    }
 
    public void setLast_update(LocalDateTime last_update) {
        this.last_update = last_update;
    }
 
    public List<Payment> getPayment() {
        return payment;
    }
 
    public void setPayment(List<Payment> payment) {
        this.payment = payment;
    }
 
	@Override
	public String toString() {
		return "Staff [staff_id=" + staff_id + ", first_name=" + first_name + ", last_name=" + last_name + ", address="
				+ address + ", email=" + email + ", store=" + store + ", active=" + active + ", last_update="
				+ last_update + ", payment=" + payment + ", getStaff_id()=" + getStaff_id() + ", getFirst_name()="
				+ getFirst_name() + ", getLast_name()=" + getLast_name() + ", getAddress()=" + getAddress()
				+ ", getEmail()=" + getEmail() + ", getStore()=" + getStore() + ", getActive()=" + getActive()
				+ ", getLast_update()=" + getLast_update() + ", getPayment()=" + getPayment() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
 	
}