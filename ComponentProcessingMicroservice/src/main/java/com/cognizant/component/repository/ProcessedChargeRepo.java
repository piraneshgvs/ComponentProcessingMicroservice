package com.cognizant.component.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.component.entity.ProcessRequestInfo;
import com.cognizant.component.entity.ProcessedChargeInfo;

@Repository
public interface ProcessedChargeRepo extends JpaRepository<ProcessedChargeInfo, Long>{



}
