package com.dop.cms.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdatePatDetServ
 */
@WebServlet("/UpdatePatDetServ")
public class UpdatePatDetServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePatDetServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//		System.out.println("get method");
//		String name = request.getParameter("nameParam");
//		System.out.println(name);
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String patId = request.getParameter("patientId");
		String patName = request.getParameter("nameParam");
		String patAddress = request.getParameter("addressParam");
		String patEmail = request.getParameter("emailParam");
		String patPhone = request.getParameter("phoneParam");
		PatientAppoint patAppt = new PatientAppoint();
//		System.out.println(request.getParameter("patientId"));
//		boolean update = true;
		boolean update = patAppt.updatePatDetails(patId, patName, patAddress, patEmail, patPhone);
		request.setAttribute("patientId", patId);
		if(update == true){
			request.getRequestDispatcher("/patientIndex.jsp").forward(request, response);
		}
		else{
			request.setAttribute("updateError", "There is a problem with updating the new details");
		}
		
	}

}
