package com.cognizant.component.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.component.client.AuthClient;

@Service
public class AuthServiceImpl implements AuthService {
	
	@Autowired
	AuthClient authClient;

	@Override
	public String getAuthorization(String token) {
		
		
		return authClient.validateToken(token);
	}

}
