<%-- 
    Document   : doctorIndex
    Created on : Oct 13, 2014, 7:45:05 PM
    Author     : Ipsit
--%>
<%@ page import="java.util.Date"%>
<%@page import="java.sql.*"%>
<%@page import="java.net.ConnectException"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">





<html>
<head>
<title>Clinic Management System - Homepage Staff</title>
<link rel="stylesheet" href="Style.css" type="text/css" />
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
<script>
	$(function() {

		$("#date").datepicker({
			minDate : -0,
			maxDate : "+1Y +1M"
		});

		/* $("#appointmentdate").change(function(){
		  
		  alert("change!!");
		}); */

	});

	function validateAppointDetails() {
		//alert((document.forms["patientAppoint"]["dateParam"].value));
		if (document.forms["patientAppoint"]["dateParam"].value == null
				|| document.forms["patientAppoint"]["dateParam"].value == "") {
			alert("Date cannot be Empty");
			return false;

		}

		else {
			return true;
		}
	}
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
			<span> Homepage Staff </span> <a id="menu"></a>
		</div>

		<div id="nav">
			<ul>
				<li id="current"><a href="staffIndex.jsp">Front page</a></li>
				<li><a href="logout.jsp">Logout</a></li>

			</ul>
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
				<div id="content"
					style="margin-left: 100px; height: 450px; width: 550px;">

					<form id="form1" name="form1" method="post"
						action="StaffServletPath">
						<fieldset style="width: 400px; margin-left: 50px;">
							<legend>Billing Information</legend>
							<table cellpadding="5" cellspacing="0" width="25%"
								style="padding-left: 50px;">
								<tr>
									<td>Patient</td>
									<td><input type="text" name="patient_name"
										id="patient_num" /></td>
								</tr>
								<tr>
									<td>Date</td>
									<td><input type="text" name="date" id="date" /></td>
								</tr>

								<tr>
									<td></td>
								</tr>
								<tr>
									<td><input type="submit" value="submit"></td>
								</tr>

							</table>

						</fieldset>

					</form>


				</div>
			</div>
			<div id="footer">
				&copy; 2014 Ipsit Patra<br />
			</div>
		</div>
	</div>
</body>

</html>
