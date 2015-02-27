package com.dop.cms.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LabAssistantServ
 */
@WebServlet("/LabAssistantServ")
public class LabAssistantServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LabAssistantServ() {
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
		int labAssId = Integer.parseInt(request.getParameter("labAssistIdParam"));
		int docId = Integer.parseInt(request.getParameter("doctorIdParam"));
		int patId = Integer.parseInt(request.getParameter("patientIdParam"));
		int labrepId = Integer.parseInt(request.getParameter("labReportIdParam"));
		String testType = request.getParameter("testTypeParam");
		String testResult = request.getParameter("testResultParam");
		LabReportUpdate labReportUpdate = new LabReportUpdate();
		if(labReportUpdate.labReportUpdate(labAssId, docId, patId, labrepId, testType, testResult)){
			request.getRequestDispatcher("/LabRecUpdtSuccess.jsp").forward(request, response);
		}else{
			request.setAttribute("updtProblem", "There is a problem with the update");
		}
		
	}

}
