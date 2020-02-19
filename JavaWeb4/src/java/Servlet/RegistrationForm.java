/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vutrunganh
 */
public class RegistrationForm extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegistrationForm</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegistrationForm at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String actionURL
                = "/servlet/coreservlets.RegistrationServlet";
        String firstName
                = CookieUtilities.getCookieValue(request, "firstName", "");
        String lastName
                = CookieUtilities.getCookieValue(request, "lastName", "");
        String emailAddress
                = CookieUtilities.getCookieValue(request, "emailAddress",
                        "");
        String docType
                = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 "
                + "Transitional//EN\">\n";
        String title = "Please Register";
        out.println(docType
                + "<HTML>\n"
                + "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n"
                + "<BODY BGCOLOR=\"#FDF5E6\">\n"
                + "<CENTER>\n"
                + "<H1>" + title + "</H1>\n"
                + "<FORM ACTION=\"" + actionURL + "\">\n"
                + "First Name:\n"
                + "  <INPUT TYPE=\"TEXT\" NAME=\"firstName\" "
                + "VALUE=\"" + firstName + "\"><BR>\n"
                + "Last Name:\n"
                + "  <INPUT TYPE=\"TEXT\" NAME=\"lastName\" "
                + "VALUE=\"" + lastName + "\"><BR>\n"
                + "Email Address: \n"
                + "  <INPUT TYPE=\"TEXT\" NAME=\"emailAddress\" "
                + "VALUE=\"" + emailAddress + "\"><P>\n"
                + "<INPUT TYPE=\"SUBMIT\" VALUE=\"Register\">\n"
                + "</FORM></CENTER></BODY></HTML>");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
