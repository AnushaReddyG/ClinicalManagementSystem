package com.dop.cms;
import javax.jws.WebService;

import com.dop.dataHolder.ListPatients;

@WebService
public interface LabService {
	
	/*
	 * Updates lab report in the 'LabDocPat' table
	 * */
	public String submitReport(String asst_name, int doc_id, int pat_id, String test_type, String result);
	public ListPatients[] getDetails(String lab_id);
	
	
}
