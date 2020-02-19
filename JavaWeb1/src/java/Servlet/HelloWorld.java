package Servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vutrunganh
 */
@WebServlet(urlPatterns = {"/HelloWorld"})
public class HelloWorld extends HttpServlet {

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
            out.println("<title>Servlet HelloWorld</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloWorld at jjj " + request.getContextPath() + "</h1>");
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
        response.setContentType("test/html");
        PrintWriter out = response.getWriter();
        String title = "Reading Three Request Parameters";
        String docType
                = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 "
                + "Transitional//EN\">\n";
//        out.println(docType
//                + "<HTML>\n"
//                + "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n"
//                + "<BODY BGCOLOR=\"#FDF5E6\">\n"
//                + "<H1 ALIGN=\"CENTER\">" + title + "</H1>\n"
//                + "<UL>\n"
//                + " <LI><B>param1</B>: "
//                + request.getParameter("param1") + "\n"
//                + " <LI><B>param2</B>: "
//                + request.getParameter("param2") + "\n"
//                + " <LI><B>param3</B>: "
//                + request.getParameter("param3") + "\n"
//                + " <LI><B>param3</B>: "
//                + request.getCookies()
//                + "</UL>\n"
//                + "</BODY></HTML>");
        out.println(docType +
                "<HTML>\n" +
                "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                "<H1 ALIGN=CENTER>" + title + "</H1>\n" +
                "<TABLE BORDER=1 ALIGN=CENTER>\n" +
                "<TR BGCOLOR=\"#FFAD00\">\n" +
                "<TH>Parameter Name<TH>Parameter Value(s)");
        Enumeration paramNames = request.getHeaderNames();
        while(paramNames.hasMoreElements()){
            String paramName = (String)paramNames.nextElement();
            out.print("<TR><TD>"+ paramName + "<TD>");
            String[] paramValues =request.getParameterValues(paramName);
            if(paramValues.length == 1){
                String paramValue = paramValues[0];
                if(paramValue.length() == 0) out.println("<I>NO VALUE </I>");
                else out.println(paramValue);
            }
            else{
                out.println("<UL>");
                for(int i = 0; i < paramValues.length; i++){
                    out.println("<LI>" + paramValues[i]);
                }
                out.println("</UL>");
            }
        }
        out.println("</TABLE>\n</BODY></HTML>");
        //processRequest(request, response);
        
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
        doGet(request, response);
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
