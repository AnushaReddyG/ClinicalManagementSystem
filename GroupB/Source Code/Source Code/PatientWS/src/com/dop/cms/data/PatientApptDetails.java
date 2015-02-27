package com.dop.cms.data;

public class PatientApptDetails {
	
	int docId;
	String docName;
	String appointDate;
	String appointTime;
	String severity;
	String patientId;
	
	public PatientApptDetails() {
		super();
	}

	public PatientApptDetails(int docId, String docName, String appointDate,
			String appointTime, String severity, String patientId) {
		super();
		this.docId = docId;
		this.docName = docName;
		this.appointDate = appointDate;
		this.appointTime = appointTime;
		this.severity = severity;
		this.patientId = patientId;
	}

	/**
	 * @return the docId
	 */
	public int getDocId() {
		return docId;
	}

	/**
	 * @param docId the docId to set
	 */
	public void setDocId(int docId) {
		this.docId = docId;
	}

	/**
	 * @return the docName
	 */
	public String getDocName() {
		return docName;
	}

	/**
	 * @param docName the docName to set
	 */
	public void setDocName(String docName) {
		this.docName = docName;
	}

	/**
	 * @return the appointDate
	 */
	public String getAppointDate() {
		return appointDate;
	}

	/**
	 * @param appointDate the appointDate to set
	 */
	public void setAppointDate(String appointDate) {
		this.appointDate = appointDate;
	}

	/**
	 * @return the appointTime
	 */
	public String getAppointTime() {
		return appointTime;
	}

	/**
	 * @param appointTime the appointTime to set
	 */
	public void setAppointTime(String appointTime) {
		this.appointTime = appointTime;
	}

	/**
	 * @return the severity
	 */
	public String getSeverity() {
		return severity;
	}

	/**
	 * @param severity the severity to set
	 */
	public void setSeverity(String severity) {
		this.severity = severity;
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
