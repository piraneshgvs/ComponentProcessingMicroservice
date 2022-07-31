package com.cognizant.component.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.component.model.ProcessRequestDetail;
import com.cognizant.component.service.AuthService;

@RestController
@CrossOrigin("*")
@RequestMapping("/processing")
public class ProcessingController {
	
	@Autowired
	AuthService authService;
	
	@PostMapping(value="/CompleteProcessing", consumes="application/json")
	public String processingDetail(@RequestHeader(name="Authorization", required = true) String token, @RequestBody ProcessRequestDetail processRequestDetail ) {
		if(authService.getAuthorization(token).equals("Valid Token")) {
			
			return processRequestDetail.getContactNumber();
		}
		return "Test was not Successfull";
	}

}
