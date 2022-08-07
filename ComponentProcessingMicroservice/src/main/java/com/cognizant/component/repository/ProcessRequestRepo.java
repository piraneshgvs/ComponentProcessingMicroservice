package com.cognizant.component.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.component.entity.ProcessRequestInfo;

@Repository
public interface ProcessRequestRepo extends JpaRepository<ProcessRequestInfo, Long> {

	 
	List<ProcessRequestInfo> findByUserName(String userName);
	
	
	
}
