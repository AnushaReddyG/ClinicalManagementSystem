package com.dop.cms.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DocAfterDiagnosisServ
 */
@WebServlet("/DocAfterDiagnosisServ")
public class DocAfterDiagnosisServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DocAfterDiagnosisServ() {
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
		String apptId = request.getParameter("apptIdParam");
		//String patName = request.getParameter("patNameParam");
		String labAssistantId = request.getParameter("labAssistParam");
		String testType = request.getParameter("testTypeParam");
		String docId = request.getParameter("doctorId");
		DocPatAppoint docPatAppoint = new DocPatAppoint();
		boolean updstatus = docPatAppoint.updDocDiagnosis(Integer.parseInt(apptId), Integer.parseInt(labAssistantId), Integer.parseInt(testType));
		if(updstatus == true){
			request.setAttribute("success", "The diagnosis request has been sent to the Lab assistant");
		}
		else{
			request.setAttribute("failure", "The diagnosis request is failed, please try again");
		}
		request.setAttribute("doctorId",docId);
		request.getRequestDispatcher("/doctorIndex.jsp").forward(request, response);
	}

}
