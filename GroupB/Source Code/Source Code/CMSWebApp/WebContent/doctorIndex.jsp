<%-- 
    Document   : doctorIndex
    Created on : Oct 13, 2014, 7:45:05 PM
    Author     : Ipsit
--%>
<%@page import="com.dop.cms.DocWs.DoctorServiceStub.DocPatApptDetails"%>
<%@page import="com.dop.cms.client.DocPatAppoint"%>
<%@ page import="java.util.Date"%>
<%@page import="java.sql.*"%>
<%@page import="java.net.ConnectException"%>
<%@include file="session.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<%
	Date d = new Date();
	int y = d.getYear() + 1900;
	int m = d.getMonth() + 1;
	String ardate = d.getDate() + "/" + m + "/" + y;
%>



<html>
<head>
<title>Clinic Management System - Homepage Doctor</title>
<link rel="stylesheet" href="Style.css" type="text/css" />
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
<style type="text/css">
.styled-button-9 {
	-webkit-box-shadow: rgba(0, 0, 0, 0.98) 0 1px 0 0;
	-moz-box-shadow: rgba(0, 0, 0, 0.98) 0 1px 0 0;
	box-shadow: rgba(0, 0, 0, 0.98) 0 1px 0 0;
	background-color: #EEE;
	border-radius: 0;
	-webkit-border-radius: 0;
	-moz-border-radius: 0;
	border: 1px solid #999;
	color: #666;
	font-family: 'Lucida Grande', Tahoma, Verdana, Arial, Sans-serif;
	font-size: 11px;
	font-weight: 700;
	padding: 2px 6px;
	height: 28px
}
}
</style>
<script>
	/* $(function(){

		$('#diagnosisButton').click(function(){
			document.getElementById("pres_diag").value = "diag";
			$("#content").find("form").submit();
		});
		
		$('#prescriptionButton').click(function(){
			document.getElementById("pres_diag").value = "";
			$("#content").find("form").submit();
		});
	});
	 */
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
			<span> Homepage Doctor </span> <a id="menu"></a>
		</div>

		<div id="nav">
			<ul>
				<li id="current"><a href="doctorIndex.jsp">Front page</a></li>
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
				<div id="content" style="margin-left: 50px; width: 550px;">
					<!-- <form name="acceptedAppointment" action="DocDiagnosisServ"
						method="get"> -->
					<div style="color: #2EFE2E; padding-left: 40px;">${success}</div>
					<div style="color: #FF0040; padding-left: 40px;">${failure}</div>
					<fieldset>
						<legend>Accepted Appointment Details</legend>
						<%
							DocPatAppoint acceptedDetails = new DocPatAppoint();
							DocPatApptDetails acceptedDetailsArray[] = new DocPatApptDetails[] {};
							int docId1 = Integer.parseInt(session.getAttribute("doctorId")
									.toString());
							acceptedDetailsArray = acceptedDetails.getAcceptedAppoints(docId1);
						%>
						<table cellpadding="5" cellspacing="0" width="25%"
							style="padding-left: 10px;">
							<TR>
								<TH>Appointment Date</TH>
								<TH>Appointment Time</TH>

								<TH>Severity</TH>
								<TH>Patient Name</TH>
								<TH>Appointment Status</TH>
								<!-- <TH>Diagnosis</TH> -->
							</TR>
							<%
								if (acceptedDetailsArray != null)
									for (int i = 0; i < acceptedDetailsArray.length; i++) {
							%>
							<form name="acceptedAppointment" action="DocDiagnosisServ"
								method="post">
								<TR>

									<TD><%=acceptedDetailsArray[i].getApptdate()%></td>
									<TD><%=acceptedDetailsArray[i].getApptTime()%></TD>
									<TD><%=acceptedDetailsArray[i].getSeverity()%></TD>
									<TD><%=acceptedDetailsArray[i].getPatname()%></TD>
									<TD><%=acceptedDetailsArray[i].getApptStatus()%></TD>

									<td><input type="hidden" type="text" id="pres_diag"
										name="P_D" value="" /></td>
									<td><input type="hidden" type="text" id="patientNamepar"
										name="patientName"
										value="<%=acceptedDetailsArray[i].getPatname()%>" /></td>
									<td><input type="hidden" type="text" id="appointIdpar"
										name="appointId"
										value="<%=acceptedDetailsArray[i].getApptId()%>" /></td>
									<td><input type="hidden" type="text" id="doctorIdpar"
										name="doctorId"
										value="<%=acceptedDetailsArray[i].getDocId()%>" /></td>
									<td><input type="hidden" type="text" id="status"
										name="statusid"
										value="<%=acceptedDetailsArray[i].getApptStatus()%>" /></td>
									<%
										if (acceptedDetailsArray[i].getApptStatus()
														.equals("Accept")) {
									%>
									<TD><input type="submit" name="DParam" value="Diagnosis"
										id="diagnosisButton" class="styled-button-9" /></TD>
									<!-- <td><input type="hidden" type="text" id="diagnosis" name="diagP" value="d" /></td> -->
									<%
										}
									%>
									<%
										if (acceptedDetailsArray[i].getApptStatus().equals(
														"Request")) {
									%>
									<TD><input type="submit" name="PParam"
										value="Prescription" id="prescriptionButton"
										class="styled-button-9" /></TD>
									<!-- <td><input type="hidden" type="text" id="prescription" name="presP" value="d" /></td> -->
									<%
										}
									%>
								
							</form>
							<%
								if (acceptedDetailsArray[i].getApptStatus().equals(
												"Request")) {
							%>
							<td>
								<form action="DownloadReport" method="POST">
									<input type="hidden" type="text" id="doctorIdpar"
										name="doctorId"
										value="<%=acceptedDetailsArray[i].getDocId()%>" /> <input
										type="hidden" type="text" id="pid" name="pid"
										value="<%=acceptedDetailsArray[i].getPatId()%>" /> <input
										type="submit" value="Lab Report" class="styled-button-9" />
								</form>
							</td>
							<%
								}
							%>
							</TR>


							<%
								}
							%>


						</table>
						<div style="color: #FF0000; padding-left: 40px;">${updProb1}</div>
					</fieldset>
					<!-- </form> -->
					<p>
					<p>
					<p>
					<p>
						<%
							DocPatAppoint pendingDetails = new DocPatAppoint();
							DocPatApptDetails pendingDetailsArray[] = new DocPatApptDetails[] {};
							pendingDetailsArray = pendingDetails.getPendingAppoints(docId1);
						%>
					
					<form name="pendingAppointments" action="DoctorServlet"
						method="post" style="width: 490px;">
						<input type="hidden" id="doctorid" name="doctorid"
							value="<%=docId1%>" />
						<fieldset>
							<legend>Pending Appointment Requests</legend>
							<%
								if (pendingDetailsArray.length == 0) {
							%><p>No Pending Appointment Request</p>

							<%
								} else {
							%>
							<table cellpadding="5" cellspacing="0" width="25%">
								<TR>
									<TH>Appointment Date</TH>
									<TH>Appointment Time</TH>
									<TH>Severity</TH>
									<TH>Patient Name</TH>
									<TH>Action</TH>
								</TR>
								<%
									for (int i = 0; i < pendingDetailsArray.length; i++) {
								%>
								<TR>

									<TD><input type="text" name="apptdateparam"
										readonly="true"
										value="<%=pendingDetailsArray[i].getApptdate()%>"
										style="width: 80px;" /></td>
									<TD><%=pendingDetailsArray[i].getApptTime()%></TD>
									<TD><%=pendingDetailsArray[i].getSeverity()%></TD>
									<TD><input type="text" name="patientnameparam"
										readonly="true"
										value=" <%=pendingDetailsArray[i].getPatname()%>"
										style="width: 50px;" /></TD>
									<TD><select id="appointment status" name="apptstatusParam">
											<option value="Accept">Accept</option>
											<option value="Reject">Reject</option>
											<option value="Pending" selected>Pending</option>
									</select></TD>
									<td><input type="hidden" type="text" id="patientidparam"
										name="patientId"
										value="<%=pendingDetailsArray[i].getPatId()%>" /></td>
									<td><input type="hidden" type="text" id="appointidparam"
										name="appointId"
										value="<%=pendingDetailsArray[i].getApptId()%>" /></td>
									<TD><input type="submit" value="submit"
										class="styled-button-9"></TD>

								</TR>
								<%
									}
									}
								%>


							</table>
							<div style="color: #FF0000; padding-left: 40px;">${updProb}</div>
						</fieldset>
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
