package com.filmrentalstore.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filmrentalstore.exception.InvalidException;
import com.filmrentalstore.model.Security;
import com.filmrentalstore.repository.SecurityRepo;
import com.filmrentalstore.service.SecurityService;

@Service
public class SecurityImpl implements SecurityService {

	 @Autowired
	 private SecurityRepo securityRepo;
	
	 @Override
		public Security createSecurity(Security security) {
		 return securityRepo.save(security);
	}
	 
	// Authenticate user with username and password
	@Override
	public boolean authenticate(String username, String password) throws InvalidException {
		Security security = securityRepo.findByUsername(username);
        if (security != null && security.getPassword().equals(password)) {
            return true; // Login success
        }
        return false; // Invalid username or password
	}

	// Update staff password
	@Override
	public boolean updatePassword(int staffId, String newPassword) throws InvalidException {
		Security security = securityRepo.findById(staffId).orElse(null);
        if (security != null) {
            security.setPassword(newPassword);
            securityRepo.save(security);
            return true;
        }
        return false; // Staff not found
	}
}
