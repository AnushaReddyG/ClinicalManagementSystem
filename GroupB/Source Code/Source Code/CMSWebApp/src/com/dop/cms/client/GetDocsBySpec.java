package com.dop.cms.client;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dop.cms.PatWs.PatientServiceStub.DocNamesBySpec;
import com.google.gson.Gson;

/**
 * Servlet implementation class GetDocsBySpec
 */
@WebServlet(description = "Returns Doctor names based on the specialization selected", urlPatterns = { "/GetDocsBySpec" })
public class GetDocsBySpec extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetDocsBySpec() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String val = request.getParameter("val");
	    DocNamesBySpec[] docNamesArray = new DocNamesBySpec[]{};
		HashMap<Integer,String> docNames = new HashMap<Integer,String>();
		PatientAppoint patAppt = new PatientAppoint();
		docNamesArray = patAppt.getdocNames(val);
		for(int i=0;i<docNamesArray.length;i++){
			docNames.put(docNamesArray[i].getDocId(), docNamesArray[i].getDocName());
		}
		if(docNames.isEmpty()){
			HttpSession session = request.getSession(true);
			try{
				if(null != (session.getAttribute("noDocAvail"))){
					session.removeAttribute("noDocAvail");
				}else{
					session.setAttribute("noDocAvail", "No Doctor available under the selected specialization");
				}
			}catch(Exception er){
				er.printStackTrace();
			}
		}else{
			String json = new Gson().toJson(docNames);
			response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(json);
		}
	
    }
    
    
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		String dd = request.getParameter("dd"); // ID of child DD to fill options for.
//	    String val = request.getParameter("val");
//		HashMap<Integer,String> docNames = new HashMap<Integer,String>();
//		docNames.put(1,"Shravan");
//		docNames.put(2,"Muru");
//		docNames.put(3,"Ipsit");
//		docNames.put(4,"Sandeep");
//		docNames.put(5,"Dileep");
//		System.out.println("Value:"+val);
//		if (val.equals("Dermatologist")){
//
////			response.setContentType("text/plain");	
////			response.getWriter().write(docNames.toString());
//			String json = new Gson().toJson(docNames);
//			System.out.println(json);
//			response.setContentType("application/json");
//		    response.setCharacterEncoding("UTF-8");
//		    response.getWriter().write(json);
//		}else{
//			response.setContentType("text/plain");
//			response.getWriter().write("Muru");
//		}
//	}

}
