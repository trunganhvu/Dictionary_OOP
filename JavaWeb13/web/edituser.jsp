<%-- 
    Document   : edituser
    Created on : Feb 7, 2020, 8:10:01 PM
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
        <%@page import="src.*" %>
        <jsp:useBean id="u" class="src.User"></jsp:useBean>
        <jsp:setProperty property="*" name="u"></jsp:setProperty>
        <% 
            int update = UserDao.update(u);
            response.sendRedirect("viewusers.jsp");
        %>
    </body>
</html>
