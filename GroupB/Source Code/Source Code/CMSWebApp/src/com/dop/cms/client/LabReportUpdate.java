package com.dop.cms.client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class LabReportUpdate {
	
	public boolean labReportUpdate(int labAssId,int docId,int patId,int labrepId,String testType,String testResult){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinicdb","root","" );
			Statement insertStmt = con.createStatement();
			String insertLabRec = "insert into LabDocPat (`lab_assistant id`,`doctor_doctor id`,`patient_patient id`,`lab report id`,`test type`,`testResult`)"+
					"Values('"+labAssId+"','"+docId+"','"+patId+"','"+labrepId+"','"+testType+"','"+testResult+"')";
					insertStmt.executeUpdate(insertLabRec);
			return true;
		}catch (Exception ex){
			System.out.println("Problem with Insert" +ex);
			return false;
	}

}
}