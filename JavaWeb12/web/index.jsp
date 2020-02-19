<%-- 
    Document   : index
    Created on : Feb 6, 2020, 9:28:15 PM
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
        <form action="Controller" method="post">
            
            <%
                if (request.getParameter("err").equals("1")){    
//                    out.print("UserName:<input type=\"text\" name=\"username\""
//                            + "value=\"" + request.getHeader("username")
//                            + "\">" + "<br>");
//                    out.print("Password: <input type=\"password\" name=\"password\"");
            %>
            UserName: <input type="text" name="username" value="x"><br>
            PassWord: <input type="password" name="password"><br>
            
            <% 
                }
            %>
            <%
//                if (!request.getParameter("err").equals("1")){
            %>   
                UserName: <input type="text" name="username"><br>
                PassWord: <input type="password" name="password"><br>
            <%
//                }
            %>
            <input type="submit" value="Login">
        </form>
    </body>
</html>
