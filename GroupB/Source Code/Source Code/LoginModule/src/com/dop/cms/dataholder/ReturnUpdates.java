package com.dop.cms.dataholder;

public class ReturnUpdates {

	/*Return return Code 0: no error 1: error*/
	private int returnCode;
	/*Error Decription*/
	private String returnType;
	/**
	 * @return the returnCode
	 */
	public int getReturnCode() {
		return returnCode;
	}
	/**
	 * @param returnCode the returnCode to set
	 */
	public void setReturnCode(int returnCode) {
		this.returnCode = returnCode;
	}
	/**
	 * @return the returnType
	 */
	public String getReturnType() {
		return returnType;
	}
	/**
	 * @param returnType the returnType to set
	 */
	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}
	
	
}
