package com.cognizant.component.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cognizant.component.entity.DefectiveComponentInfo;
import com.cognizant.component.entity.ProcessRequestInfo;
import com.cognizant.component.model.DefectiveDetails;
import com.cognizant.component.model.DefectiveId;
import com.cognizant.component.service.AuthService;
import com.cognizant.component.service.ComponentProcessingService;

@SpringBootTest
public class ProcessingControllerTest {
	
	
	@Mock
	AuthService authService;
	
	@Mock
	ComponentProcessingService componentProcessingService;
	
	@Mock
	ProcessRequestInfo processRequestInfos;
	
	@InjectMocks
	ProcessingController processingController;
	
	@Test
	public void processDetailTest() throws ParseException {
		ProcessRequestInfo processRequestInfo = new ProcessRequestInfo();
		DefectiveComponentInfo defectiveComponentInfo = new DefectiveComponentInfo("Integral","Bus",1L,"Bus is for Integral");
		processRequestInfo.setId(15L);
		processRequestInfo.setUserName("pisakthi");
		processRequestInfo.setContactNumber("1478523695");
		processRequestInfo.setDefectiveComponentInfo(defectiveComponentInfo);
		when(authService.getAuthorization("dummy-token")).thenReturn("Valid Token");
		when(componentProcessingService.saveProcessRequest(processRequestInfo)).thenReturn("Success");
		//when(processRequestInfos.getDefectiveComponentInfo().getQuantity()).thenReturn(null);
		ResponseEntity<Long> result = processingController.processingDetail("dummy-token", processRequestInfo);
		
		
		assertEquals(HttpStatus.OK, result.getStatusCode());
	}
	
	@Test
	public void processDetailTestNull() throws ParseException {
		ProcessRequestInfo processRequestInfo = new ProcessRequestInfo();
		DefectiveComponentInfo defectiveComponentInfo = new DefectiveComponentInfo("Integral","Bus",1L,"Bus is for Integral");
		processRequestInfo.setId(15L);
		processRequestInfo.setUserName("pisakthi");
		processRequestInfo.setContactNumber("1478523695");
		processRequestInfo.setDefectiveComponentInfo(defectiveComponentInfo);
		when(authService.getAuthorization("dummy-token")).thenReturn("Token");
		when(componentProcessingService.saveProcessRequest(processRequestInfo)).thenReturn("Success");
		//when(processRequestInfos.getDefectiveComponentInfo().getQuantity()).thenReturn(null);
		ResponseEntity<Long> result = processingController.processingDetail("dummy-token", processRequestInfo);
		
		
		assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());
	}
	
	
	@Test
	public void getDefectiveDetailsTest() {
		
	
		List<DefectiveDetails> defect = new ArrayList<>();
		when(authService.getAuthorization("dummy-token")).thenReturn("Valid Token");
		when(componentProcessingService.getDetails("pisakthi")).thenReturn(defect);
		ResponseEntity<List<DefectiveDetails>> result = processingController.getDefectiveDetails("pisakthi", "dummy-token");
		assertEquals(HttpStatus.OK,result.getStatusCode());
		
	}
	
	@Test
	public void getDefectiveDetailsTestToken() {
		
	
		List<DefectiveDetails> defect = new ArrayList<>();
		when(authService.getAuthorization("dummy-token")).thenReturn("Token");
		when(componentProcessingService.getDetails("pisakthi")).thenReturn(defect);
		ResponseEntity<List<DefectiveDetails>> result = processingController.getDefectiveDetails("pisakthi", "dummy-token");
		assertEquals(HttpStatus.BAD_REQUEST,result.getStatusCode());
		
	}
	
	
	@Test
	public void getDetailsByIdTest() {
		when(authService.getAuthorization("dummy-token")).thenReturn("Valid Token");
		when(componentProcessingService.getDefectiveDetails(15L)).thenReturn(new DefectiveId());
		ResponseEntity<DefectiveId> result = processingController.getDetailsById("dummy-token", 15L);
		assertEquals(HttpStatus.OK,result.getStatusCode());
	}
	
	@Test
	public void getDetailsByIdTestNull() {
		when(authService.getAuthorization("dummy-token")).thenReturn("Token");
		when(componentProcessingService.getDefectiveDetails(15L)).thenReturn(new DefectiveId());
		ResponseEntity<DefectiveId> result = processingController.getDetailsById("dummy-token", 15L);
		assertEquals(HttpStatus.BAD_REQUEST,result.getStatusCode());
	}

}
