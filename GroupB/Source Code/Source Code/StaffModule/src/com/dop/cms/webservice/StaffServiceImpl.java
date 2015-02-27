package com.dop.cms.webservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.jws.WebService;

import com.dop.cms.data.DBDetails;
import com.dop.cms.data.Patient;

@WebService(endpointInterface="com.dop.cms.webservice.StaffService", portName="StaffServicePort", serviceName= "StaffService")
public class StaffServiceImpl implements StaffService{

	@Override
	public Patient getBill() {
		Patient obj = new Patient();
		
		ArrayList<Integer> patientId = new ArrayList<Integer>();
		ArrayList<String> address = new ArrayList<String>();
		ArrayList<String> email = new ArrayList<String>();
		ArrayList<String> phone = new ArrayList<String>();
		ArrayList<String> bill = new ArrayList<String>();
		ArrayList<String> dateL = new ArrayList<String>();
		ArrayList<String> name = new ArrayList<String>();
		ArrayList<String> statusA = new ArrayList<String>();
	    String status = "Bill";
        
		String query = "select `s`.`total bill`,`d`.`appointment date`,`p`.`patient id`,`p`.`patient name`,"
				+ "`p`.`patient address`,"
				+ "`p`.`patient email`,`p`.`patient phone`, d.`Appt_Status`"+
				"from staff AS s, patient AS p, docpatappt AS d where d.`Appt_Status` = '"+status+"' and "
						+ "`d`.`patient_patient id1` = p.`patient id` and `s`.`Fpat_id` = p.`patient id`";
        
//		System.out.println(query);
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection myconn = null;
		Statement myStmt = null;
		try {
			myconn = DriverManager.getConnection(DBDetails.URL,DBDetails.USERNAME,DBDetails.PASSWORD );
			myStmt = myconn.createStatement();
			ResultSet myRs1 = myStmt.executeQuery(query);
//			System.out.println("HEllo");
			
			while (myRs1.next()) {
				bill.add(myRs1.getString(1));
//				System.out.println("HEllo in");
//				System.out.println(myRs1.getString(1));
				dateL.add(myRs1.getString(2));
				int LpatientId = Integer.parseInt(myRs1.getString(3));
				patientId.add(LpatientId);
				name.add(myRs1.getString(4));
				address.add(myRs1.getString(5));
				email.add(myRs1.getString(6));
				phone.add(myRs1.getString(7));
				statusA.add(myRs1.getString(8));
			}
			obj.setBill(bill);
			obj.setDateL(dateL);
			obj.setPatientId(patientId);
			obj.setName(name);
			obj.setAddress(address);
			obj.setEmail(email);
			obj.setPhone(phone);
			obj.setStatusA(statusA);
			
			return obj;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
