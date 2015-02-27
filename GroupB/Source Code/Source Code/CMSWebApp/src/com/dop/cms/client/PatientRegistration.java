package com.dop.cms.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dop.cms.LoginServiceStub;
import com.dop.cms.LoginServiceStub.ReturnUpdates;
import com.dop.cms.utilities.WSCallURL;

/**
 * Servlet implementation class PatientRegistration
 */
@WebServlet("/PatientRegistration")
public class PatientRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientRegistration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		/*
		ReturnUpdates registerPatient(String firstName, String lastName,
				String address, String dateOfBirth, String sex, String email, String phone)*/
	
		
		try {
			String endpoint = WSCallURL.LOGINMODULE;
			LoginServiceStub proxy = new LoginServiceStub(endpoint);
			LoginServiceStub.RegisterPatientE inc = new LoginServiceStub.RegisterPatientE();
			LoginServiceStub.RegisterPatientResponseE resp = new LoginServiceStub.RegisterPatientResponseE();
			LoginServiceStub.RegisterPatient in= new LoginServiceStub.RegisterPatient();
			
			in.setArg0(request.getParameter("fname"));//firstName
			in.setArg1(request.getParameter("lname"));//lastName
			in.setArg2(request.getParameter("address1")+" "+request.getParameter("address1")+" "+request.getParameter("zip"));//address
			in.setArg3(request.getParameter("dob"));//dob
			in.setArg4(request.getParameter("sex"));//sex
			in.setArg5(request.getParameter("email"));//email
			in.setArg6(request.getParameter("phone"));//phone
			
			
			inc.setRegisterPatient(in);

			resp = proxy.registerPatient(inc);
			ReturnUpdates ru=resp.getRegisterPatientResponse().get_return();
			if(ru.getReturnCode()==0){
				request.setAttribute("errorMessage", "Account created and password sent to "+request.getParameter("email"));
				request.getRequestDispatcher("/front.jsp").forward(request, response);
				
			}else
			{
				request.setAttribute("errorMessage", ru.getReturnType());
				request.getRequestDispatcher("/front.jsp").forward(request, response);
			}
//			System.out.println("Return: " + a);
		}
		catch (Exception e) {
			System.out.println(e.toString());
		}
		System.out.println("Invoked Registration");
	}
		
		
	
	

}
