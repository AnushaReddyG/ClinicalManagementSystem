package com.dop.cms.PatWs.dataHolders;

public class Report {
	
	private String reportId;
	private String test_type;
	private String decription;
	private double cost;
	/**
	 * @return the reportId
	 */
	public String getReportId() {
		return reportId;
	}
	/**
	 * @param reportId the reportId to set
	 */
	public void setReportId(String reportId) {
		this.reportId = reportId;
	}
	/**
	 * @return the test_type
	 */
	public String getTest_type() {
		return test_type;
	}
	/**
	 * @param test_type the test_type to set
	 */
	public void setTest_type(String test_type) {
		this.test_type = test_type;
	}
	/**
	 * @return the decription
	 */
	public String getDecription() {
		return decription;
	}
	/**
	 * @param decription the decription to set
	 */
	public void setDecription(String decription) {
		this.decription = decription;
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
