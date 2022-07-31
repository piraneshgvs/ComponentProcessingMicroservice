package com.cognizant.component.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PROCESSED_CHARGE_INFO")
public class ProcessedChargeInfo {
	
	@Id
	private Long id;
	private Long processedCharge;
	private Long packageAndDeliveryCharge;
	private Date dateOfDelivery;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Date getDateOfDelivery() {
		return dateOfDelivery;
	}
	public void setDateOfDelivery(Date dateOfDelivery) {
		this.dateOfDelivery = dateOfDelivery;
	}
	@Override
	public String toString() {
		return "ProcessedChargeInfo [id=" + id + ", processedCharge=" + processedCharge + ", packageAndDeliveryCharge="
				+ packageAndDeliveryCharge + ", dateOfDelivery=" + dateOfDelivery + "]";
	}
	public ProcessedChargeInfo(Long id, Long processedCharge, Long packageAndDeliveryCharge, Date dateOfDelivery) {
		super();
		this.id = id;
		this.processedCharge = processedCharge;
		this.packageAndDeliveryCharge = packageAndDeliveryCharge;
		this.dateOfDelivery = dateOfDelivery;
	}
	public ProcessedChargeInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
