/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vutrunganh
 */
public class CreateCookie extends HttpServlet {

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
            out.println("<title>Servlet CreateCookie</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreateCookie at " + request.getContextPath() + "</h1>");
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
            Cookie firstName = new Cookie("first_name", request.getParameter("firstName"));
            Cookie lastName = new Cookie("last_name", request.getParameter("lastName"));
            firstName.setMaxAge(60*2);
            lastName.setMaxAge(60*2);
            response.addCookie(lastName);
            response.addCookie(firstName);
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            String title = "Setting cookie example";
            String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " +
               "transitional//en\">\n";
            out.println(docType + "<html>\n" +
                "<head>" + 
                "<title>" + title + "</title>" + 
                "</head>\n" +
                "<body bgcolor = \"#f0f0f0\">\n" + 
                "<h1 align = \"center\">" + title + "</h1>\n" +
                "<ul>\n" +
                "<li><b>First Name</b>: " + 
                     request.getParameter("firstName") + "\n" +
                "<li><b>Last Name</b>: " + 
                     request.getParameter("lastName") + "\n" + 
                "</ul>\n" +
                "</body>" + "</html>");
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
