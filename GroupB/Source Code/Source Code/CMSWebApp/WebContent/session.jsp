<% 
    if (!session.getAttribute("loginstatus").equals("true")){
    	request.setAttribute("errorMessage", "Invalid Session, Please Login In again");
        request.getRequestDispatcher("/front.jsp").forward(request, response);
    }
%>