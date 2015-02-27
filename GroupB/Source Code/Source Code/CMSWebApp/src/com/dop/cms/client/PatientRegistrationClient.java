package com.dop.cms.client;

import com.dop.cms.LoginServiceStub;

public class PatientRegistrationClient {
	public static void main(String[] args) { 
		try {
			String endpoint = "http://localhost:1000/LoginModule/LoginService";
			LoginServiceStub proxy = new LoginServiceStub(endpoint);
			LoginServiceStub.RegisterPatientE inc = new LoginServiceStub.RegisterPatientE();
			LoginServiceStub.RegisterPatientResponseE resp = new LoginServiceStub.RegisterPatientResponseE();
			LoginServiceStub.RegisterPatient in= new LoginServiceStub.RegisterPatient();
			

			
			in.setArg0("Ipsit");//firstName
			in.setArg1("Patra");//lastName
			in.setArg2("1434 W Taylor Street");//address
			in.setArg3("WKE3ME");//insurance - optional
			in.setArg4("ipsit.patra@gmail.com");//email
			in.setArg5("650-2384721");//phone
			
			
			inc.setRegisterPatient(in);

			resp = proxy.registerPatient(inc);
//			LoginReturn a=resp.getRegisterPatientResponse().get_return();			
//			System.out.println("Return: " + a);
		}
		catch (Exception e) {
			System.out.println(e.toString());
		}
	
	}
}
