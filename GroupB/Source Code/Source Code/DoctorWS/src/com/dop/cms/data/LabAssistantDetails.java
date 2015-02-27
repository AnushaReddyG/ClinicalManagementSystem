package com.dop.cms.data;

public class LabAssistantDetails {

	public LabAssistantDetails() {
	}
	
	int assistantId;
	String assistantName;
	String assistantPhone;
	String assistantEmail;
	public LabAssistantDetails(int assistantId, String assistantName,
			String assistantPhone, String assistantEmail) {
		super();
		this.assistantId = assistantId;
		this.assistantName = assistantName;
		this.assistantPhone = assistantPhone;
		this.assistantEmail = assistantEmail;
	}
	/**
	 * @return the assistantId
	 */
	public int getAssistantId() {
		return assistantId;
	}
	/**
	 * @param assistantId the assistantId to set
	 */
	public void setAssistantId(int assistantId) {
		this.assistantId = assistantId;
	}
	/**
	 * @return the assistantName
	 */
	public String getAssistantName() {
		return assistantName;
	}
	/**
	 * @param assistantName the assistantName to set
	 */
	public void setAssistantName(String assistantName) {
		this.assistantName = assistantName;
	}
	/**
	 * @return the assistantPhone
	 */
	public String getAssistantPhone() {
		return assistantPhone;
	}
	/**
	 * @param assistantPhone the assistantPhone to set
	 */
	public void setAssistantPhone(String assistantPhone) {
		this.assistantPhone = assistantPhone;
	}
	/**
	 * @return the assistantEmail
	 */
	public String getAssistantEmail() {
		return assistantEmail;
	}
	/**
	 * @param assistantEmail the assistantEmail to set
	 */
	public void setAssistantEmail(String assistantEmail) {
		this.assistantEmail = assistantEmail;
	}

}
