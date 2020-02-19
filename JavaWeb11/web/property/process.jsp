<%-- 
    Document   : process
    Created on : Feb 4, 2020, 10:09:01 AM
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
        <jsp:useBean id="u" class="page.user"></jsp:useBean>>
        <jsp:setProperty property="*" name="u"/>
        Record<br>
        <jsp:getProperty property="name" name="u" /><br>
        <jsp:getProperty property="password" name="u" /><br>
        <jsp:getProperty property="email" name="u" />
        
    </body>
</html>
