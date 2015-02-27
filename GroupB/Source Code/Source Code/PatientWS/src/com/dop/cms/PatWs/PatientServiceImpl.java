package com.dop.cms.PatWs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.jws.WebService;

import com.dop.cms.PatWs.dataHolders.Bill;
import com.dop.cms.PatWs.dataHolders.Doctor;
import com.dop.cms.PatWs.dataHolders.Medicine;
import com.dop.cms.PatWs.dataHolders.Report;
import com.dop.cms.data.DBDetails;
import com.dop.cms.data.DocNamesBySpec;
import com.dop.cms.data.PatientApptDetails;
import com.dop.cms.data.PatientDetails;


@WebService(endpointInterface="com.dop.cms.PatWs.PatientService", portName="PatientServicePort", serviceName= "PatientService")
public class PatientServiceImpl implements PatientService {

	List<String> specialization = null; //List to hold the type of specializations available
	HashMap<Integer, String> docNames = null; //Hash map to hold the doctor id as key and doctor name as value
	String apptSlots = ""; //List to hold the appointment slots available under a doctor


	@Override
	//	Method to return a list of specializations available in the hospital database
	public List<String> getSpecialization() {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(DBDetails.URL,DBDetails.USERNAME,DBDetails.PASSWORD );
			Statement stmt = con.createStatement();
			//			Select the available specializations in the database
			ResultSet resultset = stmt.executeQuery("Select distinct `specialization` from doctor"); 
			specialization = new ArrayList<String>();
			while(resultset.next()){
				specialization.add(resultset.getString("specialization"));
			}
			con.close();
		}
		catch(Exception ex){
			System.out.println("There is an connection error in retrieving specializations  " +ex );
		}
		return specialization;
	}

	@Override
	//	Method to return Doctor names array based on the specialization selected
	public DocNamesBySpec[] getDocBySpec(String spec) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(DBDetails.URL,DBDetails.USERNAME,DBDetails.PASSWORD );
			Statement stmt = con.createStatement();
			//			Select the doctor Id and name based on the specialization
			ResultSet resultset = stmt.executeQuery("Select `doctor id`,`doctor name` from doctor where `specialization` = "+"'" +spec+"' ");
			docNames = new HashMap<Integer, String>(); 

			while(resultset.next()){
				docNames.put(resultset.getInt("doctor id"), resultset.getString("doctor name"));
			}
			con.close();
		}catch(Exception ex){
			System.out.println("There is an connection error in retrieving specializations  " +ex );
		}
		DocNamesBySpec[] docNamesBySpecArray = new DocNamesBySpec[docNames.size()];
		Set<Integer> setOfKeys = docNames.keySet();
		Iterator<Integer> iterator = setOfKeys.iterator();
		//		Iterate through the hash map and place the doctor id and names in the object to be returned
		for(int i=0 ;iterator.hasNext();i++){
			int key = (int) iterator.next();

			String value = (String)docNames.get(key);
			docNamesBySpecArray[i] = new DocNamesBySpec(key, value);	

		}
		//		return the array of DocNamesBySpec object which consists the doctor name and id
		return docNamesBySpecArray;
	}

	@Override
	//	Method to return Patient appointment details based on the patient Id used to login
	public PatientApptDetails[] getPatientApptDet(int patId) {
		ArrayList<PatientApptDetails> patApptDetAl = new ArrayList<PatientApptDetails>();
		PatientApptDetails[] patApptDetArray = null;
		String docName = "";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(DBDetails.URL,DBDetails.USERNAME,DBDetails.PASSWORD );
			Statement stmt = con.createStatement();
			//			Select all the details of the particular doctor and patient pair (patient id, doctor id, appointment date etc)
			ResultSet resultset = stmt.executeQuery("Select * from DocPatAppt where `patient_patient id1` = "+"'" +patId +"'");
			while(resultset.next()){
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinicdb","root","" );
					Statement stmt1 = con1.createStatement();
					int docId = resultset.getInt(1);
					//					Select the doctor name to be displayed based on the doctor ID
					ResultSet resultset1 = stmt1.executeQuery("Select `doctor name` from doctor where `doctor id` = "+"'" +docId +"'");
					while(resultset1.next()){
						docName = resultset1.getString(1);
					}
					PatientApptDetails patApptDet = new PatientApptDetails();
					patApptDet.setDocId(docId);
					patApptDet.setDocName(docName);
					patApptDet.setAppointDate(resultset.getString(2));
					patApptDet.setAppointTime(resultset.getString(3));
					patApptDet.setSeverity(resultset.getString(4));
					patApptDet.setPatientId(resultset.getString(5));
					//					populate the array list of PatientApptDetails object
					patApptDetAl.add(patApptDet);
					con1.close();
				}catch(Exception ex){
					System.out.println("There is a connection error in setting appointment details " +ex );
				}

			}
			con.close();
		}catch(Exception ex){
			System.out.println("There is a connection error in setting appointment details " +ex );
		}
		patApptDetArray = patApptDetAl.toArray(new PatientApptDetails[patApptDetAl.size()]);
		return patApptDetArray;
	}

	@Override
	//	Method to return Appointment slots available under a particular doctor selected
	public String getApptTimeOfDoc(int docId) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(DBDetails.URL,DBDetails.USERNAME,DBDetails.PASSWORD );
			Statement stmt = con.createStatement();
			//			Select the available slots based on the doctor id in the database
			ResultSet resultset = stmt.executeQuery("Select `available slot` from doctorAvailability where `doctor_doctor id` = "+"'" +docId +"'"); 
			specialization = new ArrayList<String>();
			while(resultset.next()){
				apptSlots = (resultset.getString("available slot"));
			}
			con.close();
		}
		catch(Exception ex){
			System.out.println("There is an connection error in retrieving Appointment Slots  " +ex );
		}
		return apptSlots;
	}

	@Override
	//	Method to return a boolean value if the selected doctor is available for the selected date and time slot
	public boolean getDocAvailability(int docId, String date, String time) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(DBDetails.URL,DBDetails.USERNAME,DBDetails.PASSWORD );
			//			Select the available slots based on the doctor id in the database
			String getAvailability = "select * from doctorAvailability where `doctor_doctor id` =? and `available day` =? and `available slot` like  ?";
			PreparedStatement psmt=con.prepareStatement(getAvailability);
			psmt.setInt(1, docId);
			psmt.setString(2, date);
			psmt.setString(3, "%" + time + "%");
			ResultSet resultset = psmt.executeQuery();
			if(resultset.next()){
				con.close();
				return true;
			}else {
				con.close();
				return false;
			}
		}
		catch(Exception ex){
			System.out.println("There is an connection error in to check doctor Availability  " +ex );
			return false;
		}
	}	

	@Override
	public boolean updateApptDet(int docId,int patId, String date, String time,
			String severity) {
		String apptTimings = "";
		String newApptTimings = "";
		String[] timings = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(DBDetails.URL,DBDetails.USERNAME,DBDetails.PASSWORD );
			//			Select the available slots based on the doctor id in the database
			String getAvailability = "select * from doctorAvailability where `doctor_doctor id` =? and `available day` =? and `available slot` like  ?";
			PreparedStatement psmt=con.prepareStatement(getAvailability);
			psmt.setInt(1, docId);
			psmt.setString(2, date);
			psmt.setString(3, "%" + time + "%");
			ResultSet resultset = psmt.executeQuery();
			if(resultset.next()){
				apptTimings = resultset.getString(3);
				if(apptTimings == ""){
					return false;
				}
				else{
					timings = apptTimings.split(";");
					for(int i =0;i<timings.length;i++){
						if(timings[i].equals(time)){

						}
						else{
							newApptTimings = newApptTimings+timings[i];
							newApptTimings = newApptTimings+";";
						}
					}
					String updtTimings = "update doctorAvailability set `available slot`=? where `doctor_doctor id` =?";
					String getApp = "select `Appointment_ID` from DocPatAppt order by `Appointment_ID` DESC limit 1";
					PreparedStatement psmtUpd=con.prepareStatement(updtTimings);
					PreparedStatement psmtGetAppId=con.prepareStatement(getApp);
					Statement insertStmt = con.createStatement();
					psmtUpd.setString(1, newApptTimings);
					psmtUpd.setInt(2, docId);
					psmtUpd.executeUpdate();
					ResultSet resultsetApp = psmtGetAppId.executeQuery();
					if(resultsetApp.next()){
						String appStatus = "Pending";
						int appID = resultsetApp.getInt(1);
						appID = appID +1;
						String insert = "insert into DocPatAppt (`doctor_doctor id`,`appointment date`,`appointment time`,`severity`,`patient_patient id1`,`Appointment_ID`,`Appt_Status`)"+
								"Values('"+docId+"','"+date+"','"+time+"','"+severity+"','"+patId+"','"+appID+"','"+appStatus+"')";
						insertStmt.executeUpdate(insert);
					}
					con.close();
					return true;
				}
			}

			else{
				con.close();
				return false;
			}
		}catch(Exception ex){
			System.out.println("There is an connection error to update the appointment Status  " +ex );
			return false;
		}
	}

	@Override
	public PatientDetails getPatDetails(int patId) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(DBDetails.URL,DBDetails.USERNAME,DBDetails.PASSWORD );
			//			Select the Patient Details based on the logged in patient id from the database
			String getPatDet = "select * from patient where `patient id` =?";
			PreparedStatement psmt=con.prepareStatement(getPatDet);
			psmt.setInt(1, patId);
			ResultSet resultset = psmt.executeQuery();
			if(resultset.next()){
				PatientDetails patDet = new PatientDetails();
				patDet.setPatId(resultset.getInt(1));
				patDet.setPatName(resultset.getString(2));
				patDet.setPatAddress(resultset.getString(3));
				patDet.setPatEmail(resultset.getString(4));
				patDet.setPatPhone(resultset.getString(5));
				con.close();
				return patDet;
			}else {
				con.close();
				return null;
			}
		}
		catch(Exception ex){
			System.out.println("There is an connection error retrieving patient details " +ex );
			return null;
		}
	}

	@Override
	public boolean updPatDetails(int patId, String patName, String patAddress,
			String patEmail, String patPhone) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(DBDetails.URL,DBDetails.USERNAME,DBDetails.PASSWORD );
			//			Update the patient details with the new values in the database
			String updtPatDet = "update patient set `patient id`=?,`patient name`=?,`patient address`=?,`patient email`=?,`patient phone`=? where `patient id` =?";
			PreparedStatement psmtUpd=con.prepareStatement(updtPatDet);
			psmtUpd.setInt(1, patId);
			psmtUpd.setString(2, patName);
			psmtUpd.setString(3, patAddress);
			psmtUpd.setString(4, patEmail);
			psmtUpd.setString(5, patPhone);
			psmtUpd.setInt(6, patId);
			psmtUpd.executeUpdate();
			con.close();
			return true;
		}catch(Exception ex){
			System.out.println("There is an connection error to update patient details " +ex );
			return false;
		}
	}

	@Override
	public Bill requestBill(String patient_id, String case_id) {

		Bill bill = new Bill();
		Doctor doctor = new Doctor();
		Report report = new Report();

		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection(DBDetails.URL,DBDetails.USERNAME,DBDetails.PASSWORD );
			Statement stmt = con.createStatement();
			String q1 = "Select * from DocPatAppt where `patient_patient id1` = "+"'" +patient_id +"' and `appointment date` = '"+case_id+"'";
//			System.out.println(q1);
			ResultSet resultset = stmt.executeQuery(q1);
			if(!resultset.next()){

			}
			else
			{
				report.setCost(50);
				report.setReportId(Integer.toString(resultset.getInt(9)));
				report.setTest_type(resultset.getString("testId"));
				doctor.setCaseId(Integer.parseInt(resultset.getString("Appointment_ID")));
				doctor.setDoctorID(Integer.parseInt(resultset.getString("doctor_doctor id")));
				doctor.setDiagnosis(resultset.getString(10));//(Integer.parseInt(resultset.getString("doctor_doctor id")));
				bill.setMedicine(meds(resultset.getString(9)));
				doctor.setCost(100);
				String q2= "SELECT `doctor name` FROM clinicdb.doctor where `doctor id` = "+doctor.getDoctorID()+"";
				ResultSet resultset1 = stmt.executeQuery(q2);
				if(!resultset1.next()){

				}
				else
				{
					doctor.setDoctorName(resultset1.getString(1));
				}
						
//				bill.setMedicine(meds("1222;1443;1222;2;2;3"));

			}
			bill.setDoctor(doctor);
			bill.setReport(report);
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}




		return bill;
	}

	public static Medicine[] meds(String medicine){


		String[] splitStrings = medicine.split(";");
		ArrayList<Medicine> listMed =new ArrayList<Medicine>();
		Medicine tmpMed =null;
		String[] tmp = new String[splitStrings.length/2];
		String[] tmp1 = new String[splitStrings.length/2];
		System.arraycopy(splitStrings, 0, tmp, 0, (splitStrings.length/2));
		System.arraycopy(splitStrings, (splitStrings.length/2), tmp1, 0, (splitStrings.length/2));
		for (int i = 0; i < tmp.length; i++) {
			tmpMed = new Medicine();
			tmpMed.setMedicineId(Integer.parseInt(tmp[i]));
			tmpMed.setMedicineName("");
			tmpMed.setPrice(10);
			tmpMed.setQuantity(tmp1[i]);
			listMed.add(tmpMed);
		}



		return listMed.toArray(listMed.toArray(new Medicine[listMed.size()]));
	}



	/*public static void main(String[] args) {
		System.out.println(meds("1222;1443;1222;2;2;3").length);
	}*/



}
