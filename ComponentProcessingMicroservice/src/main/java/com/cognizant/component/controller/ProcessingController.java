package com.cognizant.component.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.component.entity.ProcessRequestInfo;
import com.cognizant.component.model.DefectiveDetails;
import com.cognizant.component.model.DefectiveId;
import com.cognizant.component.service.AuthService;
import com.cognizant.component.service.ComponentProcessingService;
import com.cognizant.component.service.ComponentProcessingServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/processing")
public class ProcessingController {
	
	@Autowired
	AuthService authService;
	
	@Autowired
	DefectiveDetails defectiveDetails;

	
	@Autowired
	ComponentProcessingService componentProcessingService;
	
	@PostMapping(value="/CompleteProcessing", consumes="application/json")
	public Long processingDetail(@RequestHeader(name="Authorization", required = true) String token, @RequestBody(required=true) ProcessRequestInfo processRequestInfo ) {
		if(authService.getAuthorization(token).equals("Valid Token")) {
			System.out.println(processRequestInfo.getDefectiveComponentInfo().getQuantity());
			String result = componentProcessingService.saveProcessRequest(processRequestInfo);
			return processRequestInfo.getId();
		}
		return 0L;
	}
	
	
	@GetMapping(value="/getDefectiveDetails/{userName}")
	public List<DefectiveDetails> getDefectiveDetails(@PathVariable String userName,@RequestHeader(name="Authorization", required = true) String token){
		if(authService.getAuthorization(token).equals("Valid Token")) {
		List<DefectiveDetails> details = componentProcessingService.getDetails(userName);
		return details;
		}
		return null;
	}
	
	@GetMapping(value="/getDetails/{id}")
	public List<DefectiveId> getDetailsById(@RequestHeader(name="Authorization", required = true) String token,@PathVariable Long id) {
		if(authService.getAuthorization(token).equals("Valid Token")) {
		List<DefectiveId> defectiveId = componentProcessingService.getDefectiveDetails(id);
		return defectiveId;
		}
		return null;
				
	}

}
