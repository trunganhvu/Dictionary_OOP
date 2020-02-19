/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FilterInput;

import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *
 * @author vutrunganh
 */
public class TrimFilter implements Filter{
    private FilterConfig filterConfig = null;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter init");
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Filter");
        Enumeration enum1 = request.getParameterNames();
        while(enum1.hasMoreElements()){
            String name =(String) enum1.nextElement();
            String value = request.getParameter(name);
            request.setAttribute(name, value.trim());
            
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("filter dostroy");
        this.filterConfig = null;
    }
    
}
