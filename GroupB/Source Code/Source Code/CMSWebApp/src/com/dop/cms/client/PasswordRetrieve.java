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
 * Servlet implementation class PasswordRetrieve
 */
@WebServlet("/PasswordRetrieve")
public class PasswordRetrieve extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PasswordRetrieve() {
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
		try {
			String endpoint = WSCallURL.LOGINMODULE;
			LoginServiceStub proxy = new LoginServiceStub(endpoint);
			LoginServiceStub.ForgotPasswordE inc = new LoginServiceStub.ForgotPasswordE();
			LoginServiceStub.ForgotPasswordResponseE resp = new LoginServiceStub.ForgotPasswordResponseE();
			LoginServiceStub.ForgotPassword in= new LoginServiceStub.ForgotPassword();

			in.setArg1(request.getParameter("username"));
			in.setArg0("");
			in.setArg2(1);
			inc.setForgotPassword(in);

			resp = proxy.forgotPassword(inc);//invoking WS
			ReturnUpdates lr=resp.getForgotPasswordResponse().get_return();			
			System.out.println("Return: " + lr);
				request.setAttribute("errorMessage", lr.getReturnType());
				request.getRequestDispatcher("/forgotPassword.jsp").forward(request, response);
			
		}
		catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
