package com.dop.cms.test.Lab;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

import com.dop.cms.client.LabAppoint;
import com.dop.cms.client.LabReportUpdate;

public class LabTest {

	public LabTest() {
		
	}
	
	@Test
	public void testGetDet(){
		LabAppoint labApp = new LabAppoint();
		assertEquals("Length of the list",1,labApp.getLabApptDet(2000).length);
	}
	
	@Test
	public void testLabRec(){
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(5001, "Present");
		assertEquals("If the lab id is present", "Present",map.get(5001));
	}
	
	@Test
	public void getLabDet(){
		List<String> list = Arrays.asList("Lab1", "lab2", "Lab3", "Lab4", "Lab5");
		assertEquals("List Size",5,list.size());
	}
	
	@Test
	public void testLabReportUpdate(){
		LabReportUpdate lru = new LabReportUpdate();
		boolean status = false;
		assertEquals("Update diagnosis",status,lru.labReportUpdate(100001, 2000, 1000, 5000, "9009", "negative"));
	}

}
