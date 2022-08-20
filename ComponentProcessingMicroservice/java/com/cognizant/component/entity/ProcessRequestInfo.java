package com.cognizant.component.entity;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;


@Entity
@Table(name="PROCESS_REQUEST_INFO")
public class ProcessRequestInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@NotBlank(message="userName cannot be blank")
	private String userName;
	@NotBlank(message="Contact Number cannot be blank")
	@Pattern(regexp = "^((\\\\+91-?)|0)?[0-9]{10}$")
	@Column(length = 10)
	private String contactNumber;
	@Embedded
	@Valid
	private DefectiveComponentInfo defectiveComponentInfo;
	@Column(name = "creation_date", nullable = false, updatable = false)
	@CreationTimestamp
	private LocalDate cdate;
	
	
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId() {
		return id;
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
	public LocalDate getCdate() {
		return cdate;
	}
	public void setCdate(LocalDate cdate) {
		this.cdate = cdate;
	}

	@Override
	public String toString() {
		return "ProcessRequestInfo [id=" + id + ", userName=" + userName + ", contactNumber=" + contactNumber
				+ ", defectiveComponentInfo=" + defectiveComponentInfo + ", cdate=" + cdate 
				+ "]";
	}
	public ProcessRequestInfo(Long id, String userName, String contactNumber,
			DefectiveComponentInfo defectiveComponentInfo, LocalDate cdate) {
		super();
		this.id = id;
		this.userName = userName;
		this.contactNumber = contactNumber;
		this.defectiveComponentInfo = defectiveComponentInfo;
		this.cdate = cdate;
		
	}
	public ProcessRequestInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	 
	}