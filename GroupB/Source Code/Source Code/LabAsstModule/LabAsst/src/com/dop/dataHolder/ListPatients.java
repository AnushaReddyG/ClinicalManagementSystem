package com.dop.dataHolder;

public class ListPatients {
	
	private String docId;
	private String TestType;
	private String patientId;
	private String Appointment;
	
	/**
	 * @return the appointment
	 */
	public String getAppointment() {
		return Appointment;
	}
	/**
	 * @param appointment the appointment to set
	 */
	public void setAppointment(String appointment) {
		Appointment = appointment;
	}
	/**
	 * @return the docId
	 */
	public String getDocId() {
		return docId;
	}
	/**
	 * @param docId the docId to set
	 */
	public void setDocId(String docId) {
		this.docId = docId;
	}
	/**
	 * @return the testType
	 */
	public String getTestType() {
		return TestType;
	}
	/**
	 * @param testType the testType to set
	 */
	public void setTestType(String testType) {
		TestType = testType;
	}
	/**
	 * @return the patientId
	 */
	public String getPatientId() {
		return patientId;
	}
	/**
	 * @param patientId the patientId to set
	 */
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	
	
	
	

}
