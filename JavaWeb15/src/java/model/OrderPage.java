/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.ShoppingCart;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.text.NumberFormat;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author vutrunganh
 */
@WebServlet(name = "OrderPage", urlPatterns = {"/OrderPage"})
public class OrderPage extends HttpServlet {

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
            out.println("<title>Servlet OrderPage</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet OrderPage at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        ShoppingCart cart;
        synchronized (session) {
            cart = (ShoppingCart) session.getAttribute("shoppingCart");
            if (cart == null) {
                cart = new ShoppingCart();
                session.setAttribute("shoppingCart", cart);
            }
            if (request.getParameter("itemID") != null) {
                String numItemsString
                        = request.getParameter("numItems");
                if (numItemsString == null) {
                    cart.addItem(request.getParameter("itemID"));
                } else {
                    int numItems;
                    try {
                        numItems = Integer.parseInt(numItemsString);
                    } catch (NumberFormatException nfe) {
                        numItems = 1;
                    }
                    cart.setNumOrdered(request.getParameter("itemID"), numItems);
                }
            }
        }
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String title = "Status of Your Order";
        String docType
                = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 "
                + "Transitional//EN\">\n";
        out.println(docType
                + "<HTML>\n"
                + "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n"
                + "<BODY BGCOLOR=\"#FDF5E6\">\n"
                + "<H1 ALIGN=\"CENTER\">" + title + "</H1>");
        synchronized (session) {
            List itemsOrdered;
            itemsOrdered = cart.getItemsOrdered();
            if (itemsOrdered.size() == 0) {
                out.println("<H2><I>No items in your cart...</I></H2>");
            } else {
                out.println("<TABLE BORDER=1 ALIGN=\"CENTER\">\n"
                        + "<TR BGCOLOR=\"#FFAD00\">\n"
                        + " <TH>Item ID<TH>Description\n"
                        + " <TH>Unit Cost<TH>Number<TH>Total Cost");
                String itemID = request.getParameter("itemID");

                ItemOrder order;
                NumberFormat formatter
                        = NumberFormat.getCurrencyInstance();
                for (int i = 0; i < itemsOrdered.size(); i++) {
                    order = (ItemOrder) itemsOrdered.get(i);
                    out.println("<TR>\n"
                            + " <TD>" + order.getItemID() + "\n"
                            + " <TD>" + order.getShortDescription() + "\n"
                            + " <TD>"
                            + formatter.format(order.getUnitCost()) + "\n"
                            + " <TD>"
                            + "<FORM>\n"
                            + // Submit to current URL
                            "<INPUT TYPE=\"HIDDEN\" NAME=\"itemID\"\n"
                            + "VALUE =\"" + order.getItemID() + "\">\n"
                            + "<INPUT TYPE=\"TEXT\" NAME=\"numItems\"\n"
                            + "SIZE = 3 VALUE =\""
                            + order.getNumItems() + "\">\n"
                            + "<SMALL>\n"
                            + "<INPUT TYPE=\"SUBMIT\"\n "
                            + "VALUE =\"Update Order\">\n"
                            + "</SMALL>\n"
                            + "</FORM>\n"
                            + " <TD>"
                            + formatter.format(order.getTotalCost())
                
                
                );
                }
                String checkoutURL
                        = response.encodeURL("Checkout.html");
                out.println("</TABLE>\n"
                        + "<FORM ACTION=\"" + checkoutURL + "\">\n"
                        + "<BIG><CENTER>\n"
                        + "<INPUT TYPE=\"SUBMIT\"\n"
                        + "VALUE =\"Proceed to Checkout\">\n"
                        + "</CENTER></BIG></FORM>");
            }
            out.println("</BODY></HTML>");

        }
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
        protected void doPost
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo
        
            () {
        return "Short description";
        }// </editor-fold>

    }
