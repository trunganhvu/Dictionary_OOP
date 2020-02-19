<%-- 
    Document   : HighBalance
    Created on : Jan 18, 2020, 2:56:36 PM
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
        <CENTER><IMG SRC="/bank-support/Sailing.gif"></CENTER>
        <BR CLEAR="ALL">
        <jsp:useBean id="eliteCustomer"
                     type="Server.BankCustomer"
                     scope="request" />
        It is an honor to serve you,
        <jsp:getProperty name="eliteCustomer" property="firstName" />
        <jsp:getProperty name="eliteCustomer" property="lastName" />!

        <P>
            Since you are one of our most valued customers, we would like
            to offer you the opportunity to spend a mere fraction of your
            $<jsp:getProperty name="eliteCustomer"  property="balance" />
            on a boat worthy of your status. Please visit our boat store for
            more information.
    </BODY></HTML>