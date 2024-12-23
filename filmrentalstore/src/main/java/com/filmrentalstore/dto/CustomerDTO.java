package com.filmrentalstore.dto;
 
import java.time.LocalDateTime;
import java.util.List;
 
public class CustomerDTO {
 
    private long customerId;
    private long storeId; // Representing the Store by its ID
    private String firstName;
    private String lastName;
    private String email;
    private long addressId; // Representing the Address by its ID
    private List<Long> paymentIds; // Representing Payments by their IDs
    private List<Long> rentalIds; // Representing Rentals by their IDs
    private boolean isActive; // Boolean representation of active status
    private LocalDateTime createDate;
    private LocalDateTime lastUpdate;
 
    public long getCustomerId() {
        return customerId;
    }
 
    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }
 
    public long getStoreId() {
        return storeId;
    }
 
    public void setStoreId(long storeId) {
        this.storeId = storeId;
    }
 
    public String getFirstName() {
        return firstName;
    }
 
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
 
    public String getLastName() {
        return lastName;
    }
 
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public long getAddressId() {
        return addressId;
    }
 
    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }
 
    public List<Long> getPaymentIds() {
        return paymentIds;
    }
 
    public void setPaymentIds(List<Long> paymentIds) {
        this.paymentIds = paymentIds;
    }
 
    public List<Long> getRentalIds() {
        return rentalIds;
    }
 
    public void setRentalIds(List<Long> rentalIds) {
        this.rentalIds = rentalIds;
    }
 
    public boolean isActive() {
        return isActive;
    }
 
    public void setActive(boolean active) {
        isActive = active;
    }
 
    public LocalDateTime getCreateDate() {
        return createDate;
    }
 
    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }
 
    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }
 
    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
 
    @Override
    public String toString() {
        return "CustomerDTO{" +
                "customerId=" + customerId +
                ", storeId=" + storeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", addressId=" + addressId +
                ", paymentIds=" + paymentIds +
                ", rentalIds=" + rentalIds +
                ", isActive=" + isActive +
                ", createDate=" + createDate +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}