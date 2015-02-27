package com.dop.cms.PatWs.dataHolders;


public class Bill {
	
	private Medicine[] medicine;
	private Report report;
	private Doctor doctor;
	/**
	 * @return the medicine
	 */
	public Medicine[] getMedicine() {
		return medicine;
	}
	/**
	 * @param medicine the medicine to set
	 */
	public void setMedicine(Medicine[] medicine) {
		this.medicine = medicine;
	}
	/**
	 * @return the report
	 */
	public Report getReport() {
		return report;
	}
	/**
	 * @param report the report to set
	 */
	public void setReport(Report report) {
		this.report = report;
	}
	/**
	 * @return the doctor
	 */
	public Doctor getDoctor() {
		return doctor;
	}
	/**
	 * @param doctor the doctor to set
	 */
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	
	
}
