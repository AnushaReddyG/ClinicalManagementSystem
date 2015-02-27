package com.dop.cms.dataholder;

public class LoginReturn {

	
	private ReturnUpdates returnUpdates;
	private int loginType;
	private int LoginId;
	
	
	/**
	 * @return the returnUpdates
	 */
	public ReturnUpdates getReturnUpdates() {
		return returnUpdates;
	}
	/**
	 * @param returnUpdates the returnUpdates to set
	 */
	public void setReturnUpdates(ReturnUpdates returnUpdates) {
		this.returnUpdates = returnUpdates;
	}
	/**
	 * @return the loginType
	 */
	public int getLoginType() {
		return loginType;
	}
	/**
	 * @param loginType the loginType to set
	 */
	public void setLoginType(int loginType) {
		this.loginType = loginType;
	}
	/**
	 * @return the loginId
	 */
	public int getLoginId() {
		return LoginId;
	}
	/**
	 * @param loginId the loginId to set
	 */
	public void setLoginId(int loginId) {
		LoginId = loginId;
	}
	
	
	
	
}
