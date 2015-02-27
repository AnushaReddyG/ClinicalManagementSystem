<%@ page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Clinic Management System</title>
<link rel="stylesheet" href="Style.css" type="text/css" />
</head>
<script>
	function redirect(elem) {
		elem.setAttribute("action", "patientIndex.jsp");
		elem.submit();
	}

	function checkusername() {
		
		var passwd = document.login.password.value;
		var passwd1 = document.login.password1.value;
		var passwd2 = document.login.password2.value;
		var form = document.login;
		
		if (passwd.length == 0) {
			alert("Password is blank");
			form.password.focus();
			return false;
		}
		if (passwd.length < 3) {
			alert("Enter a password that has at least three characters.");
			form.password.focus();
			return false;
		}
		
		if (passwd1.length == 0) {
			alert("New Password is blank");
			form.password1.focus();
			return false;
		}
		if (passwd1.length < 3) {
			alert("Enter the new password that has at least three characters.");
			form.password1.focus();
			return false;
		}
		if (passwd2.length == 0) {
			alert("New Password is blank");
			form.password2.focus();
			return false;
		}
		if (passwd2.length < 3) {
			alert("Enter a password that has at least three characters.");
			form.password2.focus();
			return false;
		}
		
	    if(passwd2 != passwd1)
	    {
	    	alert("New Passwords Not equal");
			form.password2.focus();
	    	return false;    
	    }

	    
		return true;

	}
</script>
<body>
	<div id="container">
		<a id="top"></a>
		<p class="hide"></p>

		<div id="sitename">
			<h1>Clinic Management System</h1>
			<span> Change Password </span> <a id="menu"></a>
		</div>
		<div id="wrap1">
			<div id="wrap2">
				<p align="center">
					
				</p>
				<div id="leftside">
					<a id="sectionmenu"></a>
				</div>

				<div id="rightside"></div>

				<a id="main"></a>
				<div id="content">
					<form name="login" method="post" onsubmit="return checkusername();"
						action="abc">
						<table width="100%">
							<tr valign="top">
								<td colspan="2" align="center" class="menubg"><font
									color="black"><b>Change Password</b></font></td>
							</tr>
							<tr>
								<td>Old Password</td>
								<td style="width: 15%"><input type="password"
									name="password" maxlength="12" style="width: 120px"
									title="Enter the password"></td>
							</tr>
							<tr>
								<td>New Password</td>
								<td style="width: 15%"><input type="password"
									name="password1" maxlength="12" style="width: 120px"
									title="New Password"></td>
							</tr>
							<tr>
								<td>Retype New Password</td>
								<td style="width: 15%"><input type="password"
									name="password2" maxlength="12" style="width: 120px"
									title="Retype New Password"></td>
							</tr>
							<tr>
								<td align="left"><input type="submit" value="Reset"
									name="signIn"></td>
							</tr>
							<tr valign="top">
								<td colspan="2" align="center" class="menubg"><font
									color="red"><b>${errorMessage}</b></font></td>
							</tr>
						</table>
					</form>
					<form id="main" method="post" name="main" action=""
						onsubmit="redirect(this);">
						<input type="submit" name="submit" value ="Back to Index Page" /> 
					</form>
				</div>
			</div>
			<div id="footer">
				CS 441 Project<br />
			</div>
		</div>
	</div>
</body>
</html>

