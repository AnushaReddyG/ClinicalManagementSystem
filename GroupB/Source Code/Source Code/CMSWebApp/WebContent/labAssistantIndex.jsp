<%-- 
    Document   : labAsistantIndex
    Created on : Oct 13, 2014, 7:45:05 PM
    Author     : Ipsit
--%>
<%@ page import="java.util.Date"%>
<%@page import="com.dop.cms.client.LabAppoint"%>
<%@page import="com.dop.cms.LabServiceStub.ListPatients"%>
<%@include file="session.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Clinic Management System - Lab Assistant Home</title>
<link rel="stylesheet" href="Style.css" type="text/css" />
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
			<span> Update the Lab Records </span> <a id="menu"></a>
		</div>

		<div id="nav">
			<ul>
				<li id="current"><a href="labAssistantIndex.jsp">Front page</a></li>
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
				<div id="content" style="margin-left: 80px; width: 550px;">
					<h1>Pending Reports</h1>
					<%
						LabAppoint labAppt = new LabAppoint();
						ListPatients[] listPatients = null;
						int labAssistantId = Integer.parseInt(session.getAttribute(
								"labAssistantId").toString());
						listPatients = labAppt.getLabApptDet(labAssistantId);
					%>


					<table class="AppointmentTable" cellpadding="5" cellspacing="0"
						width="450px" style="padding-left: 30px;">
						<thead>
							<tr>
								<TH scope="col">Patient Id</TH>
								<TH scope="col">Doctor Id</TH>
								<TH scope="col">Test Requested</TH>
								<TH scope="col">Action</TH>
							</tr>
						</thead>

						<%
						if(listPatients!=null){
							for (int i = 0; i < listPatients.length; i++) {
						%>
						<tbody>
							<TR>
								<TD><%=listPatients[i].getPatientId()%></td>
								<TD><%=listPatients[i].getDocId()%></TD>
								<TD><%=listPatients[i].getTestType()%></TD>
								<TD><form name="report" method="post"
										action="LabReport.jsp">

										<input type="hidden"
											value="<%=listPatients[i].getPatientId()%>" name="patientId">
										<input type="hidden" value="<%=listPatients[i].getDocId()%>"
											name="docId"> <input type="hidden"
											value="<%=listPatients[i].getTestType()%>" name="testId">
										<input type="hidden"
											value="<%=listPatients[i].getAppointment()%>" name="apptId">
										<input type="hidden" value="<%=labAssistantId%>"
											name="labAssistantId"> <input type="submit"
											value="Report" name="report">

									</form></TD>

							</TR>
						</tbody>
						<%
							}
							}
						else{
							%><p>No pending Reports</p><%
						}
						%>


					</table>
					<font color="red"><b>${message}</b></font>
					
				</div>
			</div>
			<div id="footer">
				CS 441 Project<br />
			</div>
		</div>
	</div>
</body>

</html>
