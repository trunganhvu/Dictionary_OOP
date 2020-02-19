/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pagination;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.OverridesAttribute.List;

/**
 *
 * @author vutrunganh
 */
@WebServlet(name = "ViewServletPages", urlPatterns = {"/ViewServletPages"})
//@WebFilter(filterName = "f1")
public class ViewServletPages extends HttpServlet {
    private static final long serialVersionUID = 1L;  
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

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
        PrintWriter out=response.getWriter();  
          
        String spageid=request.getParameter("page");  
        int pageid=Integer.parseInt(spageid);  
        int total=5;  
        if(pageid==1){}  
        else{  
            pageid=pageid-1;  
            pageid=pageid*total+1;  
            
        }  
        ArrayList<Emp> list=EmpDao.getRecords(pageid,total);  
  
        out.print("<h1>Page No: "+spageid+"</h1>");  
        out.print("<table border='1' cellpadding='4' width='60%'>");  
        out.print("<tr><th>Id</th><th>Name</th><th>Salary</th>");  
        for(Emp e:list){  
            out.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getSalary()+"</td></tr>");  
        }  
        out.print("</table>");  
          
        out.print("<a href='ViewServletPages?page=1'>1</a> ");  
        out.print("<a href='ViewServletPages?page=2'>2</a> ");  
        out.print("<a href='ViewServletPages?page=3'>3</a> ");  
          
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
