package com.cognizant.component.service;

import java.text.ParseException;
import java.util.List;

import com.cognizant.component.entity.ProcessRequestInfo;
import com.cognizant.component.model.DefectiveDetails;
import com.cognizant.component.model.DefectiveId;

public interface ComponentProcessingService {
	
	public String saveProcessRequest(ProcessRequestInfo processRequestInfo) throws ParseException;
	
	public List<DefectiveDetails> getDetails(String userName);
	
	public DefectiveId getDefectiveDetails(Long id);

}
