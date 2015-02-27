package com.dop.cms.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class GetAppointSlotByDocidServ
 */
@WebServlet("/GetAppointSlotByDocidServ")
public class GetAppointSlotByDocidServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAppointSlotByDocidServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] apptSlotTimings;
//		String output="";
		String docId = request.getParameter("val");
		PatientAppoint patAppt = new PatientAppoint();
		apptSlotTimings = patAppt.gettimings(docId);
		String json = new Gson().toJson(apptSlotTimings);
		response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(json);
	}

}
