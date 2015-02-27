package com.dop.cms.DocWs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.jws.WebService;

import com.dop.cms.data.DBDetails;
import com.dop.cms.data.DocPatApptDetails;
import com.dop.cms.data.LabAssistantDetails;

@WebService(endpointInterface="com.dop.cms.DocWs.DoctorService", portName="DoctorServicePort", serviceName= "DoctorService")
public class DoctorServiceImpl implements DoctorService {

	@Override
	public DocPatApptDetails[] getAcceptedAppts(int docId) {
		ArrayList<DocPatApptDetails> docPatApptDetAl = new ArrayList<DocPatApptDetails>();
		DocPatApptDetails[] docPatApptDetArray = null;
		String docName = "";
		String patName = "";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(DBDetails.URL,DBDetails.USERNAME,DBDetails.PASSWORD );
			Statement stmt = con.createStatement();
//			Select all the details of the particular doctor and patient pair (patient id, doctor id, appointment date etc)
			ResultSet resultset = stmt.executeQuery("Select * from DocPatAppt where `doctor_doctor id`="+" '" +docId+"' and ( Appt_Status='Accept' or Appt_Status='Request')");
			while(resultset.next()){
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinicdb","root","" );
					Statement stmt1 = con1.createStatement();
					Statement stmt2 = con1.createStatement();
					int doctorId = resultset.getInt(1);
					int patientId = resultset.getInt(5);
//					Select the doctor name to be displayed based on the doctor ID
					ResultSet resultset1 = stmt1.executeQuery("Select `doctor name` from doctor where `doctor id` = "+"'" +doctorId +"'");
					ResultSet resultset2 = stmt2.executeQuery("Select `patient name` from patient where `patient id` = "+"'" +patientId +"'");
					while(resultset1.next()){
					docName = resultset1.getString(1);
					}
					while(resultset2.next()){
					patName = resultset2.getString(1);
					}
					DocPatApptDetails docPatApptDet = new DocPatApptDetails();
					docPatApptDet.setApptdate(resultset.getString(2));
					docPatApptDet.setApptId(resultset.getInt(6));
					docPatApptDet.setApptStatus(resultset.getString(7));
					docPatApptDet.setApptTime(resultset.getString(3));
					docPatApptDet.setDocId(resultset.getInt(1));
					docPatApptDet.setDocName(docName);
					docPatApptDet.setPatId(resultset.getInt(5));
					docPatApptDet.setPatname(patName);
					docPatApptDet.setSeverity(resultset.getInt(4));
//					populate the array list of PatientApptDetails object
					docPatApptDetAl.add(docPatApptDet);
					con1.close();
				}catch(Exception ex){
					System.out.println("There is a connection error in setting appointment details " +ex );
				}
			
			}
			con.close();
	}catch(Exception ex){
		System.out.println("There is a connection error in retrieving appointment details " +ex );
	}
		docPatApptDetArray = docPatApptDetAl.toArray(new DocPatApptDetails[docPatApptDetAl.size()]);
		return docPatApptDetArray;
}

	@Override
	public boolean updDocPatAppt(String status, int appointId) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(DBDetails.URL,DBDetails.USERNAME,DBDetails.PASSWORD );
			String updateapptstatus="update DocPatAppt set Appt_Status=? where `Appointment_ID`=?";
			PreparedStatement psmt=con.prepareStatement(updateapptstatus);
			psmt.setString(1, status);
			psmt.setInt(2, appointId);
			psmt.executeUpdate();
			con.close();
			return true;
		}catch(Exception ex){
			System.out.println("There is a connection error in setting appointment details " +ex );
			return false;
		}
	}

	@Override
	public DocPatApptDetails[] getPendingAppts(int docId) {
		ArrayList<DocPatApptDetails> docPatApptDetAl = new ArrayList<DocPatApptDetails>();
		DocPatApptDetails[] docPatApptDetArray = null;
		String docName = "";
		String patName = "";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(DBDetails.URL,DBDetails.USERNAME,DBDetails.PASSWORD );
			Statement stmt = con.createStatement();
//			Select all the details of the particular doctor and patient pair (patient id, doctor id, appointment date etc)
			ResultSet resultset = stmt.executeQuery("Select * from DocPatAppt where Appt_Status='Pending' and `doctor_doctor id`="+" '" +docId+"'");
			while(resultset.next()){
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinicdb","root","" );
					Statement stmt1 = con1.createStatement();
					Statement stmt2 = con1.createStatement();
					int doctorId = resultset.getInt(1);
					int patientId = resultset.getInt(5);
//					Select the doctor name to be displayed based on the doctor ID
					ResultSet resultset1 = stmt1.executeQuery("Select `doctor name` from doctor where `doctor id` = "+"'" +doctorId +"'");
					ResultSet resultset2 = stmt2.executeQuery("Select `patient name` from patient where `patient id` = "+"'" +patientId +"'");
					while(resultset1.next()){
					docName = resultset1.getString(1);
					}
					while(resultset2.next()){
					patName = resultset2.getString(1);
					}
					DocPatApptDetails docPatApptDet = new DocPatApptDetails();
					docPatApptDet.setApptdate(resultset.getString(2));
					docPatApptDet.setApptId(resultset.getInt(6));
					docPatApptDet.setApptStatus(resultset.getString(7));
					docPatApptDet.setApptTime(resultset.getString(3));
					docPatApptDet.setDocId(resultset.getInt(1));
					docPatApptDet.setDocName(docName);
					docPatApptDet.setPatId(resultset.getInt(5));
					docPatApptDet.setPatname(patName);
					docPatApptDet.setSeverity(resultset.getInt(4));
//					populate the array list of PatientApptDetails object
					docPatApptDetAl.add(docPatApptDet);
					con1.close();
				}catch(Exception ex){
					System.out.println("There is a connection error in setting appointment details " +ex );
				}
			
			}
			con.close();
	}catch(Exception ex){
		System.out.println("There is a connection error in retrieving appointment details " +ex );
	}
		docPatApptDetArray = docPatApptDetAl.toArray(new DocPatApptDetails[docPatApptDetAl.size()]);
		return docPatApptDetArray;
	}

	@Override
	public LabAssistantDetails[] getLabAssistDet() {
		ArrayList<LabAssistantDetails> labAssistDetAl = new ArrayList<LabAssistantDetails>();
		LabAssistantDetails[] labAssistDetArray = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(DBDetails.URL,DBDetails.USERNAME,DBDetails.PASSWORD );
			Statement stmt = con.createStatement();
//			Select all the details of the particular lab technician
			ResultSet resultset = stmt.executeQuery("Select * from lab");
			while(resultset.next()){
				LabAssistantDetails labAssistDet = new LabAssistantDetails();
				labAssistDet.setAssistantId(resultset.getInt(1));
				labAssistDet.setAssistantName(resultset.getString(2));
				labAssistDet.setAssistantPhone(resultset.getString(3));
				labAssistDet.setAssistantEmail(resultset.getString(4));	
				labAssistDetAl.add(labAssistDet);
			}
			con.close();
		}catch(Exception ex){
				System.out.println("There is a connection error in retrieving appointment details " +ex );
			}
		labAssistDetArray = labAssistDetAl.toArray(new LabAssistantDetails[labAssistDetAl.size()]);
		System.out.println(labAssistDetAl.size());
		return labAssistDetArray;
	}

	@Override
	public boolean updtDiagnosisFromDoc(int apptId, int testId, int labId) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(DBDetails.URL,DBDetails.USERNAME,DBDetails.PASSWORD );
			String updateTestDiag ="update DocPatAppt set testId=?,labId=?,Appt_Status=? where `Appointment_ID`=?";
			PreparedStatement psmt=con.prepareStatement(updateTestDiag);
			psmt.setInt(1, testId);
			psmt.setInt(2, labId);
			psmt.setString(3, "Request");
			psmt.setInt(4, apptId);
			psmt.executeUpdate();
			con.close();
			return true;
		}catch(Exception ex){
			System.out.println("There is a connection error in setting diagnosis details " +ex );
			return false;
		}
	}

	@Override
	public boolean updtPrescriptionFromDoc(int apptId, String med, String notes) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(DBDetails.URL,DBDetails.USERNAME,DBDetails.PASSWORD);
			String updatePrescrip ="update DocPatAppt set med=?,notes=?,Appt_Status=? where `Appointment_ID`=?";
			PreparedStatement psmt=con.prepareStatement(updatePrescrip);
			psmt.setString(1, med);
			psmt.setString(2, notes);
			psmt.setString(3, "Bill");
			psmt.setInt(4, apptId);
			psmt.executeUpdate();
			con.close();
			return true;
		}catch(Exception ex){
			System.out.println("There is a connection error in setting Prescription details " +ex );
			return false;
		}
	}
		
//	public static void main(String[] args) {
////	boolean pab;
//	DoctorServiceImpl ex = new DoctorServiceImpl();
////	pa=ex.updateApptDet(1000,2000,"12/14/2013", "01:00-01:30", "3");
//	ex.updtDiagnosisFromDoc(100000, 3, 5000);
////	System.out.println(pa[0].getPatname());
////	System.out.println(hey.get(0));
////	System.out.println(hey[1].getDocName());
////
//}



	
}
