package com.dop.cms.test.patient;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.dop.cms.PatWs.PatientServiceStub.PatientApptDetails;
import com.dop.cms.client.DoctorAvailability;
import com.dop.cms.client.PatientAppoint;

public class PatientTest {

	public PatientTest() {
	}
	
	@Test
	public void testGetPatApptDet(){
		PatientAppoint patAppt = new PatientAppoint();
		PatientApptDetails patApptDetArray[] = new PatientApptDetails[]{};
		patApptDetArray = patAppt.getPatApptDet(2000);
		assertEquals("Length of the array",6,patApptDetArray.length);
	}

	@Test
	public void testGetSpec(){
		PatientAppoint patAppt = new PatientAppoint();
		assertEquals("Length of the list",50,patAppt.getspecialization().length);
	}
	
	@Test
	public void testGetDocNames(){
		PatientAppoint patAppt = new PatientAppoint();
		assertEquals("Length of the array",203,patAppt.getdocNames("Allergist").length);
	}
	
	@Test
	public void testGetTimings(){
		PatientAppoint patAppt = new PatientAppoint();
		assertEquals("Length of the array",48,patAppt.gettimings("1001").length);
	}
	
	@Test
	public void testGetPatDet(){
		PatientAppoint patAppt = new PatientAppoint();
		assertEquals("Name of the Patient","Hop",patAppt.getPatDetails(2001).getPatName());
	}
	
	@Test
	public void testDocAvail(){
		DoctorAvailability docAv = new DoctorAvailability();
		boolean ans = false;
		assertEquals("Doctor availability",ans,docAv.docAvailability(1000, "12/25/2015", "01:00-01:30"));
		
	}
	
}
