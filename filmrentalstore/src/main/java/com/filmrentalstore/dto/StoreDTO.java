package com.filmrentalstore.dto;
import java.time.LocalDateTime;
import java.util.List;
public class StoreDTO {
    private long storeId;
    private long addressId; // Representing Address by its ID
    private long managerStaffId; // Representing Manager (Staff) by its ID
    private LocalDateTime lastUpdate;
    private List<Long> staffIds; // Only include staff IDs
    private List<Long> customerIds; // Only include customer IDs
    private List<Long> inventoryIds; // Only include inventory IDs
    public long getStoreId() {
        return storeId;
    }
    public void setStoreId(long storeId) {
        this.storeId = storeId;
    }
    public long getAddressId() {
        return addressId;
    }
    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }
    public long getManagerStaffId() {
        return managerStaffId;
    }
    public void setManagerStaffId(long managerStaffId) {
        this.managerStaffId = managerStaffId;
    }
    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }
    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
    public List<Long> getStaffIds() {
        return staffIds;
    }
    public void setStaffIds(List<Long> staffIds) {
        this.staffIds = staffIds;
    }
    public List<Long> getCustomerIds() {
        return customerIds;
    }
    public void setCustomerIds(List<Long> customerIds) {
        this.customerIds = customerIds;
    }
    public List<Long> getInventoryIds() {
        return inventoryIds;
    }
    public void setInventoryIds(List<Long> inventoryIds) {
        this.inventoryIds = inventoryIds;
    }
    @Override
    public String toString() {
        return "StoreDTO{" +
                "storeId=" + storeId +
                ", addressId=" + addressId +
                ", managerStaffId=" + managerStaffId +
                ", lastUpdate=" + lastUpdate +
                ", staffIds=" + staffIds +
                ", customerIds=" + customerIds +
                ", inventoryIds=" + inventoryIds +
                '}';
    }
}