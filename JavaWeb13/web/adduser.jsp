<%-- 
    Document   : adduser
    Created on : Feb 7, 2020, 7:24:08 PM
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
        <%@page import="src.UserDao"%>
        <jsp:useBean id="u" class="src.User"></jsp:useBean>
        <jsp:setProperty property="*" name="u"/>

        <%
            int i = UserDao.save(u);
            if (i > 0) {
                response.sendRedirect("adduser-success.jsp");
            } else {
                response.sendRedirect("adduser-error.jsp");
            }
        %>

    </body>
</html>
