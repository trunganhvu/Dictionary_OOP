<%-- 
    Document   : ProductDetails
    Created on : Feb 7, 2020, 9:33:12 PM
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
    String imageUrl = (String) application.getAttribute("imageUrl");
%> 
<HTML> 
    <HEAD> 
        <TITLE>Product Details</TITLE> 
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
                        try {
                            int productId = Integer.parseInt(request.getParameter("productId"));
                            Product product = dbBean.getProductDetails(productId);
                            if (product != null) {
                    %> 
                    <TABLE> 
                        <TR> 
                            <TD><IMG BORDER="0" WIDTH="100" SRC="<%=(imageUrl + product.id)%>.gif"></TD> 
                            <TD><B><%=product.name%></B><BR> 
                                <%=product.description%><BR> 
                                Price : $<%=product.price%></TD> 
                        </TR> 
                        <TR> 
                            <TD COLSPAN="2" ALIGN="RIGHT"> 
                                <!--<A HREF="<%=base%>?action=addShoppingItem&productId=<%=product.id%>">--> 
                                <A HREF="ShoppingCart.jsp?action=addShoppingItem&productId=<%=product.id%>"> 
                                <!--<A HREF="ShoppingDetail.jsp?productId=<%=product.id%>">--> 
                                    Add To Cart</A> 
                            </TD> 
                        </TR> 
                    </TABLE> 
                    <%
                            }
                        } catch (Exception e) {
                            out.println("Error: Invalid product identifier.");
                        }
                    %> 
                </TD> 
            </TR> 
        </TABLE> 
    </BODY> 
</HTML>
