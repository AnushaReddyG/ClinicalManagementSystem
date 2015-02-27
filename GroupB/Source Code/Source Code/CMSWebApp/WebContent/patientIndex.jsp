<%-- 
    Document   : doctorIndex
    Created on : Oct 13, 2014, 7:45:05 PM
    Author     : Ipsit
--%>
<%@page import="com.dop.cms.PatWs.PatientServiceStub.PatientDetails"%>
<%@page import="com.dop.cms.client.PatientAppoint"%>
<%@ page import="java.util.Date"%>
<%@page import="java.sql.*"%>
<%@page import="java.net.ConnectException"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.dop.cms.PatWs.PatientServiceStub.PatientApptDetails"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="session.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<%
	int patientId1 = Integer.parseInt(session.getAttribute("patientId")
			.toString());
	
%>



<html>
<head>
<title>Clinic Management System - Homepage Patient</title>
<link rel="stylesheet" href="Style.css" type="text/css" />
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">

<script>
	$(function() {

		//split into different jQuery tabs
		var isedit = 0;

		$("#content").tabs();

		//end of code to split into jQuery tabs

		$('table.AppointmentTable')
				.each(
						function() {
							var currentPage = 0;
							var numPerPage = 5;
							var $table = $(this);
							$table.bind('repaginate', function() {
								$table.find('tbody tr').hide().slice(
										currentPage * numPerPage,
										(currentPage + 1) * numPerPage).show();
							});
							$table.trigger('repaginate');
							var numRows = $table.find('tbody tr').length;
							var numPages = Math.ceil(numRows / numPerPage);
							var $pager = $('<div class="pager"></div>');
							for (var page = 0; page < numPages; page++) {
								$('<span class="page-number"></span>')
										.text(page + 1)
										.bind(
												'click',
												{
													newPage : page
												},
												function(event) {
													currentPage = event.data['newPage'];
													$table
															.trigger('repaginate');
													$(this).addClass('active')
															.siblings()
															.removeClass(
																	'active');
												}).appendTo($pager).addClass(
												'clickable');
							}
							$pager.insertAfter($table).find(
									'span.page-number:first')
									.addClass('active');
						});

		$("#datepicker").datepicker({
			minDate : -0,
			maxDate : "+1Y +1M"
		});

		//to edit Patient Details

		$('#PatientEditButton')
				.click(
						function() {
							isedit = 1;
							$("#p_name").attr("readonly", false).removeClass(
									"disabledbackground").addClass(
									"enabledbackground");
							$("#p_address").attr("readonly", false)
									.removeClass("disabledbackground")
									.addClass("enabledbackground");
							$("#p_phone").attr("readonly", false).removeClass(
									"disabledbackground").addClass(
									"enabledbackground");
							$("#p_email").attr("readonly", false).removeClass(
									"disabledbackground").addClass(
									"enabledbackground");
						});

		$('#updateform').click(function() {
			if (isedit > 0) {
				/* alert("Saved Succcessfully!"+isedit); */
				$("#PatientDetails").find("form").submit();
			}

			else {
				alert("Edit Patient Details!" + isedit);
				isedit = 0;
			}
		});

		$('#spec')
				.change(
						function() {
							var dd = $('#doctors');
							spec = $('#spec').val();

							$('#doctors').empty();
							var newOption = $('<option value="0">Select the doctor</option>');
							$('#doctors').append(newOption);

							if (spec == 'none')
								alert("Please select a Specialization!");
							else {

								//alert("value sent to Sevlet"+spec);
								$
										.getJSON(
												'GetDocsBySpec?dd=' + doctors
														+ '&val=' + spec,
												function(opts) {
													$('>option', dd).remove(); //to remove previous value
													if (opts) {
														dd
																.append($(
																		'<option/>')
																		.val(
																				'0')
																		.text(
																				"Select Doctor"));
														$
																.each(
																		opts,
																		function(
																				key,
																				value) {

																			dd
																					.append($(
																							'<option/>')
																							.val(
																									key)
																							.text(
																									value));
																		});
													} else {
														dd
																.append($(
																		'<option/>')
																		.text(
																				"Please select Specialization"));
													}

												});

							}

						});

		$('#doctors')
				.change(
						function() {
							var doctorid = $('#doctors').val();
							var dd = $('#appointment');
							spec = $('#doctors').val();

							$('#appointment').empty();
							var newOption = $('<option value="0">Select Appointment Time</option>');
							dd.append(newOption);

							if (spec == 'none')
								alert("Please select a Doctor!");
							else {

								//alert("value sent to Sevlet"+spec);
								$.getJSON('GetAppointSlotByDocidServ?dd='
										+ doctors + '&val=' + spec, function(
										opts) {
									$('>option', dd).remove(); //to remove previous value
									if (opts) {
										dd.append($('<option/>').val('0').text(
												"Select Appointment Time"));
										$.each(opts, function(key, value) {

											dd.append($('<option/>')
													.text(value));
										});
									} else {
										dd.append($('<option/>').text(
												"Select Appointment Time"));
									}

								});

							}

						});

	});

	function validateAppointDetails() {
		//alert((document.forms["patientAppoint"]["dateParam"].value));
		if (document.forms["patientAppoint"]["dateParam"].value == null
				|| document.forms["patientAppoint"]["dateParam"].value == "mm-dd-yyyy") {
			alert("Date cannot be Empty");
			return false;
		} else if (document.forms["patientAppoint"]["specParam"].value == "none") {
			alert("Please select a specialization");
			return false;
		} else if (document.forms["patientAppoint"]["doctorParam"].value == "none") {
			alert("Please select a doctor");
			return false;
		} else if (document.forms["patientAppoint"]["timeParam"].value == 0) {
			alert("Please select the appointment time");
			return false;
		} else if (document.forms["patientAppoint"]["severityParam"].value == 0) {
			alert("Please select the severity");
			return false;
		}

		else {
			/* alert(document.forms["patientAppoint"]["severityParam"].value); */
			return true;
		}
	}
