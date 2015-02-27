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



<html>
<head>
<title>Clinic Management System - Prescription</title>
<link rel="stylesheet" href="Style.css" type="text/css" />
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
<%@include file="session.jsp"%>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
<script>
	function redirect(elem) {
		elem.setAttribute("action", "doctorIndex.jsp");
		elem.submit();
	}

	$(function() {
		$(document)
				.ready(
						function() {
							var i = $('input').size() + 1;

							$('#add')
									.click(
											function() {

												$(
														'<table cellpadding="5" cellspacing="0" width="25%" style="padding-left: 50px;"><tr><td> Medicine Name </td><td><input type="text" class="field" name="dynamic[]"/></td></tr><tr><td> Quantity </td><td><input type="text" class="field1" name="dynamic1[]"</td></tr></table>')
														.fadeIn('slow')
														.appendTo('.inputs');
												/* $('<table cellpadding="5" cellspacing="0" width="25%" style="padding-left: 50px;">').fadeIn('slow').appendTo('.inputs');
												$('<tr>').appendTo('.inputs');
												$('<td> Medicine Name </td>').appendTo('.inputs');
												$('<td><input type="text" class="field" name="dynamic[]"/></td>').fadeIn('slow').appendTo('.inputs');
												$('</tr>').fadeIn('slow').appendTo('.inputs');
												$('<tr>').fadeIn('slow').appendTo('.inputs');
												$('<td> Quantity </td>').fadeIn('slow').appendTo('.inputs');
												$('<td><input type="text" class="field1" name="dynamic1[]"/></td>').fadeIn('slow').appendTo('.inputs');
												$('</tr>').fadeIn('slow').appendTo('.inputs');
												$('</table>').fadeIn('slow').appendTo('.inputs'); */

											});

							/* $('#remove').click(function() {
								if(i > 1) {
								$('.field:last').remove();
								 i--;
								}
							});
							
							$('#reset').click(function() {
							    while(i > 2) {
							        $('.field:last').remove();
							        i--;
							    }
							}); */

							$('#prescribeform')
									.click(
											function() {

												var medName = [];
												var prescription = [];
												var error = 0;
												$.each($('.field'), function() {
													if ($(this).val() == "") {
														error = 1;
													} else {
														medName.push($(this)
																.val());
													}

												});

												$
														.each(
																$('.field1'),
																function() {
																	if ($(this)
																			.val() == "") {
																		error = 1;
																	} else {
																		prescription
																				.push($(
																						this)
																						.val());
																	}
																});

												if (error == 1) {
													alert("Please enter both the medicine and Prescription");
												} else {

													var str = medName + ","
															+ prescription;
													document
															.getElementById("strToServParam").value = str;
													$("#PatPresc").find("form")
															.submit();
												}

											});

						});

	});
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
			<span> Prescription </span> <a id="menu"></a>
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
					<form name="PatPrescrip" action="DocAfterPrescipServ" method="post">
						<fieldset>
							<legend>Prescription Details</legend>

							<div class="inputs">
								<table cellpadding="5" cellspacing="0" width="25%"
									style="padding-left: 50px;">
									<tr>
										<td>Medicine name</td>
										<td><input type="text" name="dynamic[]" class="field">
										</td>
									</tr>
									<tr>
										<td>Quantity</td>
										<td><input type="text" name="dynamic1[]" class="field1">
										</td>
									</tr>
								</table>
							</div>
							<div>
								<a href="#" id="add">-Add another set of medicines-</a>
							</div>
							<textarea name="paragraph_text" cols="50" rows="10"
								placeholder="Mention any notes here..Limit to 1000 characters"></textarea>
							<input type="hidden" name="strToServ" id="strToServParam"
								value=""> <input type="hidden" name="apptId"
								id="apptIdParam" value="<%=apptId%>"> <input
								type="hidden" name="docId" id="docIdParam" value="<%=doctorId%>">
							<div>
								<input type="button" value="Prescribe" id="prescribeform"
									class="styled-button-9" />
							</div>
							<!-- <div><input name="submit" type="button" class="submit" value="Submit"></div> -->

						</fieldset>
					</form>
					<form id="main" method="post" name="main" action=""
						onsubmit="redirect(this);">
						<input type="submit" name="submit" value ="Back to Index Page" /> 
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
