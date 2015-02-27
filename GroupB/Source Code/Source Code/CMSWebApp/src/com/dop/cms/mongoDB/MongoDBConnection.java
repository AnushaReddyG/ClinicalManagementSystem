package com.dop.cms.mongoDB;

import java.io.IOException;
import java.io.InputStream;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSInputFile;

public class MongoDBConnection {

	public static String ADDRESS = "localhost";
	public static int PORT = 27017;
	public static String DBNAME = "CMS";
	public static String COLLECTIONNAME = "PatientFiles";


	public MongoDBConnection(){



	}


	/*public boolean invokeMongo(InputStream file){


		try{	
			Mongo mongo = new Mongo(ADDRESS, PORT);
			DB db = mongo.getDB(DBNAME);
			DBCollection collection = db.getCollection(COLLECTIONNAME);

			String newFileName = "cms_patientid_doctorid";

//			File imageFile = ;

			// create a "pdf" namespace
			GridFS gfsPdf = new GridFS(db, "pdf");

			// get image file from local drive
			GridFSInputFile gfsFile = gfsPdf.createFile(file);

			// set a new filename for identify purpose
			gfsFile.setFilename(newFileName);

			// save the image file into mongoDB
			gfsFile.save();

			// print the result
			DBCursor cursor = gfsPdf.getFileList();
			while (cursor.hasNext()) {
				System.out.println(cursor.next());
			}

			// get image file by it's filename
//			GridFSDBFile imageForOutput = gfsPdf.findOne(newFileName);

			// save it into a new image file
//			imageForOutput.writeTo("c:\\JavaWebHostingNew.png");

			// remove the image file from mongoDB
			//			gfsPhoto.remove(gfsPhoto.findOne(newFileName));

			System.out.println("Done");

		} catch (MongoException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}


		return true;
	}*/


}
