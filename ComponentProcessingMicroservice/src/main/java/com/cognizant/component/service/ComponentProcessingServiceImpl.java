package com.cognizant.component.service;

import java.sql.Date;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.component.client.PackagingClient;
import com.cognizant.component.entity.ProcessRequestInfo;
import com.cognizant.component.entity.ProcessedChargeInfo;
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
	
	Calendar calendar = Calendar.getInstance();  
	
	@Override
	public String saveProcessRequest(ProcessRequestInfo processRequestInfo) {
		
		//processRequestRepo.save(processRequestDetail.getUserName(),processRequestDetail.getContactNumber(),processRequestDetail.getDefectiveComponentDetail());
		processRequestRepo.save(processRequestInfo);
		Long result = packagingClient.packageDelivery(processRequestInfo.getDefectiveComponentInfo().getComponentType(), processRequestInfo.getDefectiveComponentInfo().getQuantity());
		System.out.println(processRequestInfo.getId());
		processedChargeInfo.setId(processRequestInfo.getId());
		if(processRequestInfo.getDefectiveComponentInfo().getComponentType().equals("Integral")) {
			processedChargeInfo.setProcessedCharge((long)500);
		}
		else if(processRequestInfo.getDefectiveComponentInfo().getComponentType().equals("Accessory")) {
			processedChargeInfo.setProcessedCharge((long)300);
		}
		processedChargeInfo.setPackageAndDeliveryCharge(result);
		processedChargeInfo.setDateOfDelivery(processRequestInfo.getCdate());
		processedChargeRepo.save(processedChargeInfo);
		
		return "Success";
	}

}
