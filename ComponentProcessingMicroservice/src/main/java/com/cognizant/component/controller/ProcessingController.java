package com.cognizant.component.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.component.entity.ProcessRequestInfo;
import com.cognizant.component.service.AuthService;
import com.cognizant.component.service.ComponentProcessingServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping("/processing")
public class ProcessingController {
	
	@Autowired
	AuthService authService;

	
	@Autowired
	ComponentProcessingServiceImpl componentProcessingServiceImpl;
	
	@PostMapping(value="/CompleteProcessing", consumes="application/json")
	public String processingDetail(@RequestHeader(name="Authorization", required = true) String token, @RequestBody(required=true) ProcessRequestInfo processRequestInfo ) {
		if(authService.getAuthorization(token).equals("Valid Token")) {
			//System.out.println(processRequestInfo.getDefectiveComponentInfo().getQuantity());
			String result = componentProcessingServiceImpl.saveProcessRequest(processRequestInfo);
			return result;
		}
		return "Test was not Successfull";
	}

}
