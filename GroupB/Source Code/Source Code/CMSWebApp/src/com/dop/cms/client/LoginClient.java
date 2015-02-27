package com.dop.cms.client;

import java.io.UnsupportedEncodingException;

import com.dop.cms.LoginServiceStub;
import com.dop.cms.LoginServiceStub.ReturnUpdates;
import com.dop.cms.utilities.Utility;

import org.apache.commons.lang.RandomStringUtils;

public class LoginClient {
	
	public static void main(String[] args) {
		
		
		try {
			System.out.println(Utility.encode("RahGIJ70"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}/* 
		try {
			String endpoint = "http://localhost:1000/LoginModule/LoginService";
			LoginServiceStub proxy = new LoginServiceStub(endpoint);
			LoginServiceStub.ChangePasswordE inc = new LoginServiceStub.ChangePasswordE();
			LoginServiceStub.ChangePasswordResponseE resp = new LoginServiceStub.ChangePasswordResponseE();
			LoginServiceStub.ChangePassword in= new LoginServiceStub.ChangePassword();
			
			in.setArg0(1);
			in.setArg1("ipsit.patra@gmail.com");
			in.setArg2(Utility.encode("Ipsit"));
			in.setArg3(Utility.encode("patra"));
			inc.setChangePassword(in);//setLogin(in);

			resp = proxy.changePassword(inc);//login(inc);
			ReturnUpdates a=resp.getChangePasswordResponse().get_return();
			System.out.println("Return: " +a.getReturnType());
			
			
			
			RandomStringUtils rand = new RandomStringUtils();
			System.out.println(rand.randomAlphanumeric(8));
			
			
			String endpoint = "http://localhost:1000/LoginModule/LoginService";
			LoginServiceStub proxy = new LoginServiceStub(endpoint);
			LoginServiceStub.ForgotPasswordE inc = new LoginServiceStub.ForgotPasswordE();
			LoginServiceStub.ForgotPasswordResponseE resp = new LoginServiceStub.ForgotPasswordResponseE();
			LoginServiceStub.ForgotPassword in= new LoginServiceStub.ForgotPassword();
			
			in.setArg0("1");
			in.setArg1("agunta2@uic.edu");
			in.setArg2(1);
			inc.setForgotPassword(in);//setLogin(in);

			resp = proxy.forgotPassword(inc);//login(inc);
			ReturnUpdates a=resp.getForgotPasswordResponse().get_return();
			System.out.println("Return: " +a.getReturnType());
			
			
			
			RandomStringUtils rand = new RandomStringUtils();
			System.out.println(rand.randomAlphanumeric(8));
			
			
			
		}
		catch (Exception e) {
			System.out.println(e.toString());
		}
	
	*/}
}
