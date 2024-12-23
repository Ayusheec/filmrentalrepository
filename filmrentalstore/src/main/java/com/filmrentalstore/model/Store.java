package com.filmrentalstore.model;
import java.time.LocalDateTime;
import java.util.*;
 
import com.fasterxml.jackson.annotation.JsonIgnore;
 
import jakarta.persistence.*;
 
@Entity
@Table(name = "store")
public class Store {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "store_id") 
    private long storeId;
 
    @ManyToOne
    @JoinColumn(name = "address_id")
    @JsonIgnore
    private Address address;
    
    @ManyToOne
    @JoinColumn(name="staff_id")
    @JsonIgnore
    private Staff Manager_staff_id;
 
    private LocalDateTime last_update;
 
    @OneToMany(mappedBy = "store")
    @JsonIgnore
    private List<Staff> staff;
 
    @OneToMany(mappedBy = "store")
    @JsonIgnore
    private List<Customer> customers;
 
    @OneToMany(mappedBy = "store")
    @JsonIgnore
    private List<Inventory> inventories=new ArrayList<>();
 
	public long getStore_id() {
		return storeId;
	}
 
	public void setStore_id(long store_id) {
		this.storeId = store_id;
	}
 
	public Address getAddress() {
		return address;
	}
 
	public void setAddress(Address address) {
		this.address = address;
	}
 
	public LocalDateTime getLast_update() {
		return last_update;
	}
 
	public void setLast_update(LocalDateTime last_update) {
		this.last_update = last_update;
	}
 
	public List<Staff> getStaff() {
		return staff;
	}
 
	public void setStaff(List<Staff> staff) {
		this.staff = staff;
	}
 
	public List<Customer> getCustomers() {
		return customers;
	}
 
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
 
	public List<Inventory> getInventories() {
		return inventories;
	}
 
	public void setInventories(List<Inventory> inventories) {
		this.inventories = inventories;
	}

 
	public Staff getManager_staff_id() {
		return Manager_staff_id;
	}
 
	public void setManager_staff_id(Staff manager_staff_id) {
		Manager_staff_id = manager_staff_id;
	}

 
	@Override
	public String toString() {
		return "Store [store_id=" + storeId + ", address=" + address + ", Manager_staff_id=" + Manager_staff_id
				+ ", last_update=" + last_update + ", staff=" + staff + ", customers=" + customers + ", inventories="
				+ inventories + ", getStore_id()=" + getStore_id() + ", getAddress()=" + getAddress()
				+ ", getLast_update()=" + getLast_update() + ", getStaff()=" + getStaff() + ", getCustomers()="
				+ getCustomers() + ", getInventories()=" + getInventories() + ", getManager_staff_id()="
				+ getManager_staff_id() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	} 
}