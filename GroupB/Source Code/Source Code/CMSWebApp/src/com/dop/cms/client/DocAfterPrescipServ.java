package com.dop.cms.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DocAfterPrescipServ
 */
@WebServlet("/DocAfterPrescipServ")
public class DocAfterPrescipServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DocAfterPrescipServ() {
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
		String prescDet = request.getParameter("strToServ");
		String apptId = request.getParameter("apptId");
		String docId = request.getParameter("docId");
		String notes = request.getParameter("paragraph_text");
		System.out.println(apptId);
		DocPatAppoint docPatAppoint = new DocPatAppoint();
		boolean updstatus = docPatAppoint.updDocPrescrip(Integer.parseInt(apptId), prescDet, notes);
		if(updstatus == true){
			request.setAttribute("success", "The prescription request has been sent");
		}
		else{
			request.setAttribute("failure", "The prescription request is failed, please try again");
		}
		request.setAttribute("doctorId",docId);
		request.getRequestDispatcher("/doctorIndex.jsp").forward(request, response);
	}
		


}
