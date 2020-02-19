/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;

/**
 *
 * @author vutrunganh
 */
public class MyFilter implements Filter{

    
    public void init(FilterConfig arg0) throws ServletException {}  
    public void destroy() {}  
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        out.println("filter before");
        
        chain.doFilter(request, response);
        
        out.println("filter after");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
