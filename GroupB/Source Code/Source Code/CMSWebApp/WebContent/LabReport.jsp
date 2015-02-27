<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Clinic Management System - Report</title>
<%@include file="session.jsp"%>
<link rel="stylesheet" href="Style.css" type="text/css" />
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
<script>
	function redirect(elem) {
		elem.setAttribute("action", "labAssistantIndex.jsp");
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
<%



%>
	<div id="container">
		<a id="top"></a>
		<p class="hide">
			Skip to: <a href="#menu">site menu</a> | <a href="#sectionmenu">section
				menu</a> | <a href="#main">main content</a>
		</p>

		<div id="sitename">
			<h1>Clinic Management System</h1>
			<span> Report </span> <a id="menu"></a>
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
					<h1></h1>
					<fieldset>
						<legend>
							Submit Report for Patient
							<%=request.getParameter("patientId")%></legend>
						<form name="test_form" method="post" action="UploadFile"
							enctype="multipart/form-data">
							<input type="hidden" value="<%=request.getParameter("apptId")%>"
								name="apptId"> <input type="hidden"
								value="<%=request.getParameter("docId")%>" name="doctorid">
							<input type="hidden"
								value="<%=request.getParameter("patientId")%>" name="patientid">
							<input type="hidden"
								value="<%=request.getParameter("labAssistantId")%>"
								name="labAssistantId"> <input type="file" name="file" />
							<input type=submit value="Upload Report"
								style="font-style: veranda; font-size: 12px;" />
								<p style="color: red;">Max. Allowed File Size 90 kb</p>
						</form>

						<form method="post" name="form1" action='ReportSubmit'>

							<table cellpadding="5" cellspacing="0" width="25%">
								<tr>
									<td>Doctor</td>
									<td><%=request.getParameter("docId")%><input type="hidden"
										value="<%=request.getParameter("apptId")%>" name="apptId">
										<input type="hidden"
										value="<%=request.getParameter("docId")%>" name="docId">
										<input type="hidden"
										value="<%=request.getParameter("patientId")%>"
										name="patientId"> <input type="hidden"
										value="<%=request.getParameter("labAssistantId")%>"
										name="labAssistantId"></td>
								</tr>
								<!-- <tr>
									<td>Upload File</td>
									<td><input name="file" maxlength="35" /></td>
								</tr> -->
								<tr>
									<td>Report Result</td>
									<td><textarea rows="5" cols="50" name="result">Enter details</textarea>
									</td>
								</tr>

								<tr>
									<td colspan="2" align="center"><input type="submit"
										name="create" /> <input type="reset" /></td>

								</tr>

								<tr>
									<p style="color:red;">${requestScope["message"]}</p>
								</tr>

							</table>

						</form>
						<form id="main" method="post" name="main" action=""
							onsubmit="redirect(this);">
							<input type="submit" name="submit" value="Back to Index Page" />
						</form>
					</fieldset>
				</div>
			</div>
			<div id="footer">
				CS 441 Project<br />
			</div>
		</div>
	</div>
</body>

</html>