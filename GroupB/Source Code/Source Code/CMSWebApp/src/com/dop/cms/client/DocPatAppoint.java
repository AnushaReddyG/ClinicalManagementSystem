package com.dop.cms.client;

import java.util.HashMap;

import com.dop.cms.DocWs.DoctorServiceStub;
import com.dop.cms.DocWs.DoctorServiceStub.DocPatApptDetails;
import com.dop.cms.DocWs.DoctorServiceStub.LabAssistantDetails;
import com.dop.cms.utilities.WSCallURL;

public class DocPatAppoint {

	public DocPatAppoint() {
		super();
	}

	public DocPatApptDetails[] getAcceptedAppoints(int docId){
		DocPatApptDetails docPatApptDetArray[] = new DocPatApptDetails[]{};
		try{
			String endpoint = WSCallURL.DOCTORMODULE;
			DoctorServiceStub proxy = new DoctorServiceStub(endpoint);
			DoctorServiceStub.GetAcceptedApptsE spec = new DoctorServiceStub.GetAcceptedApptsE();
			DoctorServiceStub.GetAcceptedApptsResponseE resp = new DoctorServiceStub.GetAcceptedApptsResponseE();
			DoctorServiceStub.GetAcceptedAppts in = new DoctorServiceStub.GetAcceptedAppts();
			in.setArg0(docId);
			spec.setGetAcceptedAppts(in);
			resp = proxy.getAcceptedAppts(spec);
			docPatApptDetArray = resp.getGetAcceptedApptsResponse().get_return();
		}catch (Exception e) {
			System.out.println(e.toString());
		}
		return docPatApptDetArray;
	}
	
	public HashMap<Integer, String> getLabAssistDet(){
		LabAssistantDetails labAssistantDetArray[] = new LabAssistantDetails[]{};
		try{
			String endpoint = WSCallURL.DOCTORMODULE;
			DoctorServiceStub proxy = new DoctorServiceStub(endpoint);
			DoctorServiceStub.GetLabAssistDetE spec = new DoctorServiceStub.GetLabAssistDetE();
			DoctorServiceStub.GetLabAssistDetResponseE resp = new DoctorServiceStub.GetLabAssistDetResponseE();
			DoctorServiceStub.GetLabAssistDet in = new DoctorServiceStub.GetLabAssistDet();
			spec.setGetLabAssistDet(in);
			resp = proxy.getLabAssistDet(spec);
			labAssistantDetArray = resp.getGetLabAssistDetResponse().get_return();
		}catch (Exception e) {
			System.out.println(e.toString());
		}
		HashMap<Integer, String> labAssistNames = new HashMap<Integer, String>();
		for(int i =0;i<labAssistantDetArray.length;i++){
			labAssistNames.put(labAssistantDetArray[i].getAssistantId(), labAssistantDetArray[i].getAssistantName());
		}
		return labAssistNames;
	}
	
	public DocPatApptDetails[] getPendingAppoints(int docId){
		DocPatApptDetails docPatApptDetArray[] = new DocPatApptDetails[]{};
		try{
			String endpoint = WSCallURL.DOCTORMODULE;
			DoctorServiceStub proxy = new DoctorServiceStub(endpoint);
			DoctorServiceStub.GetPendingApptsE spec = new DoctorServiceStub.GetPendingApptsE();
			DoctorServiceStub.GetPendingApptsResponseE resp = new DoctorServiceStub.GetPendingApptsResponseE();
			DoctorServiceStub.GetPendingAppts in = new DoctorServiceStub.GetPendingAppts();
			in.setArg0(docId);
			spec.setGetPendingAppts(in);
			resp = proxy.getPendingAppts(spec);
			docPatApptDetArray = resp.getGetPendingApptsResponse().get_return();
		}catch (Exception e) {
			System.out.println(e.toString());
		}
		return docPatApptDetArray;
	}
	
	public boolean updDocPatAppt(String status, int appointId){
		boolean updateStatus;
		try{
			String endpoint = WSCallURL.DOCTORMODULE;
			DoctorServiceStub proxy = new DoctorServiceStub(endpoint);
			DoctorServiceStub.UpdDocPatApptE spec = new DoctorServiceStub.UpdDocPatApptE();
			DoctorServiceStub.UpdDocPatApptResponseE resp = new DoctorServiceStub.UpdDocPatApptResponseE();
			DoctorServiceStub.UpdDocPatAppt in = new DoctorServiceStub.UpdDocPatAppt();
			in.setArg0(status);
			in.setArg1(appointId);
			spec.setUpdDocPatAppt(in);
			resp = proxy.updDocPatAppt(spec);
			updateStatus = resp.getUpdDocPatApptResponse().get_return();
			return updateStatus;
		}catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}
	
	public boolean updDocDiagnosis(int apptId, int labId, int testId){
		boolean updateDiagnosisStatus;
		try{
			String endpoint = WSCallURL.DOCTORMODULE;
			DoctorServiceStub proxy = new DoctorServiceStub(endpoint);
			DoctorServiceStub.UpdtDiagnosisFromDocE spec = new DoctorServiceStub.UpdtDiagnosisFromDocE();
			DoctorServiceStub.UpdtDiagnosisFromDocResponseE resp = new DoctorServiceStub.UpdtDiagnosisFromDocResponseE();
			DoctorServiceStub.UpdtDiagnosisFromDoc in = new DoctorServiceStub.UpdtDiagnosisFromDoc();
			in.setArg0(apptId);
			in.setArg1(testId);
			in.setArg2(labId);
			spec.setUpdtDiagnosisFromDoc(in);
			resp = proxy.updtDiagnosisFromDoc(spec);
			updateDiagnosisStatus = resp.getUpdtDiagnosisFromDocResponse().get_return();
			return updateDiagnosisStatus;
		}catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}
	
	public boolean updDocPrescrip(int apptId, String med, String notes){
		boolean updatePrescripStatus;
		try{
			String endpoint = WSCallURL.DOCTORMODULE;
			DoctorServiceStub proxy = new DoctorServiceStub(endpoint);
			DoctorServiceStub.UpdtPrescriptionFromDocE spec = new DoctorServiceStub.UpdtPrescriptionFromDocE();
			DoctorServiceStub.UpdtPrescriptionFromDocResponseE resp = new DoctorServiceStub.UpdtPrescriptionFromDocResponseE();
			DoctorServiceStub.UpdtPrescriptionFromDoc in = new DoctorServiceStub.UpdtPrescriptionFromDoc();
			in.setArg0(apptId);
			in.setArg1(med);
			in.setArg2(notes);
			spec.setUpdtPrescriptionFromDoc(in);
			resp = proxy.updtPrescriptionFromDoc(spec);
			updatePrescripStatus = resp.getUpdtPrescriptionFromDocResponse().get_return();
			return updatePrescripStatus;
		}catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}
//	public static void main(String[] args){
//		HashMap<Integer,String> labAssistNames = new HashMap<Integer,String>();
//		DocPatAppoint d = new DocPatAppoint();
//		labAssistNames = d.getLabAssistDet();
//		System.out.println(labAssistNames.size());
//	}
}
