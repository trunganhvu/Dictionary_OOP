<%-- 
    Document   : welcome
    Created on : Feb 4, 2020, 9:14:28 AM
    Author     : vutrunganh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            response.sendRedirect("https://www.google.com/search?q=" + request.getParameter("input"));
        %>
        
        <!--<a href="nextpage.jsp">the next page jsp</a>-->
    </body>
</html>
