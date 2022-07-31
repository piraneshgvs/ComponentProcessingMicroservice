package com.cognizant.component.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.component.model.ProcessRequestDetail;
import com.cognizant.component.repository.ProcessRequestRepo;
import com.cognizant.component.repository.ProcessedChargeRepo;
import com.cognizant.component.service.AuthService;

@RestController
@CrossOrigin("*")
@RequestMapping("/processing")
public class ProcessingController {
	
	@Autowired
	AuthService authService;
	
	@Autowired
	ProcessedChargeRepo processedChargeRepo;
	
	@Autowired
	ProcessRequestRepo processRequestRepo;
	
	@PostMapping(value="/CompleteProcessing", consumes="application/json")
	public String processingDetail(@RequestHeader(name="Authorization", required = true) String token, @RequestBody(required=true) ProcessRequestDetail processRequestDetail ) {
		if(authService.getAuthorization(token).equals("Valid Token")) {
			processRequestRepo.save(processRequestDetail.getUserName(),processRequestDetail.getContactNumber(),processRequestDetail.getDefectiveComponentDetail());
			
			return processRequestDetail.getContactNumber();
		}
		return "Test was not Successfull";
	}

}