</script>
<style>
.mandatory {
	color: red;
}

div.pager {
	text-align: center;
	margin: 1em 0;
}

div.pager span {
	display: inline-block;
	width: 1.8em;
	height: 1.8em;
	line-height: 1.8;
	text-align: center;
	cursor: pointer;
	background: #c0c0c0;
	color: #fff;
	margin-right: 0.5em;
}

div.pager span.active {
	background: #716B6B;
}

td, th {
	text-align: left;
}

.disabledbackground {
	background-color: #F9F9F9;
}

.enabledbackground {
	background-color: #FFFFFF;
}
</style>
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
			<span> Homepage Patient </span> <a id="menu"></a>
		</div>

		<div id="nav">
			<ul>
				<li id="current"><a href="BillingHistory.jsp">History and
						Billing Details</a></li>
				<li id="current"><a href="ChangePassword.jsp">Change
						Password</a></li>
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
					style="margin-left: 80px;  width: 550px;">
					<ul>
						<li><a href="#PatientDetails">Patient Details</a></li>
						<li><a href="#AppointmentDetails">Appointment Details</a></li>
						<li><a href="#BookAppoinment">Book Appointment</a></li>

					</ul>

					<div id="PatientDetails">
						<form name="patientAppoint" action="UpdatePatDetServ"
							method="post">
							<fieldset>
								<legend>Patient Details</legend>
								<%
									PatientAppoint patAppt1 = new PatientAppoint();
									PatientDetails patDetails = new PatientDetails();

									patDetails = patAppt1.getPatDetails(patientId1);
								%>
								<table cellpadding="5" cellspacing="0" width="25%"
									style="padding-left: 50px; width: 400px;">
									<tr>
										<td>Your Name</td>
										<td><input id="p_name" name="nameParam"
											value="<%=patDetails.getPatName()%>" readonly="true"
											class="disabledbackground" style="width: 250px;"></td>
									</tr>
									<tr>
										<td>Your Address</td>
										<td><input id="p_address" name="addressParam"
											value="<%=patDetails.getPatAddress()%>" readonly="true"
											class="disabledbackground" style="width: 250px;"></td>
									</tr>
									<tr>
										<td>Your Email</td>
										<td><input id="p_email" name="emailParam" readonly="true"
											value="<%=patDetails.getPatEmail()%>"
											class="disabledbackground" style="width: 250px;"></td>
									</tr>
									<tr>
										<td>Your Phone</td>
										<td><input id="p_phone" name="phoneParam" readonly="true"
											value="<%=patDetails.getPatPhone()%>"
											class="disabledbackground" style="width: 250px;"></td>
									</tr>
									<tr>
										<td><input type="hidden" id="patientId" name="patientId"
											value="<%=patientId1%>" /></td>
									</tr>
									<tr>
										<td><input type="button" value="Edit"
											id="PatientEditButton" /></td>
										<td><input type="button" value="Update" id="updateform" />
										</td>
									</tr>
								</table>
							</fieldset>
							<div style="color: #FF0000; padding-left: 40px;">${updateError}</div>
						</form>
					</div>

					<div id="AppointmentDetails">
						<fieldset>
							<legend>Appointment Details</legend>
							<%
								PatientAppoint patAppt = new PatientAppoint();
								PatientApptDetails patApptDetArray[] = new PatientApptDetails[] {};
								int patientId = Integer.parseInt(session.getAttribute("patientId")
										.toString());
								patApptDetArray = patAppt.getPatApptDet(patientId);
							%>


							<table class="AppointmentTable" cellpadding="5" cellspacing="0"
								width="450px" style="padding-left: 30px;">
								<thead>
									<tr>
										<TH scope="col">Doctor Name</TH>
										<TH scope="col">Appointment Date</TH>
										<TH scope="col">Appointment Time</TH>
										<TH scope="col">Severity</TH>
									</tr>
								</thead>


								<%
								if(patApptDetArray!=null)
									for (int i = 0; i < patApptDetArray.length; i++) {
								%>
								<tbody>
									<TR>
										<TD><%=patApptDetArray[i].getDocName()%></td>
										<TD><%=patApptDetArray[i].getAppointDate()%></TD>
										<TD><%=patApptDetArray[i].getAppointTime()%></TD>
										<TD><%=patApptDetArray[i].getSeverity()%></TD>

									</TR>
								</tbody>
								<%
									}
								%>


							</table>

						</fieldset>
					</div>

					<div id="BookAppoinment">
						<jsp:useBean id="patient"
							class="com.dop.cms.client.PatientAppoint" scope="page" />
						<jsp:setProperty name="patient" property="*" />



						<form name="patientAppoint" action="PatientServlet" method="post"
							onsubmit="return validateAppointDetails()">

							<fieldset style="width: 400px; margin-left: 34px;">
								<legend>Book Appointment</legend>
								<table cellpadding="5" cellspacing="0" width="25%"
									style="padding-left: 50px;">
									<tr>
										<td>Doctor Specialization<span class="mandatory">*</span></td>
										<td><select id="spec" name="specParam">
												<option value="none">Select a Specialization</option>
												<c:forEach var="specialization"
													items="${patient.specialization}">
													<option value="${specialization}">${specialization}</option>
												</c:forEach>
										</select></td>

									</tr>
									<tr>
										<td>Doctor Name <span class="mandatory">*</span></td>
										<td><select id="doctors" name="doctorParam">
												<option value="0">Select the doctor</option>
												<%-- <c:forEach var="docName" items="${patient.docNames}">
												<option value="${docName.key}">${docName.value}</option>
											</c:forEach> --%>
										</select></td>
									</tr>
									<tr>
										<td>Appointment Date<span class="mandatory">*</span></td>
										<td><input type="text" id="datepicker" name="dateParam"
											value="mm-dd-yyyy" readonly="true" /></td>
									</tr>
									<tr>
										<td>Appointment Time <span class="mandatory">*</span></td>
										<td><select id="appointment" name="timeParam">
												<option value="none">Select the Appointment Time</option>
												<%-- <c:forEach var="timings" items="${patient.timings}">
												<option value="${timings}">${timings}</option>
											</c:forEach> --%>
										</select></td>
									</tr>
									<tr>
										<td>Severity <span class="mandatory">*</span></td>
										<td><select id="severity" name="severityParam">
												<option value="0">Select the Severity</option>
												<option value="1">level 1</option>
												<option value="2">level 2</option>
												<option value="3">level 3</option>
												<option value="4">level 4</option>
												<option value="5">level 5</option>
										</select></td>
									</tr>

									<tr>
										<td><input type="hidden" id="patientId" name="patientId"
											value="<%=patientId%>" /></td>
									</tr>
									<tr>
										<td><input type="submit" value="submit"></td>
									</tr>

								</table>
								<div style="color: #FF0000; padding-left: 40px;">${errorMessage}</div>
								<%-- 	<div style="color: #FF0000; padding-left: 40px;"><%String e = (String) session.getAttribute("noAvailability");
							if(e!= null)
							{
							out.print(e);
							}else{
							out.print("");
							}%></div> --%>
								<div style="color: #FF0000; padding-left: 40px;">
									<%
										String e1 = (String) session.getAttribute("noDocAvail");
										if (e1 != null) {
											out.print(e1);
										} else {
											out.print("");
										}
									%>
								</div>
							</fieldset>

						</form>
						<div style="color: #FF0000; padding-left: 40px;">
							<%
								String e = (String) session.getAttribute("noAvailability");
								if (e != null) {
									out.print(e);
								} else {
									out.print("");
								}
							%>
						</div>
					</div>


				</div>
			</div>
			<div id="footer">
				CS 441 Project<br />
			</div>
		</div>
	</div>
</body>

</html>
