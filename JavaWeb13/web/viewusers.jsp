<%-- 
    Document   : viewusers
    Created on : Feb 7, 2020, 7:45:22 PM
    Author     : vutrunganh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP view users</title>
    </head>
    <body>
        <h1>Welcome back</h1>
        <%@page import="src.UserDao, java.util.*, src.User" %>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

        <h1>User list</h1>

        <%
            List<User> list = UserDao.getAllRecords();
            request.setAttribute("list", list);
        %>

        <table border="1" width="90%">  
            <tr><th>Id</th><th>Name</th><th>Password</th><th>Email</th>  
                <th>Sex</th><th>Country</th><th>Edit</th><th>Delete</th></tr>  
                    <c:forEach items="${list}" var="u">
                <tr>
                    <td>${u.getId()}</td>
                    <td>${u.getName()}</td>
                    <td>${u.getPassword()}</td>  
                    <td>${u.getEmail()}</td>
                    <td>${u.getSex()}</td>
                    <td>${u.getCountry()}</td>  
                    <td><a href="editform.jsp?id=${u.getId()}">Edit</a></td>  
                    <td><a href="deleteuser.jsp?id=${u.getId()}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
        <br><a href="adduserform.jsp">Add new user</a>
    </body>
</html>
