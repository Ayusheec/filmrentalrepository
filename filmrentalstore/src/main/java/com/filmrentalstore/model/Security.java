package com.filmrentalstore.model;
 
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
 
@Entity
@Table(name = "security")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Security {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int security_id;
 
    private String username;
 
    private String password;
 
    // Getters and Setters
    public int getSecurity_id() {
        return security_id;
    }
 
    public void setSecurity_id(int security_id) {
        this.security_id = security_id;
    }
 
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Security [security_id=" + security_id + ", username=" + username + ", password=" + password + "]";
    }
}