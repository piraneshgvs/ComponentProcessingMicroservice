package com.cognizant.component.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name="PROCESS_REQUEST_INFO")
public class ProcessRequestInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String userName;
	private String contactNumber;
	@Embedded
	private DefectiveComponentInfo defectiveComponentInfo;
	 @Column(name = "createdDate", nullable = false, updatable = false)
	 @Temporal(TemporalType.TIMESTAMP)
	 @CreatedDate
	 private Date date;
	 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public DefectiveComponentInfo getDefectiveComponentInfo() {
		return defectiveComponentInfo;
	}
	public void setDefectiveComponentInfo(DefectiveComponentInfo defectiveComponentInfo) {
		this.defectiveComponentInfo = defectiveComponentInfo;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "ProcessRequestInfo [id=" + id + ", userName=" + userName + ", contactNumber=" + contactNumber
				+ ", defectiveComponentInfo=" + defectiveComponentInfo + ", date=" + date + "]";
	}
	public ProcessRequestInfo(int id, String userName, String contactNumber,
			DefectiveComponentInfo defectiveComponentInfo, Date date) {
		super();
		this.id = id;
		this.userName = userName;
		this.contactNumber = contactNumber;
		this.defectiveComponentInfo = defectiveComponentInfo;
		this.date = date;
	}
	public ProcessRequestInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
		 
	 
	 
}
