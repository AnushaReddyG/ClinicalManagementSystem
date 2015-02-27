package com.dop.cms.client;

import java.io.IOException;
//
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DoctorServlet")
public class DoctorServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorServlet() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//PrintWriter pw = response.getWriter();
		String ApptStatus = request.getParameter("apptstatusParam");
		int AppointmentId = Integer.parseInt(request.getParameter("appointId"));
		
		String doctorId = request.getParameter("doctorId");
		DocPatAppoint docPatAppoint = new DocPatAppoint();
		boolean updStatus = docPatAppoint.updDocPatAppt(ApptStatus, AppointmentId);
		request.setAttribute("doctorId", doctorId);
		if (updStatus){
		request.getRequestDispatcher("/doctorIndex.jsp").forward(request, response);
		}else{
			request.setAttribute("updProb", "There is a problem with the update");
			request.getRequestDispatcher("/doctorIndex.jsp").forward(request, response);
		}
	}

}
