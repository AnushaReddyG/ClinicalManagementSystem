package com.dop.cms.client;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DocDiagnosisServ
 */
@WebServlet("/DocDiagnosisServ")
public class DocDiagnosisServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DocDiagnosisServ() {
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
		String docId = request.getParameter("doctorId");
		String apptId = request.getParameter("appointId");
		String pName = request.getParameter("patientName");
		String p = request.getParameter("statusid");
		request.setAttribute("appointId", apptId);
		request.setAttribute("patname", pName);
		request.setAttribute("doctId1",docId);
//		System.out.println(request.getParameter("P_D"));
		System.out.println("p=>"+p);
		if(p.equals("Request")){
			request.getRequestDispatcher("/DocToPrescrip.jsp").forward(request, response); 
		}else{
			request.getRequestDispatcher("/DocToDiagnosis.jsp").forward(request, response);
		}
		
		
		
			
		
	}
	

}
