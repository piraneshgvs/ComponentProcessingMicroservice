package com.cognizant.component.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.Calendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.component.client.PackagingClient;
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
	
	Calendar calendar = Calendar.getInstance();  
	
	@Override
	public String saveProcessRequest(ProcessRequestInfo processRequestInfo) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		//processRequestRepo.save(processRequestDetail.getUserName(),processRequestDetail.getContactNumber(),processRequestDetail.getDefectiveComponentDetail());
		processRequestRepo.save(processRequestInfo);
		Long result = packagingClient.packageDelivery(processRequestInfo.getDefectiveComponentInfo().getComponentType(), processRequestInfo.getDefectiveComponentInfo().getQuantity());
		System.out.println(processRequestInfo.getId());
		processedChargeInfo.setId(processRequestInfo.getId());
		processedChargeInfo.setUserName(processRequestInfo.getUserName());
		if(processRequestInfo.getDefectiveComponentInfo().getComponentType().equals("Integral")) {
			processedChargeInfo.setProcessedCharge((long)500);
			cal.add(Calendar.DAY_OF_MONTH,5);
			String addedDate = sdf.format(cal.getTime());
			processedChargeInfo.setDateOfDelivery(sdf.parse(addedDate));
		}
		else if(processRequestInfo.getDefectiveComponentInfo().getComponentType().equals("Accessory")) {
			processedChargeInfo.setProcessedCharge((long)300);
			cal.add(Calendar.DAY_OF_MONTH,2);
			String addedDate = sdf.format(cal.getTime());
			processedChargeInfo.setDateOfDelivery(sdf.parse(addedDate));
		}
		processedChargeInfo.setPackageAndDeliveryCharge(result);
		processedChargeRepo.save(processedChargeInfo);
		
		return "Success";
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
	public List<DefectiveId> getDefectiveDetails(Long id) {
		
		List<DefectiveId> details = new ArrayList<DefectiveId>();
		defectiveId.setProcessRequestInfo(processRequestRepo.findById(id));
		defectiveId.setProcessedChargeInfo(processedChargeRepo.findById(id));
		details.add(defectiveId);
		
		return details;
		
	}
	
	
	
}
