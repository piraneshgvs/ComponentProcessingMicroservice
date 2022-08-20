package com.cognizant.component.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.component.entity.DefectiveComponentInfo;
import com.cognizant.component.entity.ProcessRequestInfo;
import com.cognizant.component.entity.ProcessedChargeInfo;

@SpringBootTest
public class DefectiveDetailsTest {
	
	@InjectMocks
	DefectiveDetails defectiveDetails;
	
	@Test
	public void testingDefectiveDetails() {
		
		List<ProcessedChargeInfo> processedChargeInfo = new ArrayList<>();
		List<ProcessRequestInfo> processRequestInfo = new ArrayList<>();
		ProcessRequestInfo processRequestInfo1 = new ProcessRequestInfo();
		DefectiveComponentInfo defectiveComponentInfo = new DefectiveComponentInfo("Integral","Bus",1L,"Bus is for Integral");
		processRequestInfo1.setId(15L);
		processRequestInfo1.setUserName("pisakthi");
		processRequestInfo1.setContactNumber("1478523695");
		processRequestInfo1.setDefectiveComponentInfo(defectiveComponentInfo);
		ProcessedChargeInfo processedChargeInfo1 = new ProcessedChargeInfo();
		processedChargeInfo1.setUserName("pisakthi");
		processedChargeInfo1.setId(1L);
		processedChargeInfo1.setPackageAndDeliveryCharge(1475L);
		processedChargeInfo1.setProcessedCharge(258L);
		processRequestInfo.add(processRequestInfo1);
		processedChargeInfo.add(processedChargeInfo1);
		defectiveDetails.setProcessedChargeInfo(processedChargeInfo);
		defectiveDetails.setProcessRequestInfo(processRequestInfo);
		assertEquals("Bus", defectiveDetails.getProcessRequestInfo().get(0).getDefectiveComponentInfo().getComponentName());
		
		
		
	}

}
