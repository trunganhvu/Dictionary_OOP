/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filters;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *
 * @author vutrunganh
 */
public class MyFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //Filter.super.init(filterConfig); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        String name = request.getParameter("username");
        String pass = request.getParameter("password");
        if (name.equals("admin") && pass.equals("admin")){
            chain.doFilter(request, response);
        }
        else {
            out.print("username or password have a error");
            RequestDispatcher rd = request.getRequestDispatcher("indexLogin.html");
            rd.forward(request, response);
        }
    }

    @Override
    public void destroy() {
        //Filter.super.destroy(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
