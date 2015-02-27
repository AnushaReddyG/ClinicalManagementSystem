package com.dop.cms.DocWs;

import javax.jws.WebService;

import com.dop.cms.data.DocPatApptDetails;
import com.dop.cms.data.LabAssistantDetails;

@WebService
public interface DoctorService {

	DocPatApptDetails[] getAcceptedAppts(int docId);
	boolean updDocPatAppt(String status, int appointId);
	DocPatApptDetails[] getPendingAppts(int docId);
	LabAssistantDetails[] getLabAssistDet();
	boolean updtDiagnosisFromDoc(int apptId,int testId, int labId);
	boolean updtPrescriptionFromDoc(int apptId,String med,String notes);
}
