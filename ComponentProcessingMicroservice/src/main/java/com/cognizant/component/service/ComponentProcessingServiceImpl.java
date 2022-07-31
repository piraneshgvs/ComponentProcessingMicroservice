package com.cognizant.component.service;

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
	
	@Override
	public String saveProcessRequest(ProcessRequestInfo processRequestInfo) {
		
		//processRequestRepo.save(processRequestDetail.getUserName(),processRequestDetail.getContactNumber(),processRequestDetail.getDefectiveComponentDetail());
		processRequestRepo.save(processRequestInfo);
		Long result = packagingClient.packageDelivery(processRequestInfo.getDefectiveComponentInfo().getComponentType(), processRequestInfo.getDefectiveComponentInfo().getQuantity());
		System.out.println(processRequestInfo.getId());
		processedChargeInfo.setId(processRequestInfo.getId());
		processedChargeInfo.setProcessedCharge((long) 456);
		processedChargeInfo.setPackageAndDeliveryCharge(result);
		processedChargeInfo.setDateOfDelivery(processRequestInfo.getCdate());
		processedChargeRepo.save(processedChargeInfo);
		
		return "Success";
	}

}
