package com.dop.cms;
import javax.jws.WebService;

import com.dop.cms.dataholder.LoginReturn;
import com.dop.cms.dataholder.ReturnUpdates;

@WebService
public interface LoginService {
	/*Login Module*/
	LoginReturn login(String username, String password);
	/*Registering New Patient and create login*/
	ReturnUpdates registerPatient(String firstName, String lastName,
			String address, String dateOfBirth, String sex, String email, String phone);
	/*Changing password*/
	ReturnUpdates changePassword(int clientId, String clientType, String newPassword, String oldPasssord);
	/*Forgot password*/
	ReturnUpdates forgotPassword(String clientId, String clientType, int emailType);
	/*Emailing Service*/
	ReturnUpdates emailingService(int clientId, String clientType, int emailType);
}
