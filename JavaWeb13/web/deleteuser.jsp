<%-- 
    Document   : deleteuser
    Created on : Feb 7, 2020, 8:15:16 PM
    Author     : vutrunganh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP delete user</title>
    </head>
    <body>
        <%@page import="src.*" %>
        <jsp:useBean id="u" class="src.User"></jsp:useBean>
        <jsp:setProperty property="*" name="u"></jsp:setProperty>
        
        <% 
            UserDao.delete(u);
            response.sendRedirect("viewusers.jsp");
        %>
    </body>
</html>
