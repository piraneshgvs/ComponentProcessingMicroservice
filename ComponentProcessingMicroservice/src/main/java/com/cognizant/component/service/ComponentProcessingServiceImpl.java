package com.cognizant.component.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.Calendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cognizant.component.client.PackagingClient;
import com.cognizant.component.controller.ProcessingController;
import com.cognizant.component.entity.ProcessRequestInfo;
import com.cognizant.component.entity.ProcessedChargeInfo;
import com.cognizant.component.model.DefectiveDetails;
import com.cognizant.component.model.DefectiveId;
import com.cognizant.component.repository.ProcessRequestRepo;
import com.cognizant.component.repository.ProcessedChargeRepo;

@Service
public class ComponentProcessingServiceImpl implements ComponentProcessingService{
	

	@Autowired
	ProcessRequestRepo processRequestRepo;
    
	@Autowired
	PackagingClient packagingClient;
	
	@Autowired
	ProcessedChargeRepo processedChargeRepo;
	
	@Autowired
	ProcessedChargeInfo processedChargeInfo;
	
	@Autowired
	DefectiveDetails defectiveDetails;
	
	@Autowired
	DefectiveId defectiveId;
	
	LocalDate localDate = LocalDate.now();
	
	private static final Logger logger = LoggerFactory.getLogger(ComponentProcessingServiceImpl.class);
	
	@Override
	public String saveProcessRequest(ProcessRequestInfo processRequestInfo) throws ParseException {
		
		
		//processRequestRepo.save(processRequestDetail.getUserName(),processRequestDetail.getContactNumber(),processRequestDetail.getDefectiveComponentDetail());
		 ResponseEntity<Long> responseEntity  = packagingClient.packageDelivery(processRequestInfo.getDefectiveComponentInfo().getComponentType(), processRequestInfo.getDefectiveComponentInfo().getQuantity());
		if(responseEntity.getStatusCode().is2xxSuccessful()&&responseEntity.hasBody()) {
			processRequestRepo.save(processRequestInfo);
		//System.out.println(processRequestInfo.getId());
		logger.info("Id : "+processRequestInfo.getId());
		processedChargeInfo.setId(processRequestInfo.getId());
		processedChargeInfo.setUserName(processRequestInfo.getUserName());
		if(processRequestInfo.getDefectiveComponentInfo().getComponentType().equals("Integral")) {
			processedChargeInfo.setProcessedCharge((long)500);
			logger.info("Date of delivery : "+localDate.plusDays(5));
			//System.out.println("Date of delivery : "+localDate.plusDays(5));
			processedChargeInfo.setDateOfDelivery(localDate.plusDays(5));
		}
		else if(processRequestInfo.getDefectiveComponentInfo().getComponentType().equals("Accessory")) {
			processedChargeInfo.setProcessedCharge((long)300);
			processedChargeInfo.setDateOfDelivery(localDate.plusDays(2));
		}
		processedChargeInfo.setPackageAndDeliveryCharge(responseEntity.getBody());
		if(processedChargeInfo.getPackageAndDeliveryCharge()!=null) {
		processedChargeRepo.save(processedChargeInfo);
		return "Success";
		}
		}
		
		return "Fail";
	}

	
	@Override
	public List<DefectiveDetails> getDetails(String userName) {
		List<DefectiveDetails> details = new ArrayList<DefectiveDetails>();
		defectiveDetails.setProcessRequestInfo(processRequestRepo.findByUserName(userName));
		defectiveDetails.setProcessedChargeInfo(processedChargeRepo.findByUserName(userName));
		details.add(defectiveDetails);
		return details;
	}
	 

	@Override
	public DefectiveId getDefectiveDetails(Long id) {
		
		defectiveId.setProcessRequestInfo(processRequestRepo.findById(id));
		defectiveId.setProcessedChargeInfo(processedChargeRepo.findById(id));
		
		return defectiveId;
		
	}
	
	
	
}
