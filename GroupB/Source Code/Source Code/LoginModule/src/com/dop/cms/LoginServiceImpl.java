package com.dop.cms;

import java.io.UnsupportedEncodingException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.jws.WebService;

import org.apache.commons.lang.RandomStringUtils;

import com.dop.cms.dataholder.LoginReturn;
import com.dop.cms.dataholder.ReturnUpdates;
import com.dop.cms.mail.Mailing;
import com.dop.cms.utilities.DatabaseConnection;
import com.dop.cms.utilities.Utility;



@WebService(endpointInterface="com.dop.cms.LoginService", portName="loginServicePort", serviceName= "loginService")
public class LoginServiceImpl implements LoginService{

	@Override
	//authenticates credentials of user
	public LoginReturn login(String username, String password) {
		
		DatabaseConnection mysql =  new DatabaseConnection();
		LoginReturn lr = new LoginReturn();
		ReturnUpdates ru = new ReturnUpdates();
		try {
			
			//connect to database
			mysql.getConnection();
			Statement st = mysql.getStatement();
			//look for details using given username and password
			ResultSet rs = st.executeQuery("select * from `clinicdb`.`Login` where email='"+username+"' and password='"+Utility.decode(password)+"'");
			// if no details are available
			if(!rs.next()){
				lr.setLoginType(5);
				lr.setLoginId(0);
				ru.setReturnCode(1);
				ru.setReturnType("Functional Error: Login not found");
				lr.setReturnUpdates(ru);
			}
			//if details are present in database
			else
			{
//				System.out.println("Success");
//				System.out.println(rs.getString("LoginType"));
//				System.out.println(rs.getString("LoginId"));
				lr.setLoginId(Integer.parseInt(rs.getString("LoginId")));
				lr.setLoginType(Integer.parseInt(rs.getString("LoginType")));
				ru.setReturnCode(0);
				ru.setReturnType("Login Credentials Valid");
				lr.setReturnUpdates(ru);
			}
			mysql.closeConnection();

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lr;
	}

	@Override
	//Registering new user by updating details in database
	public ReturnUpdates registerPatient(String firstName, String lastName,
			String address, String dateOfBirth, String sex, String email, String phone) {
		
		String queryPatient,queryLogin;
		RandomStringUtils rand = new RandomStringUtils();
		@SuppressWarnings("static-access")
		String newPassword = rand.randomAlphanumeric(8);
//		System.out.println("Generated Password :"+ newPassword);
		DatabaseConnection mysql =  new DatabaseConnection();
	       try {
	    	   //connect to database
	    	   mysql.getConnection();
	    	   Statement st = mysql.getStatement();
	    	   //get highest Id given to patient
	    	   String patID = "select `patient id` from `clinicdb`.`patient` order by `patient id` DESC limit 1";    
	    	   ResultSet rs = st.executeQuery(patID);
	    	   //if there is patientid available increase id and insert patient details
				if(rs.next()){
					int pID = rs.getInt(1);
					pID++;
					queryPatient="INSERT INTO `clinicdb`.`patient` (`patient id`,`patient name`,`patient address`,`patient email`,`patient phone`,`patient blood`,`patientdob`,`patientsex`) VALUES ("+pID+",'"+firstName+" "+lastName+"','"+address+"','"+email+"','"+phone+"','B+','"+dateOfBirth+"','"+sex+"')";
					queryLogin="INSERT INTO `clinicdb`.`login`(`email`,`password`,`LoginType`,`LoginId`)VALUES('"+email+"','"+newPassword+"',1,'"+pID+"');";
					st.executeUpdate(queryLogin);
					st.executeUpdate(queryPatient);
					String m_subject = "CMS-New Account";
					String m_text="1" ;
					Mailing mail=new Mailing();
					//mail password to patient email id
					mail.MailingHTML(email, m_subject,m_text,newPassword);
//					st.executeUpdate(queryPatient);
//					st.executeUpdate(queryLogin);
			   		mysql.closeStatement();
				}
/*	           INSERT INTO `clinicdb`.`patient` (`patient id`,`patient name`,`patient address`,`patient email`,`patient phone`,`patient blood`,`patientdob`,`patientsex`) VALUES (<{patient id: }>,<{patient name: }>,<{patient address: }>,<{patient email: }>,<{patient phone: }>,<{patient blood: }>,<{patientdob: }>,<{patientsex: }>);
*/
	   
	   		mysql.closeConnection();
	                  
	           
	       }catch (SQLException ex) {
	               ex.printStackTrace();
	           } catch (ClassNotFoundException ex) {
	               ex.printStackTrace();
	           }
		
		
		System.out.println(firstName+" "+lastName+" "+address+" "+dateOfBirth+" "+" "+sex+" "+email+" "+phone);
		ReturnUpdates ru = new ReturnUpdates();
		ru.setReturnCode(0);
		
		return ru;
	}


	@Override
	//change password from old to new
	public ReturnUpdates changePassword(int clientId, String clientType,
			String newPassword, String oldPasssord) {

		DatabaseConnection mysql =  new DatabaseConnection();
		ReturnUpdates ru = new ReturnUpdates();
		try {
			//connecting to database and set given password as new password
			String query = "update `clinicdb`.`Login` set password = '"+Utility.decode(newPassword)+"' where email='"+clientType+"'";
			mysql.getConnection();
			Statement st = mysql.getStatement();
			//return error when new password is same as the old password
			ResultSet rs = st.executeQuery("select * from `clinicdb`.`Login` where email='"+clientType+"' and password='"+Utility.decode(oldPasssord)+"'");
//			System.out.println("select * from `clinicdb`.`Login` where email='"+clientType+"' and password='"+Utility.decode(oldPasssord)+"'");
			if(!rs.next()){
				ru.setReturnCode(1);
				ru.setReturnType("Functional Error: Password Incorrect");
			}
			//success in setting a new password
			else
			{
				PreparedStatement preparedStmt = mysql.getCon().prepareStatement(query);
				preparedStmt.execute();
				System.out.println("Success: Password Changed");
				ru.setReturnCode(0);
				ru.setReturnType("Login Credentials Altered");
			}
			mysql.closeConnection();

		}  catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return ru;
	}

	@Override
	//forgot password
	public ReturnUpdates forgotPassword(String clientId, String clientType,
			int emailType) {
		DatabaseConnection mysql =  new DatabaseConnection();
		ReturnUpdates ru = new ReturnUpdates();

		RandomStringUtils rand = new RandomStringUtils();
		@SuppressWarnings("static-access")
		String newPassword = rand.randomAlphanumeric(8);

		try {
			//enter the email id for setting a new password
			String query = "update `clinicdb`.`Login` set password = '"+newPassword+"' where email='"+clientType+"'";
			mysql.getConnection();
			Statement st = mysql.getStatement();
			ResultSet rs = st.executeQuery("select * from `clinicdb`.`Login` where email='"+clientType+"'");
			//return error if email id is not found in the database
			if(!rs.next()){
				ru.setReturnCode(1);
				ru.setReturnType("Functional Error: Email Not Found");
			}
			//returns a new password to given email address
			else
			{
				PreparedStatement preparedStmt = mysql.getCon().prepareStatement(query);
				preparedStmt.execute();
				Mailing mail=new Mailing();
				String m_subject = "CMS-Password Change";
				String m_text="Password Change" ;
				mail.MailingHTML(clientType, m_subject,m_text,newPassword);
//				Mailing.main(null);
				System.out.println("Success: New Password Generated and emailed");
				ru.setReturnCode(0);
				ru.setReturnType("Login Credentials Altered: New Password Genetated and e-mailed");
			}
			mysql.closeConnection();

		}  catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			ru.setReturnCode(1);
			ru.setReturnType("Technical Error");
			e.printStackTrace();
		} 
		return ru;
	}

	@Override
	public ReturnUpdates emailingService(int clientId, String clientType,
			int emailType) {
		DatabaseConnection mysql =  new DatabaseConnection();

		// TODO Auto-generated method stub
		return null;
	}

}
