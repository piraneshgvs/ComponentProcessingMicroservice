package com.cognizant.component.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.component.entity.ProcessRequestInfo;
import com.cognizant.component.entity.ProcessedChargeInfo;

@Repository
public interface ProcessedChargeRepo extends JpaRepository<ProcessedChargeInfo, Long>{

	List<ProcessedChargeInfo> findByUserName(String userName);
    
	Optional<ProcessedChargeInfo> findById(Long id);
}
