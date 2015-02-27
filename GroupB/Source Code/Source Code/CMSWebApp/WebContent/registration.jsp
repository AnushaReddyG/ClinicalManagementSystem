<%-- 
    Document   : registration 
    Created on : Sept 13, 2014, 7:41:05 PM
    Author     : Ipsit
--%>
<%@ page import="java.util.Date"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Clinic Management System - New Patient</title>
<link rel="stylesheet" href="Style.css" type="text/css" />
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
<script>
	function redirect(elem) {
		elem.setAttribute("action", "front.jsp");
		elem.submit();
	}
	$(function() {
		$("#datepicker").datepicker({
			maxDate : -0
		});
	});
</script>

</head>

<body>


	<div id="container">
		<a id="top"></a>
		<p class="hide">
			Skip to: <a href="#menu">site menu</a> | <a href="#sectionmenu">section
				menu</a> | <a href="#main">main content</a>
		</p>

		<div id="sitename">
			<h1>Clinic Management System</h1>
			<span> Patient Registration </span> <a id="menu"></a>
		</div>

		<div id="nav">

			<p class="hide">
				<a href="#top">Back to top</a>
			</p>
		</div>

		<div id="wrap1">
			<div id="wrap2">



				<div id="leftside">
					<a id="sectionmenu"></a>
				</div>

				<div id="rightside"></div>

				<a id="main"></a>
				<div id="content">
					<h1>New Patient</h1>
					<form method="post" name="form1" action='PatientRegistration'>
						<fieldset>
							<legend>Add Patient</legend>
							<table cellpadding="5" cellspacing="0" width="25%">
								<tr>
									<td>First Name*</td>
									<td><input name="fname" maxlength="35" /></td>
								</tr>
								<tr>
									<td>Last Name*</td>
									<td><input name="lname" maxlength="35" /></td>
								</tr>
								<tr>
									<td>Date of Birth*</td>
									<td><input type="text" name="dob" maxlength="10"
										id="datepicker" value="mm-dd-yyyy" /></td>
								</tr>
								<tr>
									<td>Address*</td>
									<td><input name="address" maxlength="50" /></td>
								</tr>
								<tr>
									<td>Apartment No.</td>
									<td><input name="address1" maxlength="50" /></td>
								</tr>
								<tr>
									<td>Zip Code*</td>
									<td><input name="zip" maxlength="50" /></td>
								</tr>
								<tr>
									<td>Phone Number*</td>
									<td><input name="phone" maxlength="10" /></td>
								</tr>
								<tr>
									<td>E-mail*</td>
									<td><input name="email" maxlength="35" /></td>
								</tr>
								<tr>
									<td>Confirm E-mail*</td>
									<td><input name="email1" maxlength="35" /></td>
								</tr>
								<tr>
									<td>Sex*</td>
									<td><select name='sex'>
											<option value='0'>Select</option>
											<option value='Male'>Male</option>
											<option value='Female'>Female</option>
									</select></td>
								</tr>
								<tr>
								<tr>
									<td colspan="2" align="center"><input type="submit"
										name="create" /> <input type="reset" /></td>

								</tr>

							</table>

						</fieldset>
					</form>
					<form id="main" method="post" name="main" action=""
						onsubmit="redirect(this);">
						<input type="submit" name="submit" value="Back to Login Page" />
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
