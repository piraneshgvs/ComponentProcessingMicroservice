package com.cognizant.component.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;

import com.cognizant.component.entity.ProcessRequestInfo;
import com.cognizant.component.entity.ProcessedChargeInfo;

@Component
public class DefectiveDetails {

	private List<ProcessedChargeInfo> processedChargeInfo;
	private List<ProcessRequestInfo> processRequestInfo;
	public List<ProcessedChargeInfo> getProcessedChargeInfo() {
		return processedChargeInfo;
	}
	public void setProcessedChargeInfo(List<ProcessedChargeInfo> list) {
		this.processedChargeInfo = list;
	}
	public List<ProcessRequestInfo> getProcessRequestInfo() {
		return processRequestInfo;
	}
	public void setProcessRequestInfo(List<ProcessRequestInfo> list) {
		this.processRequestInfo = list;
	}
	@Override
	public String toString() {
		return "DefectiveDetails [processedChargeInfo=" + processedChargeInfo + ", processRequestInfo="
				+ processRequestInfo + "]";
	}
	public DefectiveDetails(List<ProcessedChargeInfo> processedChargeInfo, List<ProcessRequestInfo> processRequestInfo) {
		super();
		this.processedChargeInfo = processedChargeInfo;
		this.processRequestInfo = processRequestInfo;
	}
	public DefectiveDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
