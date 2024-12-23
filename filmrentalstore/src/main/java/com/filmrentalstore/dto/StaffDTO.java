package com.filmrentalstore.dto;
 
import java.time.LocalDateTime;
 
public class StaffDTO {
    private int staffId;
    private String firstName;
    private String lastName;
    private String email;
    private boolean active;
    private LocalDateTime lastUpdate;
 
    public StaffDTO() {}
 
    public StaffDTO(int staffId, String firstName, String lastName, String email, boolean active, LocalDateTime lastUpdate) {
        this.staffId = staffId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.active = active;
        this.lastUpdate = lastUpdate;
    }
 
    public int getStaffId() {
        return staffId;
    }
 
    public void setStaffId(int staffId) {
        this.staffId = staffId;
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
 
    public boolean isActive() {
        return active;
    }
 
    public void setActive(boolean active) {
        this.active = active;
    }
 
    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }
 
    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}