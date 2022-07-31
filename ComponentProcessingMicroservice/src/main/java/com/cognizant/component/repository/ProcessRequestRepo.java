package com.cognizant.component.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.component.entity.ProcessRequestInfo;
import com.cognizant.component.model.DefectiveComponentDetail;

@Repository
public interface ProcessRequestRepo extends JpaRepository<ProcessRequestInfo, Long> {

	void save(String userName, String contactNumber, DefectiveComponentDetail defectiveComponentDetail);
	

}
