package com.dop.cms.client;


import java.util.List;

import com.dop.cms.PatWs.PatientServiceStub;
import com.dop.cms.PatWs.PatientServiceStub.DocNamesBySpec;
import com.dop.cms.PatWs.PatientServiceStub.PatientApptDetails;
import com.dop.cms.PatWs.PatientServiceStub.PatientDetails;
import com.dop.cms.utilities.WSCallURL;

public class PatientAppoint {
	
	public PatientAppoint(){
		
	}
	
	String[] specialization = null ;
	List<String> timings = null;

	public PatientApptDetails[] getPatApptDet(int patId){
		PatientApptDetails patApptDetArray[] = new PatientApptDetails[]{};
		try{
			String endpoint = WSCallURL.PATIENTMODULE;
			PatientServiceStub proxy = new PatientServiceStub(endpoint);
			PatientServiceStub.GetPatientApptDetE spec = new PatientServiceStub.GetPatientApptDetE();
			PatientServiceStub.GetPatientApptDetResponseE resp = new PatientServiceStub.GetPatientApptDetResponseE();
			PatientServiceStub.GetPatientApptDet in = new PatientServiceStub.GetPatientApptDet();
			in.setArg0(patId);
			spec.setGetPatientApptDet(in);
			resp = proxy.getPatientApptDet(spec);
			patApptDetArray = resp.getGetPatientApptDetResponse().get_return();
		}catch (Exception e) {
			System.out.println(e.toString());
		}
		return patApptDetArray;
	}
	 
	public String[] getspecialization(){
		//String[] specialization = new String[]{} ;
		try{
			String endpoint = WSCallURL.PATIENTMODULE;
			PatientServiceStub proxy = new PatientServiceStub(endpoint);
			PatientServiceStub.GetSpecializationE spec = new PatientServiceStub.GetSpecializationE();
			PatientServiceStub.GetSpecializationResponseE resp = new PatientServiceStub.GetSpecializationResponseE();
			PatientServiceStub.GetSpecialization in = new PatientServiceStub.GetSpecialization();
			spec.setGetSpecialization(in);
			resp = proxy.getSpecialization(spec);
			specialization = resp.getGetSpecializationResponse().get_return();
		}catch (Exception e) {
			System.out.println(e.toString());
		}
		return specialization;
			
	}
	
	public DocNamesBySpec[] getdocNames(String speclize){
		DocNamesBySpec docNames[] = new DocNamesBySpec[]{};
		try{
			String endpoint = WSCallURL.PATIENTMODULE;
			PatientServiceStub proxy = new PatientServiceStub(endpoint);
			PatientServiceStub.GetDocBySpecE spec = new PatientServiceStub.GetDocBySpecE();
			PatientServiceStub.GetDocBySpecResponseE resp = new PatientServiceStub.GetDocBySpecResponseE();
			PatientServiceStub.GetDocBySpec in = new PatientServiceStub.GetDocBySpec();
			in.setArg0(speclize);
			spec.setGetDocBySpec(in);
			resp = proxy.getDocBySpec(spec);
			docNames = resp.getGetDocBySpecResponse().get_return();
		}catch (Exception e) {
			System.out.println(e.toString());
		}
		return docNames;
	}
	
	public String[] gettimings(String docId){
		String[] timings = null;
		String apptTimings = "";
		try{
			String endpoint = WSCallURL.PATIENTMODULE;
			PatientServiceStub proxy = new PatientServiceStub(endpoint);
			PatientServiceStub.GetApptTimeOfDocE spec = new PatientServiceStub.GetApptTimeOfDocE();
			PatientServiceStub.GetApptTimeOfDocResponseE resp = new PatientServiceStub.GetApptTimeOfDocResponseE();
			PatientServiceStub.GetApptTimeOfDoc in = new PatientServiceStub.GetApptTimeOfDoc();
			in.setArg0(Integer.parseInt(docId));
			spec.setGetApptTimeOfDoc(in);
			resp = proxy.getApptTimeOfDoc(spec);
			apptTimings = resp.getGetApptTimeOfDocResponse().get_return();
		}catch (Exception e) {
			System.out.println(e.toString());
		}
			timings = apptTimings.split(";");
			return timings;
	}
	
