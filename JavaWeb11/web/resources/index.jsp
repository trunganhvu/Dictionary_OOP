<%-- 
    Document   : index
    Created on : Feb 4, 2020, 9:05:48 AM
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
        <%= 1==1 %>
        <%!
            int cube(int x){
                return x*x;
            }
        %>
        <% 
          out.print(cube(10));
        %>
        <% 
            int x = cube(10) * cube(2);
            System.out.println(request.getCookies());
        %>
    </body>
</html>
