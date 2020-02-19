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
@WebServlet(name = "KidsBooksPage", urlPatterns = {"/KidsBooksPage"})
public class KidsBooksPage extends CatalogPage {

    public void init() {
        String[] ids = {"lewis001", "alexander001", "rowling001"};
        setItems(ids);
        setTitle("All-Time Best Children's Fantasy Books");
    }

}
