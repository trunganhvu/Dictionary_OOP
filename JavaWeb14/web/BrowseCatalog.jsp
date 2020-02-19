<%-- 
    Document   : BrowseCatalog
    Created on : Feb 7, 2020, 9:32:23 PM
    Author     : vutrunganh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="src.Product" %> 
<%@ page import="java.sql.*" %> 
<%@ page import="java.util.*" %> 
<jsp:useBean id="dbBean" scope="application" class="controller.DbBean"/> 
<%
    String base = (String) application.getAttribute("base");
%> 
<HTML> 
    <HEAD> 
        <TITLE>Browse Catalog</TITLE> 
    </HEAD> 
    <BODY> 
        <TABLE> 
            <TR> 
                <TD COLSPAN=2><jsp:include page="Header.jsp" flush="true"/></TD> 
            </TR> 
            <TR> 
                <TD><jsp:include page="Menu.jsp" flush="true"/></TD> 
                <TD VALIGN="TOP"> 
                    <%
                        String categoryId = request.getParameter("categoryId");
                        if (categoryId != null && !categoryId.trim().equals("")) {
                    %> 
                    <TABLE> 
                        <TR> 
                            <TD><FONT FACE="Verdana" SIZE="3"><B>Name</B></FONT></TD> 
                            <TD><FONT FACE="Verdana" SIZE="3"><B>Description</B></FONT></TD> 
                            <TD><FONT FACE="Verdana" SIZE="3"><B>Price</B></FONT></TD> 
                            <TD><FONT FACE="Verdana" SIZE="3"><B>Details</B></FONT></TD> 
                        </TR> 
                        <%
                            ArrayList products = dbBean.getProductsInCategory(categoryId);
                            Iterator iterator = products.iterator();
                            while (iterator.hasNext()) {
                                Product product = (Product) iterator.next();
                        %> 
                        <TR> 
                            <TD><FONT FACE="Verdana" SIZE="2"><%=product.name%></FONT></TD> 
                            <TD><FONT FACE="Verdana" SIZE="2"><%=product.description%></FONT></TD> 
                            <TD><FONT FACE="Verdana" SIZE="2"><%=product.price%></FONT></TD> 
                            <!--<TD><A HREF="<%=base%>?action=productDetails&productId=<%=product.id%>">--> 
                            <TD><A HREF="ProductDetails.jsp?productId=<%=product.id%>">
                                    <FONT FACE="Verdana" SIZE="2">Details</FONT></A></TD> 
                        </TR> 
                        <%
                                }
                            } else
                                out.println("Invalid category.");
                        %> 
                </TD> 
            </TR> 
        </TABLE> 
    </BODY> 
</HTML>
