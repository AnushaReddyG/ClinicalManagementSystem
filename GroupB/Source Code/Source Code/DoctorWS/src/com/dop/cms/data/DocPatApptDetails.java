package com.dop.cms.data;

public class DocPatApptDetails {

	String apptdate;
	String apptTime;
	int severity;
	int patId;
	int docId;
	String docName;
	String patname;
	int apptId;
	String apptStatus;
	
	public DocPatApptDetails() {
		super();
	}
	
	public DocPatApptDetails(String apptdate, String apptTime, int severity,
			int patId, int docId, String docName, String patname, int apptId,
			String apptStatus) {
		super();
		this.apptdate = apptdate;
		this.apptTime = apptTime;
		this.severity = severity;
		this.patId = patId;
		this.docId = docId;
		this.docName = docName;
		this.patname = patname;
		this.apptId = apptId;
		this.apptStatus = apptStatus;
	}

	/**
	 * @return the apptdate
	 */
	public String getApptdate() {
		return apptdate;
	}

	/**
	 * @param apptdate the apptdate to set
	 */
	public void setApptdate(String apptdate) {
		this.apptdate = apptdate;
	}

	/**
	 * @return the apptTime
	 */
	public String getApptTime() {
		return apptTime;
	}

	/**
	 * @param apptTime the apptTime to set
	 */
	public void setApptTime(String apptTime) {
		this.apptTime = apptTime;
	}

	/**
	 * @return the severity
	 */
	public int getSeverity() {
		return severity;
	}

	/**
	 * @param severity the severity to set
	 */
	public void setSeverity(int severity) {
		this.severity = severity;
	}

	/**
	 * @return the patId
	 */
	public int getPatId() {
		return patId;
	}

	/**
	 * @param patId the patId to set
	 */
	public void setPatId(int patId) {
		this.patId = patId;
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
	 * @return the patname
	 */
	public String getPatname() {
		return patname;
	}

	/**
	 * @param patname the patname to set
	 */
	public void setPatname(String patname) {
		this.patname = patname;
	}

	/**
	 * @return the apptId
	 */
	public int getApptId() {
		return apptId;
	}

	/**
	 * @param apptId the apptId to set
	 */
	public void setApptId(int apptId) {
		this.apptId = apptId;
	}

	/**
	 * @return the apptStatus
	 */
	public String getApptStatus() {
		return apptStatus;
	}

	/**
	 * @param apptStatus the apptStatus to set
	 */
	public void setApptStatus(String apptStatus) {
		this.apptStatus = apptStatus;
	}
	
	

}
