package com.filmrentalstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.filmrentalstore.dto.SecurityDTO;
import com.filmrentalstore.exception.InvalidException;
import com.filmrentalstore.model.Security;
import com.filmrentalstore.service.SecurityService;

@RestController
@RequestMapping("/api/security")
@CrossOrigin(origins = "http://localhost:5173")
public class SecurityController {
	@Autowired
    private SecurityService securityService;

	// POST method to add username and password
    @PostMapping("/add")
    public ResponseEntity<Security> createSecurity(@RequestBody SecurityDTO securityRequest) {
        Security security = new Security();
        security.setUsername(securityRequest.getUsername());
        security.setPassword(securityRequest.getPassword());
        Security savedSecurity = securityService.createSecurity(security);
        return ResponseEntity.ok(savedSecurity);
    }
	
 // Login Endpoint: Validate username and password
    @GetMapping("/login/{un}/{pw}")
    public ResponseEntity<String> login(@PathVariable("un") String username, @PathVariable("pw") String password) throws InvalidException {
        boolean isAuthenticated = securityService.authenticate(username, password);
        if (isAuthenticated) {
            // Return a response such as a success message or JWT token
            return ResponseEntity.ok("Login successful");
        } else {
            throw new InvalidException("Invalid username or password");
        }
    }
    
    // Change Password Endpoint: Allow staff to change their password
    @PutMapping("/changePassword/{staffId}")
    public ResponseEntity<String> changePassword(@PathVariable int staffId, @RequestParam String newPassword) throws InvalidException {
        boolean isUpdated = securityService.updatePassword(staffId, newPassword);
        if (isUpdated) {
            return ResponseEntity.ok("Password updated successfully");
        } else {
            throw new InvalidException("Error updating password");
        }
    }
}
