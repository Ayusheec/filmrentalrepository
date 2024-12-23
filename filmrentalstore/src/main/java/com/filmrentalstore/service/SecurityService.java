package com.filmrentalstore.service;

import com.filmrentalstore.exception.InvalidException;
import com.filmrentalstore.model.Security;

public interface SecurityService {
	public boolean authenticate(String username, String password)throws InvalidException;
	public boolean updatePassword(int staffId, String newPassword) throws InvalidException;
	public Security createSecurity(Security security);
}
