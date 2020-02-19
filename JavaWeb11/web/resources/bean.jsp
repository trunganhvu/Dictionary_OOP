<%-- 
    Document   : bean
    Created on : Feb 4, 2020, 9:47:40 AM
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
        <h1>Hello World!</h1>
        <jsp:useBean id="obj" class="page.beanClass"/>
        
        <% 
            int m = obj.cube(10);
            out.print(m);
        %>
    </body>
</html>
