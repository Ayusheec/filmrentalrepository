package com.filmrentalstore.dto;
import java.time.LocalDateTime;
import java.util.List;
public class AddressDTO {
    private long addressId;
    private String address;
    private String address2;
    private String district;
    private long cityId; // Representing the city as its ID
    private String postalCode;
    private String phone;
    private LocalDateTime lastUpdate;
    private List<Long> customerIds; // Only include customer IDs
    private List<Long> staffIds; // Only include staff IDs
    private List<Long> storeIds; // Only include store IDs
    public long getAddressId() {
        return addressId;
    }
    public void setAddressId(long addressId) {
        this.addressId = addressId;
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
    public long getCityId() {
        return cityId;
    }
    public void setCityId(long cityId) {
        this.cityId = cityId;
    }
    public String getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }
    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
    public List<Long> getCustomerIds() {
        return customerIds;
    }
    public void setCustomerIds(List<Long> customerIds) {
        this.customerIds = customerIds;
    }
    public List<Long> getStaffIds() {
        return staffIds;
    }
    public void setStaffIds(List<Long> staffIds) {
        this.staffIds = staffIds;
    }
    public List<Long> getStoreIds() {
        return storeIds;
    }
    public void setStoreIds(List<Long> storeIds) {
        this.storeIds = storeIds;
    }
    @Override
    public String toString() {
        return "AddressDTO{" +
                "addressId=" + addressId +
                ", address='" + address + '\'' +
                ", address2='" + address2 + '\'' +
                ", district='" + district + '\'' +
                ", cityId=" + cityId +
                ", postalCode='" + postalCode + '\'' +
                ", phone='" + phone + '\'' +
                ", lastUpdate=" + lastUpdate +
                ", customerIds=" + customerIds +
                ", staffIds=" + staffIds +
                ", storeIds=" + storeIds +
                '}';
    }
}