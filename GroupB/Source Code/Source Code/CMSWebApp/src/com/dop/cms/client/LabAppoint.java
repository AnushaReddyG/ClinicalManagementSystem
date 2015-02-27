package com.dop.cms.client;


import java.util.List;

import com.dop.cms.LabServiceStub;
import com.dop.cms.LabServiceStub.ListPatients;
import com.dop.cms.utilities.WSCallURL;

public class LabAppoint {

	public LabAppoint(){

	}

	String[] specialization = null ;
	List<String> timings = null;


	public ListPatients[] getLabApptDet(int labId){
		ListPatients listPatients[] = new ListPatients[]{};
		try{
			String endpoint = WSCallURL.LABASSISTMODULE;
			LabServiceStub proxy = new LabServiceStub(endpoint);
			LabServiceStub.GetDetailsE spec = new LabServiceStub.GetDetailsE();
			LabServiceStub.GetDetailsResponseE resp = new LabServiceStub.GetDetailsResponseE();
			LabServiceStub.GetDetails in = new LabServiceStub.GetDetails();
			in.setArg0(Integer.toString(labId));
			spec.setGetDetails(in);
			resp = proxy.getDetails(spec);
			listPatients = resp.getGetDetailsResponse().get_return();
		}catch (Exception e) {
			System.out.println(e.toString());
		}
		return listPatients;
	}
	
	
	public String submitReport(String asst_name, int doc_id, int pat_id, String test_type, String result) {
		String returnResult = null;
		try{
			String endpoint = WSCallURL.LABASSISTMODULE;
			LabServiceStub proxy = new LabServiceStub(endpoint);
			LabServiceStub.SubmitReportE spec = new LabServiceStub.SubmitReportE();
			LabServiceStub.SubmitReportResponseE resp = new LabServiceStub.SubmitReportResponseE();
			LabServiceStub.SubmitReport in = new LabServiceStub.SubmitReport();
			in.setArg0(asst_name);
			in.setArg1(doc_id);
			in.setArg2(pat_id);
			in.setArg3(test_type);
			in.setArg4(result);
			spec.setSubmitReport(in);
			resp = proxy.submitReport(spec);
			returnResult = resp.getSubmitReportResponse().get_return();
		}catch (Exception e) {
			System.out.println(e.toString());
		}
		return returnResult;
	}





}
