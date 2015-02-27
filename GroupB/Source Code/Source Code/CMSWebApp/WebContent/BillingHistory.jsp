<%-- 
    Document   : doctorIndex
    Created on : Oct 13, 2014, 7:45:05 PM
    Author     : Ipsit
--%>
<%@ page import="java.util.Date"%>
<%@page import="java.sql.*"%>
<%@page import="java.net.ConnectException"%>
<%@include file="session.jsp"%>
<%@page import="com.dop.cms.client.PatientAppoint"%>
<%@page import="com.dop.cms.PatWs.PatientServiceStub.PatientApptDetails"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Clinic Management System - Billing History</title>
<link rel="stylesheet" href="Style.css" type="text/css" />
<script>
	function redirect(elem) {
		elem.setAttribute("action", "patientIndex.jsp");
		elem.submit();
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
			<span> Billing and History </span> <a id="menu"></a>
		</div>

		<div id="nav">
			<ul>

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
					<legend>Appointment Details</legend>
					<%
							PatientAppoint patAppt = new PatientAppoint();
							PatientApptDetails patApptDetArray[] = new PatientApptDetails[]{};
						    int patientId = Integer.parseInt(session.getAttribute("patientId").toString());
						    patApptDetArray = patAppt.getPatApptDet(patientId);

						%>


					<table class="AppointmentTable" cellpadding="5" cellspacing="0"
						width="450px" style="padding-left: 30px;">
						<thead>
							<tr>
								<TH scope="col">Doctor Name</TH>
								<TH scope="col">Appointment Date</TH>
								<TH scope="col">Appointment Time</TH>
								<TH scope="col">Actions</TH>
							</tr>
						</thead>

						<%
								if(patApptDetArray!=null)
								for(int i =0 ; i < patApptDetArray.length ; i++)
								{
							%>
						<tbody>
							<TR>
								<TD><%=patApptDetArray[i].getDocName()%></td>
								<TD><%=patApptDetArray[i].getAppointDate()%></TD>
								<TD><%=patApptDetArray[i].getAppointTime()%></TD>
								<TD><form name="pdf" method="post" action="PDFRender">
										<input type="hidden" value="<%=patientId%>" name="patientId"><input
											type="hidden"
											value="<%=patApptDetArray[i].getAppointDate()%>" name="appt"><input
											type="submit" value="PDF" name="pdf">
									</form>
									<!-- <form name="email" method="post" action="PDFRender"><input type="submit" value="Email"
									name="pdf"></form></TD> -->
							</TR>
						</tbody>
						<%
								}
							%>


					</table>
					<p>
					<p>
					<p>
					<p>
					<form id="main" method="post" name="main" action=""
						onsubmit="redirect(this);">
						<input type="submit" name="submit" value="Back to Index Page" />
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
