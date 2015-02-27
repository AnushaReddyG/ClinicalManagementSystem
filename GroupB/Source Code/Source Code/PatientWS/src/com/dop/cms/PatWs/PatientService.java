package com.dop.cms.PatWs;


import java.util.List;
import javax.jws.WebService;

import com.dop.cms.PatWs.dataHolders.Bill;
import com.dop.cms.data.DocNamesBySpec;
import com.dop.cms.data.PatientApptDetails;
import com.dop.cms.data.PatientDetails;

@WebService
public interface PatientService {
	List<String> getSpecialization();
	DocNamesBySpec[] getDocBySpec(String spec);
	PatientApptDetails[] getPatientApptDet(int patId);
	String getApptTimeOfDoc(int docId);
	boolean getDocAvailability(int docID, String date , String time);
	boolean updateApptDet(int docID,int patId,String date,String time,String severity);
	PatientDetails getPatDetails(int patId);
	boolean updPatDetails(int patId,String patName,String patAddress,String patEmail,String patPhone);
	Bill requestBill(String patient_id, String case_id);
}
