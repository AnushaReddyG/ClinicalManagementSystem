package com.dop.cms.PatWs.dataHolders;

public class Doctor {

	
	private int doctorID;
	private String doctorName;
	private int caseId;
	private String diagnosis;
	private double cost;
	/**
	 * @return the doctorID
	 */
	public int getDoctorID() {
		return doctorID;
	}
	/**
	 * @param doctorID the doctorID to set
	 */
	public void setDoctorID(int doctorID) {
		this.doctorID = doctorID;
	}
	/**
	 * @return the doctorName
	 */
	public String getDoctorName() {
		return doctorName;
	}
	/**
	 * @param doctorName the doctorName to set
	 */
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	/**
	 * @return the caseId
	 */
	public int getCaseId() {
		return caseId;
	}
	/**
	 * @param caseId the caseId to set
	 */
	public void setCaseId(int caseId) {
		this.caseId = caseId;
	}
	/**
	 * @return the diagnosis
	 */
	public String getDiagnosis() {
		return diagnosis;
	}
	/**
	 * @param diagnosis the diagnosis to set
	 */
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	/**
	 * @return the cost
	 */
	public double getCost() {
		return cost;
	}
	/**
	 * @param cost the cost to set
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	
	
}
