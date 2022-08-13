package com.cognizant.component.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="PROCESSED_CHARGE_INFO")
@Component
public class ProcessedChargeInfo {
	
	@Id
	private Long id;
	@Column(nullable = false)
	private String userName;
	@Column(nullable = false)
	private Long processedCharge;
	@Column(nullable = false)
	private Long packageAndDeliveryCharge;
	@Column(nullable = false)
	private LocalDate dateOfDelivery;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Long getProcessedCharge() {
		return processedCharge;
	}
	public void setProcessedCharge(Long processedCharge) {
		this.processedCharge = processedCharge;
	}
	public Long getPackageAndDeliveryCharge() {
		return packageAndDeliveryCharge;
	}
	public void setPackageAndDeliveryCharge(Long packageAndDeliveryCharge) {
		this.packageAndDeliveryCharge = packageAndDeliveryCharge;
	}
	public LocalDate getDateOfDelivery() {
		return dateOfDelivery;
	}
	public void setDateOfDelivery(LocalDate localDate) {
		this.dateOfDelivery = localDate;
	}
	@Override
	public String toString() {
		return "ProcessedChargeInfo [id=" + id + ", userName=" + userName + ", processedCharge=" + processedCharge
				+ ", packageAndDeliveryCharge=" + packageAndDeliveryCharge + ", dateOfDelivery=" + dateOfDelivery + "]";
	}
	public ProcessedChargeInfo(Long id, String userName, Long processedCharge, Long packageAndDeliveryCharge,
			LocalDate dateOfDelivery) {
		super();
		this.id = id;
		this.userName = userName;
		this.processedCharge = processedCharge;
		this.packageAndDeliveryCharge = packageAndDeliveryCharge;
		this.dateOfDelivery = dateOfDelivery;
	}
	public ProcessedChargeInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}