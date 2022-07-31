package com.cognizant.component.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.component.entity.ProcessRequestInfo;

@Repository
public interface ProcessedChargeRepo extends JpaRepository<ProcessRequestInfo, Long>{

}
