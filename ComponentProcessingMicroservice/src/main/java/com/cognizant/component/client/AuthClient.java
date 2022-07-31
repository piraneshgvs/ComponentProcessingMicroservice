package com.cognizant.component.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name="AUTHENTICATION")
public interface AuthClient {
	
	@GetMapping("/validate")
	public String validateToken(@RequestHeader(name="Authorization", required = true) String token);
		
}
