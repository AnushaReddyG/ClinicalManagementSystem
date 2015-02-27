package com.dop.cms.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dop.cms.utilities.WSCallURL;
import com.dop.cms.webservice.StaffServiceStub;
import com.dop.cms.webservice.StaffServiceStub.Patient;

/**
 * Servlet implementation class StaffServlet
 */
@WebServlet("/StaffServletPath")
public class StaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public StaffServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String endpoint = WSCallURL.STAFFMODULE;
			StaffServiceStub proxy = new StaffServiceStub(endpoint);
			StaffServiceStub.GetBillE inc = new StaffServiceStub.GetBillE();
			StaffServiceStub.GetBillResponseE resp = new StaffServiceStub.GetBillResponseE();
			StaffServiceStub.GetBill in= new StaffServiceStub.GetBill();
			inc.setGetBill(in);
			resp = proxy.getBill(inc);//invoking WS
			Patient patInf=resp.getGetBillResponse().get_return();	
			System.out.println(patInf.getName());
			request.getSession().setAttribute( "result", patInf );
			response.sendRedirect("staffResult.jsp");
		}
		catch (Exception e) {
			System.out.println(e.toString());
		}
			
	}
}
