package com.filmrentalstore.dto;
public class ManagerStoreResponse {
 
    private String managerFirstName;
    private String managerLastName;
    private String managerEmail;
    
    private String storeAddress;
    private String storeCity;
    private String storePhone;
 
    // Constructor
    public ManagerStoreResponse(String managerFirstName, String managerLastName, String managerEmail,  
                                 String storeAddress, String storeCity, String storePhone) {
        this.managerFirstName = managerFirstName;
        this.managerLastName = managerLastName;
        this.managerEmail = managerEmail;
        this.storeAddress = storeAddress;
        this.storeCity = storeCity;
        this.storePhone = storePhone;
    }
 
    // Getters and Setters
    public String getManagerFirstName() {
        return managerFirstName;
    }
 
    public void setManagerFirstName(String managerFirstName) {
        this.managerFirstName = managerFirstName;
    }
 
    public String getManagerLastName() {
        return managerLastName;
    }
 
    public void setManagerLastName(String managerLastName) {
        this.managerLastName = managerLastName;
    }
 
    public String getManagerEmail() {
        return managerEmail;
    }
 
    public void setManagerEmail(String managerEmail) {
        this.managerEmail = managerEmail;
    }
 
   
    public String getStoreAddress() {
        return storeAddress;
    }
 
    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }
 
    public String getStoreCity() {
        return storeCity;
    }
 
    public void setStoreCity(String storeCity) {
        this.storeCity = storeCity;
    }
 
    public String getStorePhone() {
        return storePhone;
    }
 
    public void setStorePhone(String storePhone) {
        this.storePhone = storePhone;
    }
}