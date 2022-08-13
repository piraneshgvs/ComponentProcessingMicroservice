package com.cognizant.component.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="PACKAGE-AND-DELIVERY")
public interface PackagingClient {
	
	@GetMapping("/GetPackagingDeliveryCharge")
	public ResponseEntity<Long> packageDelivery(@RequestParam String componentType,@RequestParam Long count);

}
