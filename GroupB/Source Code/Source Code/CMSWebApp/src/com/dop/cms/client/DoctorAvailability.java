package com.dop.cms.client;

import com.dop.cms.PatWs.PatientServiceStub;
import com.dop.cms.utilities.WSCallURL;

public class DoctorAvailability {
	
	public boolean docAvailability(int docID, String date , String time){
		try{
			String endpoint = WSCallURL.PATIENTMODULE;
			PatientServiceStub proxy = new PatientServiceStub(endpoint);
			PatientServiceStub.GetDocAvailabilityE spec = new PatientServiceStub.GetDocAvailabilityE();
			PatientServiceStub.GetDocAvailabilityResponseE resp = new PatientServiceStub.GetDocAvailabilityResponseE();
			PatientServiceStub.GetDocAvailability in = new PatientServiceStub.GetDocAvailability();
			in.setArg0(docID);
			in.setArg1(date);
			in.setArg2(time);
			spec.setGetDocAvailability(in);
			resp = proxy.getDocAvailability(spec);
			boolean isAvailable = resp.getGetDocAvailabilityResponse().get_return();
			return isAvailable;
		}catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}
	
	public boolean updateAppoint(int docID,int patID,String date,String time,String severity){
		try{
			String endpoint = WSCallURL.PATIENTMODULE;
			PatientServiceStub proxy = new PatientServiceStub(endpoint);
			PatientServiceStub.UpdateApptDetE spec = new PatientServiceStub.UpdateApptDetE();
			PatientServiceStub.UpdateApptDetResponseE resp = new PatientServiceStub.UpdateApptDetResponseE();
			PatientServiceStub.UpdateApptDet in = new PatientServiceStub.UpdateApptDet();
			in.setArg0(docID);
			in.setArg1(patID);
			in.setArg2(date);
			in.setArg3(time);
			in.setArg4(severity);
			spec.setUpdateApptDet(in);
			resp = proxy.updateApptDet(spec);
			boolean isAvailable = resp.getUpdateApptDetResponse().get_return();
			return isAvailable;
		}catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}
		
	//	public static void main(String[] args){
	//		DoctorAvailability da = new DoctorAvailability();
	//		boolean b = da.updateAppoint(1000, "08/24/2014", "1", "1");
	//		System.out.println(b);
	//	}
	}