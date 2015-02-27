<%-- 
    Document   : logout
    Created on : Oct 19, 2014, 5:31:25 PM
    Author     : Ipsit
--%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%
	request.setAttribute("errorMessage", "You have been successfully logged out");
	session.setAttribute("loginstatus", "0");
	request.getRequestDispatcher("/front.jsp").forward(request,
			response);
%>