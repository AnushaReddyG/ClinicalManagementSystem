package com.dop.cms;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.jws.WebService;

import com.dop.cms.utilities.DatabaseConnection;
import com.dop.dataHolder.ListPatients;

@WebService(endpointInterface="com.dop.cms.LabService", portName="labServicePort", serviceName= "labService")
public class LabServiceImpl implements LabService {

	@Override
	public String submitReport(String asst_name, int doc_id, int pat_id, String test_type, String result) {

		String queryInsert, queryUpdate, returnMsg;
		DatabaseConnection mysql =  new DatabaseConnection();
		try {
			mysql.getConnection();
			Statement st = mysql.getStatement();

			queryInsert="INSERT INTO `clinicdb`.`labdocpat` (`lab_assistant id`,`doctor_doctor id`,`patient_patient id`,`lab report id`,`test type`,`testResult`,`appointId`) VALUES ("+asst_name+","+doc_id+","+pat_id+","+test_type+",'N/A','"+result+"',"+test_type+")";
			queryUpdate="UPDATE `clinicdb`.`docpatappt` SET `appt_status` = 'Accept' WHERE `Appointment_ID` = "+test_type+"";
			System.out.println(queryInsert);
			System.out.println(queryUpdate);
			st.executeUpdate(queryInsert);
			st.executeUpdate(queryUpdate);

			mysql.closeStatement();
			returnMsg = "Report submitted for Patient "+pat_id;

			mysql.closeConnection();


		}catch (SQLException ex) {
			returnMsg = "Technical Error, Please submit the report again.";
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			returnMsg = "Technical Error, Please submit the report again.";
			ex.printStackTrace();
		}
		return returnMsg; 
	}

	@Override
	public ListPatients[] getDetails(String lab_id) {

		ArrayList<ListPatients> listA = new ArrayList<ListPatients>();
		ListPatients tmp =null;
		DatabaseConnection mysql =  new DatabaseConnection();
		try {
			mysql.getConnection();
			Statement st = mysql.getStatement();
			String query = "SELECT `docpatappt`.`doctor_doctor id`,`docpatappt`.`patient_patient id1`,`docpatappt`.`Appointment_ID`, `docpatappt`.`testId` FROM `clinicdb`.`docpatappt` where appt_status ='Request' and labId="+lab_id+"";
			ResultSet rs = st.executeQuery(query);
			System.out.println(query);
			while(rs.next()){
				tmp = new ListPatients();
				tmp.setDocId(rs.getString(1));
				tmp.setPatientId(rs.getString(2));
				tmp.setAppointment(rs.getString(3));
				tmp.setTestType(rs.getString(4));
				listA.add(tmp);
			}
			mysql.closeConnection();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}


		return listA.toArray(new ListPatients[listA.size()]);
	}

	/*	private boolean updateBill(int case_id) {
			return true; //temp
		}*/
}
