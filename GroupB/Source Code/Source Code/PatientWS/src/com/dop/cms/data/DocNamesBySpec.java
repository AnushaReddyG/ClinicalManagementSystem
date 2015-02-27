package com.dop.cms.data;

public class DocNamesBySpec {
	
	int docId;
	String docName;
	public DocNamesBySpec(int docId, String docName) {
		super();
		this.docId = docId;
		this.docName = docName;
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
	public DocNamesBySpec() {
		super();
		// TODO Auto-generated constructor stub
	}

}