/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.util.*;
import javax.servlet.*;

/**
 *
 * @author vutrunganh
 */
public class UpperCaseFilter implements Filter{
    private FilterConfig filterConfig = null;
    public void destroy(){
        System.out.println("Filter destroy");
        this.filterConfig = null;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter hello");
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Filter");
        Enumeration enum1 = request.getAttributeNames();
        while (enum1.hasMoreElements()){
            String attributeName = (String) enum1.nextElement();
            String attributeValue = (String) request.getAttribute(attributeName);
            request.setAttribute(attributeName, attributeValue.toUpperCase());
        }
        chain.doFilter(request, response);
    }
}
