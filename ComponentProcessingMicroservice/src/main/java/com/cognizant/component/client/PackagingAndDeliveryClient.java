package com.cognizant.component.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="PACKAGING_AND_DELIVERY")
public interface PackagingAndDeliveryClient {

	@GetMapping("/GetPackagingDeliveryCharge")
	public Long getPackagingAndDeliveryCharge(String componentType, Long count);
}
