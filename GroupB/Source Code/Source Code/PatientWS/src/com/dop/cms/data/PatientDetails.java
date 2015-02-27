package com.dop.cms.data;

public class PatientDetails {

	int patId;
	String patName;
	String patAddress;
	String patEmail;
	String patPhone;
	public PatientDetails(int patId, String patName, String patAddress,
			String patEmail, String patPhone) {
		super();
		this.patId = patId;
		this.patName = patName;
		this.patAddress = patAddress;
		this.patEmail = patEmail;
		this.patPhone = patPhone;
	}
	public PatientDetails() {
		super();
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
	 * @return the patName
	 */
	public String getPatName() {
		return patName;
	}
	/**
	 * @param patName the patName to set
	 */
	public void setPatName(String patName) {
		this.patName = patName;
	}
	/**
	 * @return the patAddress
	 */
	public String getPatAddress() {
		return patAddress;
	}
	/**
	 * @param patAddress the patAddress to set
	 */
	public void setPatAddress(String patAddress) {
		this.patAddress = patAddress;
	}
	/**
	 * @return the patEmail
	 */
	public String getPatEmail() {
		return patEmail;
	}
	/**
	 * @param patEmail the patEmail to set
	 */
	public void setPatEmail(String patEmail) {
		this.patEmail = patEmail;
	}
	/**
	 * @return the patPhone
	 */
	public String getPatPhone() {
		return patPhone;
	}
	/**
	 * @param patPhone the patPhone to set
	 */
	public void setPatPhone(String patPhone) {
		this.patPhone = patPhone;
	}
}
