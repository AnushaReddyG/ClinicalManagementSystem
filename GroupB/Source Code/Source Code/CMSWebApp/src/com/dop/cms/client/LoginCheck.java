package com.dop.cms.client;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.axis2.AxisFault;

import com.dop.cms.LoginServiceStub;
import com.dop.cms.LoginServiceStub.LoginReturn;
import com.dop.cms.utilities.Utility;
import com.dop.cms.utilities.WSCallURL;

/**
 * Servlet implementation class LoginCheck
 */
@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String url;
	private static final String PROPERTIES_FILE="propfile";
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginCheck() {
		super();
		Properties  properties = new Properties();

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
		

		try {
			String endpoint = WSCallURL.LOGINMODULE;
			LoginServiceStub proxy = new LoginServiceStub(endpoint);
//			LoginServiceStub proxy = new LoginServiceStub(url);
			LoginServiceStub.LoginE inc = new LoginServiceStub.LoginE();
			LoginServiceStub.LoginResponseE resp = new LoginServiceStub.LoginResponseE();
			LoginServiceStub.Login in= new LoginServiceStub.Login();
			HttpSession session = request.getSession();  
			in.setArg0(request.getParameter("username"));
			in.setArg1(Utility.encode(request.getParameter("password")));
			inc.setLogin(in);

			resp = proxy.login(inc);//invoking WS
			LoginReturn lr=resp.getLoginResponse().get_return();			
			System.out.println("Return: " + lr);
			if(lr.getLoginType()==5){
				request.setAttribute("errorMessage", "Invalid Credentials");
				request.getRequestDispatcher("/front.jsp").forward(request, response);
			}
			else if(lr.getLoginType()==1){
				session.setAttribute("loginstatus", "true");
				session.setAttribute("patientId", lr.getLoginId());
//				request.getRequestDispatcher("/patientIndex.jsp").forward(request, response);
				response.sendRedirect("patientIndex.jsp");
			}
			else if(lr.getLoginType()==2){
				session.setAttribute("loginstatus", "true");
				session.setAttribute("doctorId", lr.getLoginId());
//				request.getRequestDispatcher("/doctorIndex.jsp").forward(request, response);
				response.sendRedirect("doctorIndex.jsp");//doctor
			}
			else if(lr.getLoginType()==3){
				//TO DO
				session.setAttribute("loginstatus", "true");
				response.sendRedirect("StaffServletPath");//staff
			}
			else if(lr.getLoginType()==4){
				session.setAttribute("loginstatus", "true");
				session.setAttribute("labAssistantId", lr.getLoginId());
				response.sendRedirect("labAssistantIndex.jsp");
			}
		}
		catch (AxisFault e) {
			request.setAttribute("errorMessage", "Login Module Currently Unavailable");
			request.getRequestDispatcher("/front.jsp").forward(request, response);
		}
		catch (Exception e) {
			System.out.println("hello"+e.toString());
		}



//		System.out.println("Hello !"+request.getParameter("username")+" "+request.getParameter("password"));
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

}
