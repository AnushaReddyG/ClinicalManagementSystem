package com.dop.cms.mongoDB;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSInputFile;


@WebServlet("/UploadFile")

public class UploadFile extends HttpServlet{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadFile() {
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
		
		
		String patid = request.getParameter("patientid");
		String docid = request.getParameter("doctorid");
		//String testname = request.getParameter("testname");
		request.setAttribute("docId", docid);
		request.setAttribute("apptId", (String)request.getParameter("apptId"));
		request.setAttribute("patientId",patid);
		request.setAttribute("labAssistantId", (String)request.getParameter("labAssistantId"));
		
		if(ServletFileUpload.isMultipartContent(request)){
            try {
            	
            	String newFileName = null;
//        		System.out.println(patid);
        
                List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
              
                for(FileItem item : multiparts){
                    if(!item.isFormField()){
                    	Mongo mongo = new Mongo(MongoDBConnection.ADDRESS, MongoDBConnection.PORT);
            			DB db = mongo.getDB(MongoDBConnection.DBNAME);
//            			mongo.getCollection(MongoDBConnection.COLLECTIONNAME);
//                        DB db= (new MongoClient("localhost",27017)).getDB("PatientInfo");
                        newFileName = patid+"_"+docid;
                        System.out.println("File uploaded : "+newFileName+".pdf");
                        InputStream imageFile = item.getInputStream();
                     // create a "pdf" namespace
                		GridFS gfsPdf = new GridFS( db,"Reports" );
                		// get the file from local drive
                		GridFSInputFile in = gfsPdf.createFile(imageFile);
                		in.setContentType("application/pdf");
                		in.setFilename(newFileName);
                        in.save();
                    }
                    else{
                    	//System.out.println(item.getFieldName()+ "   " +item.getString());
                    	if(item.getFieldName().equals("patientid")){
                    		patid=item.getString();
                    	}
                    	else if(item.getFieldName().equals("doctorid")){
                    		docid=item.getString();
                    	}
                    		
                    }
                }
           
               //File uploaded successfully
               request.setAttribute("message", "File : "+newFileName+".pdf Uploaded Successfully");
            } catch (Exception ex) {
               request.setAttribute("message", "File Upload Failed due to " + ex);
            }          
         
        }else{
            request.setAttribute("message","Error Uploading file");
        }
	
		
		
        //response.sendRedirect("index.jsp");
			request.getRequestDispatcher("/labAssistantIndex.jsp").forward(request, response);
		
	}
			
}
