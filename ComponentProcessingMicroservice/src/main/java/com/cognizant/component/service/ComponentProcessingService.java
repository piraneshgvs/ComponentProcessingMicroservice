package com.cognizant.component.service;

import java.util.List;

import com.cognizant.component.entity.ProcessRequestInfo;
import com.cognizant.component.model.DefectiveDetails;

public interface ComponentProcessingService {
	
	public String saveProcessRequest(ProcessRequestInfo processRequestInfo);
	
	public List<DefectiveDetails> getDetails(String userName);

}
