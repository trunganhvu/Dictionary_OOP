/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import model.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vutrunganh
 */
@WebServlet(name = "Home", urlPatterns = {"/Home"})
public class Home extends HttpServlet {
    private Book[] items;
    private String[] itemIDs;
    
    protected void setItems(String[] itemIDs){
        this.itemIDs = this.itemIDs;
        items = new Book[itemIDs.length];
        for (int i = 0; i < items.length; i++){
            items[i] = BookDao.getBookById(Integer.parseInt(itemIDs[i]));
        }
    }
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
            out.println("<title>Servlet Home</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Home at " + request.getContextPath() + "</h1>");
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
        out.println("<h1>Book List</h1>");

        Book book;
        ArrayList<Book> list = BookDao.getAllBook();
        
        out.print("<table border='1' width='100%'");
        out.print("<tr><th>Id</th><th>Category</th><th>Name</th><th>Description</th><th>Content</th>"+  
                "<th>  </th><tr>");
        for (Book e : list) {
            out.print("<form action=\"OrderPage\">");
            out.print("<tr>"
                    +"<td><input type=\"HIDDEN\" name=\"itemID\" value=\""+e.getId()+"\"></td>"
                    +"<td>" + e.getCategory()+ "</td>"
                    +"<td>" + e.getName() +"</td>"
                    +"<td>" + e.getDescription()+" </td>"
                    +"<td>" +e.getContent()+"</td>"
//                    +"<td><a href='EditServlet?id="+e.getId()+"&name="+e.getId()+"'>Add to cart</a></td>"
                    +"<td><input type=\"SUBMIT\" value=\"Add to cart\"></td>"
                    +"</tr>");  
            out.print("</form>");
        }  
        out.print("</table>");
        
        out.close();
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
