package com.cognizant.component.entity;

import javax.persistence.Embeddable;

@Embeddable
public class DefectiveComponentInfo {
	
	private String componentType;
	private String componentName;
	private Long quantity;
	private String description;
	
	public String getComponentType() {
		return componentType;
	}
	public void setComponentType(String componentType) {
		System.out.println(componentType);
		this.componentType = componentType;
	}
	public String getComponentName() {
		return componentName;
	}
	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "DefectiveComponentDetail [componentType=" + componentType + ", componentName=" + componentName
				+ ", quantity=" + quantity + ", description=" + description + "]";
	}
	
	public DefectiveComponentInfo(String componentType, String componentName, Long quantity, String description) {
		super();
		this.componentType = componentType;
		this.componentName = componentName;
		this.quantity = quantity;
		this.description = description;
	}
	
	public DefectiveComponentInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
