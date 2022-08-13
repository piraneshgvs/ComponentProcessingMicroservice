package com.cognizant.component.controller;

import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.component.constant.GeneralConstant;
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
	public ResponseEntity<Long> processingDetail(@RequestHeader(name="Authorization", required = true) String token,@Valid @RequestBody(required=true) ProcessRequestInfo processRequestInfo ) throws ParseException {
		if(authService.getAuthorization(token).equals("Valid Token")) {
			System.out.println(processRequestInfo.getDefectiveComponentInfo().getQuantity());
			String result = componentProcessingService.saveProcessRequest(processRequestInfo);
			return new ResponseEntity<>(processRequestInfo.getId(),HttpStatus.OK);
		
	}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping(value="/getDefectiveDetails/{userName}")
	public ResponseEntity<List<DefectiveDetails>> getDefectiveDetails(@PathVariable(required=true) String userName,@RequestHeader(name="Authorization", required = true) String token){
		if(authService.getAuthorization(token).equals("Valid Token")) {
			if(userName.trim()!=null) {
		List<DefectiveDetails> details = componentProcessingService.getDetails(userName);
		return new ResponseEntity<>(details,HttpStatus.OK);
		}
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping(value="/ProcessDetail/{id}")
	public ResponseEntity<DefectiveId> getDetailsById(@RequestHeader(name="Authorization", required = true) String token,@PathVariable(required=true) Long id) {
		if(authService.getAuthorization(token).equals("Valid Token")) {
			if(id!=null&&id>=1) {
		DefectiveId defectiveId = componentProcessingService.getDefectiveDetails(id);
		return new ResponseEntity<>(defectiveId,HttpStatus.OK);
		}
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
				
	}

}
