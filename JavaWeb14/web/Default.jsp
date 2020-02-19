<%-- 
    Document   : Default
    Created on : Feb 7, 2020, 9:29:15 PM
    Author     : vutrunganh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<HTML> 
    <HEAD> 
        <TITLE>Welcome</TITLE> 
    </HEAD> 
    <BODY> 
        <%@ page import="java.util.*" %> 
        <%@ page import="src.Product" %> 
        <jsp:useBean id="dbBean" scope="application" class="controller.DbBean"/>
        
        <TABLE> 
            <TR> 
                <TD COLSPAN=2><jsp:include page="Header.jsp" flush="true"/></TD> 
            </TR> 
            <TR> 
                <TD><jsp:include page="Menu.jsp" flush="true"/></TD> 
                <TD VALIGN="TOP"> 

                    <H2>Welcome to Burnaby E-Mall.</H2> 
                    <TABLE>
                        <TR> 
                            <TD><FONT FACE="Verdana" SIZE="3"><B>Name</B></FONT></TD>   
                            <TD><FONT FACE="Verdana" SIZE="3"><B>Description</B></FONT></TD> 
                            <TD><FONT FACE="Verdana" SIZE="3"><B>Price</B></FONT></TD> 
                            <TD><FONT FACE="Verdana" SIZE="3"><B>Details</B></FONT></TD> 
                        </TR> 
                        <%
                            ArrayList products = dbBean.getAllProduct();
                            Iterator iterator = products.iterator();
                            while (iterator.hasNext()) {
                                Product product = (Product) iterator.next();
                        %> 
                        <TR> 
                            <TD><FONT FACE="Verdana" SIZE="2"><%=product.name%></FONT></TD> 
                            <TD><FONT FACE="Verdana" SIZE="2"><%=product.description%></FONT></TD> 
                            <TD><FONT FACE="Verdana" SIZE="2"><%=product.price%></FONT></TD> 
                            <TD><A HREF="ProductDetails.jsp?productId=<%=product.id%>"> 
                                    <FONT FACE="Verdana" SIZE="2">Details</FONT></A></TD> 
                        </TR> 
                        <% 
                            }
                        %>
                    </TABLE>
                </TD> 
            </TR> 
        </TABLE> 
    </BODY> 
</HTML>
