<%-- 
    Document   : Simplepage
    Created on : Jan 30, 2020, 2:53:07 PM
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
        <%
            //while (true) {
            response.setIntHeader("Refresh", 1);
            java.util.Calendar now = java.util.Calendar.getInstance();
            int hour = now.get(java.util.Calendar.HOUR_OF_DAY);
            int min = now.get(java.util.Calendar.MINUTE);
            int second = now.get(java.util.Calendar.SECOND);
            if (hour < 10) {
                out.print("0" + hour);
            } else {
                out.print(hour);
            }
            out.print(":");
            if (min < 10) {
                out.print("0" + min);
            } else {
                out.print(min);
            }
            out.print(":");
            if (second < 10) {
                out.print("0" + second);
            } else {
                out.print(second);
            }
            //}
%>
    </body>
</html>
