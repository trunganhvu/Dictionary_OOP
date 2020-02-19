<%-- 
    Document   : Menu
    Created on : Feb 7, 2020, 9:28:31 PM
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
        <%@ page import="java.util.*" %> 
        <jsp:useBean id="dbBean" scope="application" class="controller.DbBean"/> 
        <%
            String base = (String) application.getAttribute("base");
        %> 
        <TABLE CELLSPACING="0" CELLPADDING="5" WIDTH="150" BORDER="0"> 
            <TR> 
                <TD BGCOLOR="F6F6F6"> 
                    <FONT FACE="Verdana">Search</FONT> 
                    <FORM action="SearchResults.jsp"> 
                        <!--<INPUT TYPE="HIDDEN" NAME="action" VALUE="search">--> 
                        <INPUT TYPE="TEXT" NAME="keyword" SIZE="10"> 
                        <INPUT type="SUBMIT" VALUE="Go"> 
                    </FORM> 
                </TD> 
            </TR> 
            <TR> 
                <TD BGCOLOR="F6F6F6"><FONT FACE="Verdana">Categories:</FONT></TD>   
            </TR> 
            <TR VALIGN="TOP"> 
                <TD BGCOLOR="F6F6F6"> 
                    <%
                        Hashtable categories = dbBean.getCategories();
                        Enumeration categoryIds = categories.keys();
                        while (categoryIds.hasMoreElements()) {
                            Object categoryId = categoryIds.nextElement();
                            out.println("<A HREF=" + "BrowseCatalog.jsp?categoryId="
                                    + categoryId.toString() + ">"
                                    + categories.get(categoryId)
                                    + "</A><BR>");
                        }
                    %> 
                </TD> 
            </TR> 
        </TABLE>
    </body>
</html>
