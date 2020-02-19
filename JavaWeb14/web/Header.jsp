<%-- 
    Document   : Header
    Created on : Feb 7, 2020, 9:27:55 PM
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
            String base = (String) application.getAttribute("base");
            String imageUrl = (String) application.getAttribute("imageUrl");
        %> 
        <TABLE WIDTH="740" CELLPADDING="0" 
               HEIGHT="75" CELLSPACING="0" BORDER="0"> 
            <TR> 
                <TD ALIGN="left" BGCOLOR="F6F6F6"> 
                    <FONT FACE="Verdana" SIZE="4"><a href="Default.jsp">Burnaby e-Mall</a></FONT> 
                </TD> 
                <TD ALIGN="RIGHT" BGCOLOR="F6F6F6"> 
                    <A HREF="ShoppingCart.jsp">
                        <IMG BORDER="0" SRC="#"></A> &nbsp;&nbsp;&nbsp; 
                </TD> 
            </TR> 
        </TABLE>
    </body>
</html>
