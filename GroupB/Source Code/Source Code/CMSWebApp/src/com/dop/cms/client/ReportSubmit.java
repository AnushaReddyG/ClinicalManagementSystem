package com.dop.cms.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReportSubmit
 */
@WebServlet("/ReportSubmit")
public class ReportSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportSubmit() {
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

		LabAppoint labAppt = new LabAppoint();
		
		String msg = labAppt.submitReport(request.getParameter("labAssistantId"), Integer.parseInt((String)request.getParameter("docId")), Integer.parseInt((String)request.getParameter("patientId")), request.getParameter("apptId"), request.getParameter("result"));
		
/*		System.out.println(request.getParameter("docId")+
		request.getParameter("apptId")+
		request.getParameter("labAssistantId")+
		request.getParameter("patientId")+
		request.getParameter("result"));
		//labreport id ?
		request.getParameter("");*/
		
		request.setAttribute("message", msg);
		request.setAttribute("labAssistantId", request.getParameter("labAssistantId"));
		request.getRequestDispatcher("/labAssistantIndex.jsp").forward(request, response);
		
		
	}

}
