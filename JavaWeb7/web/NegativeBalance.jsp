<%-- 
    Document   : NegativeBalance
    Created on : Jan 18, 2020, 2:50:41 PM
    Author     : vutrunganh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
    <HEAD>
        <TITLE>You Owe Us Money!</TITLE>
        <LINK REL=STYLESHEET
              HREF="/bank-support/JSP-Styles.css"
              TYPE="text/css">
    </HEAD>
    <BODY>
        <TABLE BORDER=5 ALIGN="CENTER">
            <TR><TH CLASS="TITLE">
                    We Know Where You Live!</TABLE>
        <P>
            <IMG SRC="/bank-support/Club.gif" ALIGN="LEFT">
            <jsp:useBean id="badCustomer"
                         type="Server.BankCustomer"
                         scope="request" />
            Watch out,
            <jsp:getProperty name="badCustomer" property="firstName" />,
            we know where you live.
        <P>
            Pay us the
            $<jsp:getProperty name="badCustomer" property="balanceNoSign" />
            you owe us before it is too late!
    </BODY></HTML>
