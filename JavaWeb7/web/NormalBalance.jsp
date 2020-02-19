<%-- 
    Document   : NormalBalance
    Created on : Jan 18, 2020, 2:55:41 PM
    Author     : vutrunganh
--%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
    <HEAD>
        <TITLE>Your Balance</TITLE>
        <LINK REL=STYLESHEET
              HREF="/bank-support/JSP-Styles.css"
              TYPE="text/css">
    </HEAD>
    <BODY>
        <TABLE BORDER=5 ALIGN="CENTER">
            <TR><TH CLASS="TITLE">
                    Your Balance</TABLE>
        <P>
            <IMG SRC="/bank-support/Money.gif" ALIGN="RIGHT">
            <jsp:useBean id="regularCustomer"
                         type="Server.BankCustomer"
                         scope="request" />
        <UL>
            <LI>First name: <jsp:getProperty name="regularCustomer"
                             property="firstName" />
            <LI>Last name: <jsp:getProperty name="regularCustomer"
                             property="lastName" />
            <LI>ID: <jsp:getProperty name="regularCustomer"
                             property="id" />
            <LI>Balance: $<jsp:getProperty name="regularCustomer"
                             property="balance" />
        </UL>
    </BODY></HTML>