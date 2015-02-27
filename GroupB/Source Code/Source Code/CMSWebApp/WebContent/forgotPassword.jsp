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
		elem.setAttribute("action", "front.jsp");
		elem.submit();
	}
	function checkusername() {
		var str = document.login.username.value;
		var form = document.login;
		if (str.length == 0) {
			alert("Please enter the email Address");
			form.username.focus();
			return false;
		}
		
	    var atpos = str.indexOf("@");
	    var dotpos = str.lastIndexOf(".");
	    if (atpos< 1 || dotpos<atpos+2 || dotpos+2>=x.length) {
	        alert("Not a valid e-mail address");
	        form.username.focus();
	        return false;
	    }


		var passwd = document.login.password.value;

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
					<form name="login" method="post" onsubmit="return checkusername()"
						action="PasswordRetrieve">
						<table width="100%">
							<tr valign="top">
								<td colspan="2" align="center" class="menubg"><font
									color="black"><b>Change Password</b></font></td>
							</tr>
							<tr>
								<td style="width: 15%">Email</td>
								<td><input type="text" name="username" maxlength="35"
									style="width: 220px" title="Enter the Email"></td>
								<td align="left"><input type="submit" value="Reset"
									name="signIn"></td>
							</tr>
							<tr valign="top">
								<td colspan="2" align="center" class="menubg"><font
									color="red"><b>${errorMessage}</b></font></td>
							</tr>
						</table>
					</form>
					<p>
					<p>
					<p>
					<p>
					<p>
					<p>
					<p>
					<p>
					<p>
					<p>
					<p>
					<p>
					<p>
					<p>
					<p>
					<form id="main" method="post" name="main" action=""
						onsubmit="redirect(this);">
						<input type="submit" name="submit" value ="Back to Login Page" /> 
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

