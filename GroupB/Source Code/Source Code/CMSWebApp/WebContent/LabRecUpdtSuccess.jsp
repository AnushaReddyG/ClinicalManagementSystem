<%-- 
    Document   : doctorIndex
    Created on : Oct 13, 2014, 7:45:05 PM
    Author     : Ipsit
--%>
<%@ page import="java.util.Date"%>
<%@page import="java.sql.*"%>
<%@include file="session.jsp"%>
<%@page import="java.net.ConnectException"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">





<html>
<head>
<title>Clinic Management System - Homepage Lab</title>
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
				<div id="content"
					style="margin-left: 100px; width: 550px;">

					<fieldset style="width: 400px; margin-left: 50px;">
						<legend>Success</legend>
						<p>The entered lab records have been updated</p>

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
