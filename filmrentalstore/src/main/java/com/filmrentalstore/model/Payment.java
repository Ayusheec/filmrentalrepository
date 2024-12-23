package com.filmrentalstore.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;
 
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
 

@Entity
@Table(name = "payment")
public class Payment {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "payment_id")
    private long paymentId;
 
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
 
    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Staff staff;
 
    @ManyToOne
    @JoinColumn(name = "rental_id")
    private Rental rental;
 
    private long amount;
    
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @Column(name = "payment_date")  
    private LocalDateTime paymentDate;
    
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @Column(name = "last_update")
    private LocalDateTime lastUpdate;
 
	public long getPaymentId() {
		return paymentId;
	}
 
	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}
 
	public Customer getCustomer() {
		return customer;
	}
 
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
 
	public Staff getStaff() {
		return staff;
	}
 
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
 
	public Rental getRental() {
		return rental;
	}
 
	public void setRental(Rental rental) {
		this.rental = rental;
	}
 
	public long getAmount() {
		return amount;
	}
 
	public void setAmount(long amount) {
		this.amount = amount;
	}
 
 
	public LocalDateTime getPaymentDate() {
		return paymentDate;
	}
 
	public void setPaymentDate(LocalDateTime paymentDate) {
		this.paymentDate = paymentDate;
	}
 
	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}
 
	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
 
	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", customer=" + customer + ", staff=" + staff + ", rental=" + rental
				+ ", amount=" + amount + ", paymentDate=" + paymentDate + ", lastUpdate=" + lastUpdate
				+ ", getPaymentId()=" + getPaymentId() + ", getCustomer()=" + getCustomer() + ", getStaff()="
				+ getStaff() + ", getRental()=" + getRental() + ", getAmount()=" + getAmount() + ", getPaymentDate()="
				+ getPaymentDate() + ", getLastUpdate()=" + getLastUpdate() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
 
	
 
	
}