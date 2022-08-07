package com.cognizant.component.model;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.cognizant.component.entity.ProcessRequestInfo;
import com.cognizant.component.entity.ProcessedChargeInfo;

@Component
public class DefectiveId {
	
	private Optional<ProcessRequestInfo> processRequestInfo;
	private Optional<ProcessedChargeInfo> processedChargeInfo;
	public Optional<ProcessRequestInfo> getProcessRequestInfo() {
		return processRequestInfo;
	}
	public void setProcessRequestInfo(Optional<ProcessRequestInfo> optional) {
		this.processRequestInfo = optional;
	}
	public Optional<ProcessedChargeInfo> getProcessedChargeInfo() {
		return processedChargeInfo;
	}
	public void setProcessedChargeInfo(Optional<ProcessedChargeInfo> optional) {
		this.processedChargeInfo = optional;
	}
	@Override
	public String toString() {
		return "DefectiveId [processRequestInfo=" + processRequestInfo + ", processedChargeInfo=" + processedChargeInfo
				+ "]";
	}
	public DefectiveId(Optional<ProcessRequestInfo> processRequestInfo, Optional<ProcessedChargeInfo> processedChargeInfo) {
		super();
		this.processRequestInfo = processRequestInfo;
		this.processedChargeInfo = processedChargeInfo;
	}
	public DefectiveId() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