	public PatientDetails getPatDetails(int patId){
		PatientDetails patDet = new PatientDetails();
		try{
			String endpoint = WSCallURL.PATIENTMODULE;
			PatientServiceStub proxy = new PatientServiceStub(endpoint);
			PatientServiceStub.GetPatDetailsE spec = new PatientServiceStub.GetPatDetailsE();
			PatientServiceStub.GetPatDetailsResponseE resp = new PatientServiceStub.GetPatDetailsResponseE();
			PatientServiceStub.GetPatDetails in = new PatientServiceStub.GetPatDetails();
			in.setArg0(patId);
			spec.setGetPatDetails(in);
			resp = proxy.getPatDetails(spec);
			patDet = resp.getGetPatDetailsResponse().get_return();
			return patDet;
		}catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	
	public boolean updatePatDetails(String patId,String patName,String patAddress,String patEmail,String patPhone){
		try{
			String endpoint = WSCallURL.PATIENTMODULE;
			PatientServiceStub proxy = new PatientServiceStub(endpoint);
			PatientServiceStub.UpdPatDetailsE spec = new PatientServiceStub.UpdPatDetailsE();
			PatientServiceStub.UpdPatDetailsResponseE resp = new PatientServiceStub.UpdPatDetailsResponseE();
			PatientServiceStub.UpdPatDetails in = new PatientServiceStub.UpdPatDetails();
			in.setArg0(Integer.parseInt(patId));
			in.setArg1(patName);
			in.setArg2(patAddress);
			in.setArg3(patEmail);
			in.setArg4(patPhone);
			spec.setUpdPatDetails(in);;
			resp = proxy.updPatDetails(spec);
			boolean update = resp.getUpdPatDetailsResponse().get_return();
			return update;
		}catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}
	
//	public static void main(String[] args){
//		PatientAppoint pa = new PatientAppoint();
//		PatientDetails ex;
//		System.out.println("Hello");
//		ex = pa.getPatDetails("2000");
//		System.out.println(ex.getPatEmail());
//	}
	
	
//	public static void main(String[] args){
//		PatientAppoint pa = new PatientAppoint();
//		PatientApptDetails[] ex;
//		System.out.println("Hello");
//		ex = pa.getPatApptDet(2000);
//		System.out.println(ex.length);
//	}

//	
//	public static void main(String[] args){
//		PatientAppoint pa = new PatientAppoint();
//		DocNamesBySpec[] ex = new DocNamesBySpec[]{};
//		System.out.println("Hello");
//		ex = pa.getdocNames("Dermatologist");
//		System.out.println(ex.length);
//	}
//	public static void main(String[] args){
//		PatientAppoint pa = new PatientAppoint();
//		HashMap<Integer, String> map = new HashMap<Integer,String>();
//		map = pa.getdocNames();
//		/**
//		 * get the Set Of keys from HashMap
//		 */
//		 Set setOfKeys = map.keySet();
//		 
//		/**
//		 * get the Iterator instance from Set
//		 */
//		 Iterator iterator = setOfKeys.iterator();
//		 
//		/**
//		 * Loop the iterator until we reach the last element of the HashMap
//		 */
//		while (iterator.hasNext()) {
//		/**
//		 * next() method returns the next key from Iterator instance.
//		 * return type of next() method is Object so we need to do DownCasting to String
//		 */
//		int key = (int) iterator.next();
//		 
//		/**
//		 * once we know the 'key', we can get the value from the HashMap
//		 * by calling get() method
//		 */
//		 String value = (String)map.get(key);
//		 
//		System.out.println("Key: "+ key+", Value: "+ value);
//		 
//		 }
//		
//	}
	
		
	}
