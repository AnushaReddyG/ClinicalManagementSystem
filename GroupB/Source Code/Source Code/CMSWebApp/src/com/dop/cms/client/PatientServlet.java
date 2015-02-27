package com.dop.cms.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PatientServlet
 */
@WebServlet("/PatientServlet")
public class PatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientServlet() {
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
//		PrintWriter pw = response.getWriter();
		String docId = request.getParameter("doctorParam");
		String date = request.getParameter("dateParam");
		String time = request.getParameter("timeParam");
		String severity = request.getParameter("severityParam");
		String patientId = request.getParameter("patientId");
		DoctorAvailability docAppoint = new DoctorAvailability();
		boolean avail = docAppoint.docAvailability(Integer.parseInt(docId), date, time);
		if (avail == true){
			boolean update = docAppoint.updateAppoint(Integer.parseInt(docId),Integer.parseInt(patientId), date, time, severity);
			if(update == true){
				   String m_to="agunta2@uic.edu" ;
				   String m_subject = "CMS-Statement";
				   String m_text="Appointment Confirmation for "+date+" at "+time ;
				request.getRequestDispatcher("/SuccessPatientAppt.jsp").forward(request, response);
			}else{
				request.setAttribute("noAvailability", "There is a problem with the update");
				request.setAttribute("patientId", patientId);
				request.getRequestDispatcher("/patientIndex.jsp").forward(request, response);
			}
		}else{
			HttpSession session = request.getSession(true);
			try{
				if(null != (session.getAttribute("noAvailability"))){
					session.removeAttribute("noAvailability");
				}else{
					session.setAttribute("noAvailability", "The requested doctor is not available for the time slot selected");
				}
			}catch(Exception er){
				er.printStackTrace();
			}
			finally{
				request.setAttribute("patientId", patientId);
				request.getRequestDispatcher("/patientIndex.jsp").forward(request, response);
			}
			//request.setAttribute("noAvailability", "The requested doctor is not available for the time slot selected");
		}
//		request.setAttribute("patientId", patientId);
//		request.getRequestDispatcher("/patientIndex.jsp").forward(request, response);
	}

}
