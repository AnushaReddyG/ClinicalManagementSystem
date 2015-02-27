package com.dop.cms.test.doctor;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.dop.cms.client.DocPatAppoint;

public class DoctorTest {

	public DoctorTest() {
		
	}
	
	@Test
	public void testGetAcceptAppoints(){
		DocPatAppoint docpatAppt = new DocPatAppoint();
		assertEquals("Length of the list",4,docpatAppt.getAcceptedAppoints(1001).length);
	}
	
	@Test
	public void testUpdDocPatAppt(){
		DocPatAppoint docpatAppt = new DocPatAppoint();
		boolean updStat = true;
		assertEquals("Appointment Status",updStat,docpatAppt.updDocPatAppt("Reject", 100010));
	}
	
	@Test
	public void testGetlabAssistDet(){
		DocPatAppoint docpatAppt = new DocPatAppoint();
		assertEquals("Length of the list",100,docpatAppt.getLabAssistDet().size());
	}
	
	@Test
	public void testGetpendAppts(){
		DocPatAppoint docpatAppt = new DocPatAppoint();
		assertEquals("Length of the list",1,docpatAppt.getPendingAppoints(1001).length);
	}
	
	@Test
	public void testUpdDocDiagnosis(){
		DocPatAppoint docpatAppt = new DocPatAppoint();
		boolean status= true;
		assertEquals("Update Status",status,docpatAppt.updDocDiagnosis(100001, 3000, 2000));
	}
	
	@Test
	public void testUpdDocPrescrip(){
		DocPatAppoint docpatAppt = new DocPatAppoint();
		boolean status= true;
		assertEquals("Update Status",status,docpatAppt.updDocPrescrip(100001, "Crocin", "Normal Fever"));
	}

}
