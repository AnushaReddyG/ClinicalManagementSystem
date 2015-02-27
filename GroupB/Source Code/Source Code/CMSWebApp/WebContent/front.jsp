<%@ page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<%
	Date d = new Date();
	int y = d.getYear() + 1900;
	int m = d.getMonth() + 1;
	String ardate = d.getDate() + "/" + m + "/" + y;
%>
<%
	session.setAttribute("loginstatus", "false");
%>

<html>
<head>
<title>Clinic Management System</title>
<link rel="stylesheet" href="Style.css" type="text/css" />
</head>
<script>
	function checkusername() {
		var str = document.login.username.value;
		var form = document.login;
		if (str.length == 0) {
			alert("Please Enter Email address");
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

		for (var i = 0; i <= (str.length - 1); i++) {
			var theChar = str.substring(i, i + 1);
			if (!((theChar >= '0' && theChar <= '9')
					|| (theChar >= 'a' && theChar <= 'z')
					|| (theChar >= "A" && theChar <= "Z") || (theChar == '_')
					|| (theChar == '@') || (theChar == '.'))) {

				alert("Username Should not contain any special characters.");
				form.username.focus();
				return false;
			}
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
			<span> Welcome </span> <a id="menu"></a>
		</div>


		<div id="wrap1">
			<div id="wrap2">

				<p align="center">
					<strong>Log-in : <%=ardate%></strong>
				</p>
				<div id="leftside">
					<a id="sectionmenu"></a>


				</div>

				<div id="rightside"></div>

				<a id="main"></a>
				<div id="content">
					<form name="login" method="post" onsubmit="return checkusername()"
						action="LoginCheck">
						<table width="100%">
							<tr></tr>
							<tr></tr>
							<tr></tr>
							<tr></tr>




							<tr valign="top">
								<td colspan="2" align="center" class="menubg"><font
									color="black"><b>Sign in to <%-- <%=id %> , <%=rs.getString(2)%> --%></b></font></td>
							</tr>


							<tr>
								<td style="width: 15%">Email</td>
								<td><input type="text" name="username" maxlength="35"
									style="width: 120px" title="Enter the username"></td>
							</tr>
							<tr>
								<td>Password</td>
								<td style="width: 15%"><input type="password"
									name="password" maxlength="12" style="width: 120px"
									title="Enter the password"></td>
							</tr>
							<tr valign="top">
								<td colspan="2" align="center" class="menubg"><font
									color="red"><b>${errorMessage}</b></font></td>
							</tr>



						</table>
						<table>
							<tr align="center">
								<td align="left"><input type="submit" value="Sign In"
									name="signIn"></td>
							</tr>
							<tr>
								<td align="right"><a href="registration.jsp">Patient Registration</a></td><td> | </td>
										<td align="left"><a href="forgotPassword.jsp">
										Forgot Password</a></td>
							</tr>
														<tr>
								
							</tr>
						</table>
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

