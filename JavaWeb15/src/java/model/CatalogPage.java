/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vutrunganh
 */
@WebServlet(name = "CatalogPage", urlPatterns = {"/CatalogPage"})
public class CatalogPage extends HttpServlet {

    private CatalogItem[] items;
    private String[] itemIDs;
    private String title;

    protected void setItems(String[] itemIDs) {
        this.itemIDs = itemIDs;
        items = new CatalogItem[itemIDs.length];
        for (int i = 0; i < items.length; i++) {
            items[i] = Catalog.getItem(itemIDs[i]);
        }
    }

    protected void setTitle(String title) {
        this.title = title;
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
        if (items == null) {
            response.sendError(response.SC_NOT_FOUND,
                    "Missing Items.");
            return;
        }
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String docType
                = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 "
                + "Transitional//EN\">\n";
        out.println(docType
                + "<HTML>\n"
                + "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n"
                + "<BODY BGCOLOR=\"#FDF5E6\">\n"
                + "<H1 ALIGN=\"CENTER\">" + title + "</H1>");
        CatalogItem item;
        for (int i = 0; i < items.length; i++) {
            out.println("<HR>");
            item = items[i];
            // Show error message if subclass lists item ID
            // that's not in the catalog.
            if (item == null) {
                out.println("<FONT COLOR=\"RED\">"
                        + "Unknown item ID " + itemIDs[i]
                        + "</FONT>");
            } else {
                out.println();
                String formURL = "OrderPage";
                // Pass URLs that reference own site through encodeURL.
                formURL = response.encodeURL(formURL);
                out.println("<FORM ACTION=\"" + formURL + "\">\n"
                        + "<INPUT TYPE=\"HIDDEN\" NAME=\"itemID\" "
                        + "       VALUE=\"" + item.getItemID() + "\">\n"
                        + "<H2>" + item.getShortDescription()
                        + " ($" + item.getCost() + ")</H2>\n"
                        + item.getLongDescription() + "\n"
                        + "<P>\n<CENTER>\n"
                        + "<INPUT TYPE=\"SUBMIT\" "
                        + "VALUE=\"Add to Shopping Cart\">\n"
                        + "</CENTER>\n<P>\n</FORM>");
            }
        }
        out.println("<HR>\n</BODY></HTML>");

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
        //processRequest(request, response);
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
