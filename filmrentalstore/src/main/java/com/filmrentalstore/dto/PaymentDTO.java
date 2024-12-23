package com.filmrentalstore.dto;
 
import java.time.LocalDateTime;
 
public class PaymentDTO {
 
	private long customerId;
    private int staffId;
    private long rentalId;
    private long amount;
    private LocalDateTime paymentDate;
    private LocalDateTime lastUpdate;
    
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	
	public long getRentalId() {
		return rentalId;
	}
	public void setRentalId(long rentalId) {
		this.rentalId = rentalId;
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
}