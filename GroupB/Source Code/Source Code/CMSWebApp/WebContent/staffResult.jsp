<%-- 
    Document   : staffResult
    Created on : Nov 25, 2014, 7:45:05 PM
    Author     : Ipsit
--%>
<%@ page import="java.util.Date"%>
<%@page import="java.sql.*"%>
<%@page import="java.net.ConnectException"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.dop.cms.webservice.StaffServiceStub.Patient"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="session.jsp"%>
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
	function validate() {
		var r = confirm("Do you want to continue with Bill and closing the account this?")
		if (r == true)
			return true;
		else
			return false;
	}
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
				<li id="current"><a href="staffResult.jsp">Front page</a></li>
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
				<%
					Patient p = (Patient) request.getSession().getAttribute("result");
					if (p != null && p.getName()!=null) {

						String[] name = p.getName();
						String[] bill = p.getBill();
						String[] date = p.getDateL();
						String[] email = p.getEmail();
						String[] phone = p.getPhone();
						String[] address = p.getAddress();
						String[] status = p.getStatusA();
				%>
				<fieldset style="width: 650px; margin-left: 20px;">
					<legend>Details</legend>
					<table style="display: inline-block";>
						<tr>
							<td><b> Patient Name </b></td>
						</tr>
						<%
							for (int i = 0; i < name.length; i++) {
						%>
						<tr>
							<td><%=name[i]%></td>
						</tr>
						<%
							}
						%>

					</table>

					<%-- 							<table 
							style="display: inline-block;">
							<tr>
								<td><b>Bill</b></td>
							</tr>
							<%
								for (int i = 0; i < bill.length; i++) {
							%>
								<tr>
									<td>
									<%=bill[i]
									%>
									</td>
								</tr>
							<%
								}
							%>

						</table> --%>



					<table style="display: inline-block";>
						<tr>
							<td><b>Date</b></td>
						</tr>
						<%
							for (int i = 0; i < date.length; i++) {
						%>
						<tr>
							<td><%=date[i]%></td>
						</tr>
						<%
							}
						%>

					</table>


					<table style="display: inline-block";>
						<tr>
							<td><b>Email</b></td>
						</tr>
						<%
							for (int i = 0; i < email.length; i++) {
						%>
						<tr>
							<td><%=email[i]%></td>
						</tr>
						<%
							}
						%>

					</table>


					<table style="display: inline-block";>
						<tr>
							<td><b>Phone</b></td>
						</tr>
						<%
							for (int i = 0; i < phone.length; i++) {
						%>
						<tr>
							<td><%=phone[i]%></td>
						</tr>
						<%
							}
						%>

					</table>


					<table style="display: inline-block";>
						<tr>
							<td><b>Address</b></td>
						</tr>
						<%
							for (int i = 0; i < address.length; i++) {
						%>
						<tr>
							<td><%=address[i]%></td>
						</tr>
						<%
							}
						%>

					</table>
					<table style="display: inline-block";>
						<tr>
							<td><b>Billing</b></td>
						</tr>
						<%
							for (int i = 0; i < p.getPatientId().length; i++) {
						%>
						<tr>
							<td>
								<form name="pdf" method="post" action="PDFRender"
									onsubmit="return(validate());">
									<input type="hidden" value="<%=p.getPatientId()[i]%>"
										name="patientId"> <input type="hidden"
										value="<%=date[i]%>" name="appt"> <input type="hidden"
										value="yes" name="flag"> <input type="submit"
										value="Bill" name="pdf">
								</form> <%
 	}
 	
 %>
							</td>
						</tr>
					</table>
					<%} else{%>
					<p>No details currently present</p>

					<%} %>
					<%-- 	<table 
							style="display: inline-block";>
							<tr>
								<td><b>Status</b></td>
							</tr>
							<%
								for (int i = 0; i < status.length; i++) {
							%>
								<tr>
									<td>
									<%=status[i]%>
									</td>
								</tr>
							<%
								}
							%>

						</table> --%>

				</fieldset>



			</div>
			<div id="footer">
				CS 441 Project<br />
			</div>
		</div>
	</div>
</body>

</html>
