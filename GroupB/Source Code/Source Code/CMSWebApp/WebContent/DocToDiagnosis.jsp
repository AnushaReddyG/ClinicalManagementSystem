<%@ page import="java.util.Date"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Clinic Management System - Diagnosis</title>
<link rel="stylesheet" href="Style.css" type="text/css" />
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
<%@include file="session.jsp"%>
<%@page import="com.dop.cms.client.DocPatAppoint"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Iterator"%>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
<script>
	function redirect(elem) {
		elem.setAttribute("action", "doctorIndex.jsp");
		elem.submit();
	}
</script>
</head>

<body>
	<%
		String apptId = request.getParameter("appointId");
	%>
	<%
		String pName = request.getParameter("patientName");
	%>
	<%
		String doctorId = request.getParameter("doctorId");
	%>

	<div id="container">
		<a id="top"></a>
		<p class="hide">
			Skip to: <a href="#menu">site menu</a> | <a href="#sectionmenu">section
				menu</a> | <a href="#main">main content</a>
		</p>

		<div id="sitename">
			<h1>Clinic Management System</h1>
			<span> Diagnosis </span> <a id="menu"></a>
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
				<div id="content">
					<h1></h1>
					<form name="PatDiagnosis" action="DocAfterDiagnosisServ"
						method="post">
						<fieldset>
							<legend>Submit for Lab Test</legend>
							<table cellpadding="5" cellspacing="0" width="25%"
								style="padding-left: 50px;">
								<tr>
									<td>Appointment Id</td>
									<td><input id="apptId" name="apptIdParam"
										value="<%=apptId%>" readonly="true"></td>
								</tr>
								<tr>
									<td>Patient Name</td>
									<td><input id="patName" name="patNameParam"
										value="<%=pName%>" readonly="true"></td>
								</tr>
								<tr>
									<td>Lab Assistant</td>
									<td><select id="labAssist" name="labAssistParam">
											<option value="none">Select a Lab Assistant</option>
											<%
												HashMap<Integer, String> labAssistNames = new HashMap<Integer, String>();
												DocPatAppoint docPat = new DocPatAppoint();
												labAssistNames = docPat.getLabAssistDet();
												Iterator itr = labAssistNames.keySet().iterator();
												while (itr.hasNext()) {
													int key = (Integer) itr.next();
											%><option value="<%=key%>"><%=labAssistNames.get(key)%></option>
											<%
												}
											%>
									</select></td>
								</tr>
								<tr>
									<td>Test Type</td>
									<td><select id="testType" name="testTypeParam">
											<option value="0">Select a Test Type</option>
											<option value="1">Blood test</option>
											<option value="2">Amylase test</option>
											<option value="3">Electrolytes test</option>
											<option value="4">Flu test</option>
											<option value="5">Urinalysis test</option>
									</select></td>
								</tr>
								<tr>
									<td><input type="submit" value="submit"></td>
								</tr>
								<tr>
									<td><input type="hidden" type="text" id="doctorIdparam"
										name="doctorId" value="<%=doctorId%>" /></td>
								</tr>
							</table>
						</fieldset>
					</form>
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
