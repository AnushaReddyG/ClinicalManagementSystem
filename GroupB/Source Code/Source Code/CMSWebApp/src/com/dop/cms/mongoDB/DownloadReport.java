package com.dop.cms.mongoDB;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;

@WebServlet("/DownloadReport")
public class DownloadReport extends HttpServlet {
	// size of byte buffer to send file
    private static final int BUFFER_SIZE = 4096; 
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DownloadReport() {
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
		
//		String filename = "876_90.jpg";
		Mongo mongo = new Mongo(MongoDBConnection.ADDRESS, MongoDBConnection.PORT);
		DB db = mongo.getDB(MongoDBConnection.DBNAME);
		
		String patid = request.getParameter("pid");
		String docid = request.getParameter("doctorId");
				
		String newfilename = patid+"_"+docid;
		System.out.println("File to Download : "+newfilename+".pdf");
		
		GridFS gfsrep = new GridFS(db, "Reports");
		
		GridFSDBFile imageForOutput = gfsrep.findOne(newfilename);
		if(imageForOutput!=null){
		System.out.println(imageForOutput);
		response.reset();  
		response.setContentType("application/pdf");
		imageForOutput.writeTo(response.getOutputStream());
		response.setHeader("Content-disposition","attachment; filename=" +newfilename+".pdf");
		response.getOutputStream().flush();
		}
		else{
			request.setAttribute("updProb1", "No Lab Reports have been submitted for the Case");
			request.getRequestDispatcher("/doctorIndex.jsp").forward(request, response);
		}
		
	}
	
}
