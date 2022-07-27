package com.cognizant.component.model;

import org.springframework.stereotype.Component;

@Component
public class ProcessRequestDetail {
	
	private String userName;
	private String contactNumber;
	private DefectiveComponentDetail defectiveComponentDetail;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public DefectiveComponentDetail getDefectiveComponentDetail() {
		return defectiveComponentDetail;
	}
	public void setDefectiveComponentDetail(DefectiveComponentDetail defectiveComponentDetail) {
		this.defectiveComponentDetail = defectiveComponentDetail;
	}
	
	@Override
	public String toString() {
		return "ProcessRequestDetail [userName=" + userName + ", contactNumber=" + contactNumber
				+ ", defectiveComponentDetail=" + defectiveComponentDetail + "]";
	}
	
	public ProcessRequestDetail(String userName, String contactNumber,
			DefectiveComponentDetail defectiveComponentDetail) {
		super();
		this.userName = userName;
		this.contactNumber = contactNumber;
		this.defectiveComponentDetail = defectiveComponentDetail;
	}
	
	public ProcessRequestDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
