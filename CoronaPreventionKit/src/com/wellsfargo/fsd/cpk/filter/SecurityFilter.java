package com.wellsfargo.fsd.cpk.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.DispatcherType;

/**
 * Servlet Filter implementation class SecurityFilter
 */

//@WebFilter({"/newproduct.jsp","/list","/editproduct.jsp","/addProduct","/editProduct","deleteProduct"})
@WebFilter(urlPatterns="/*",dispatcherTypes= {DispatcherType.FORWARD,DispatcherType.REQUEST})
public class SecurityFilter implements Filter {

    /**
     * Default constructor. 
     */
    public SecurityFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		        HttpServletRequest httpRequest = (HttpServletRequest) request;
		        HttpSession session = httpRequest.getSession(false);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("notfound.jsp");
		        request.setAttribute("errMsgNotAuth", "Sorry! You are not authorized to view this page.");
		        
		        //Security Filter for admin pages
		        if(httpRequest.getRequestURI().contains("admin")) {
		        	System.out.println("Filter");
		        	if(session==null)	        			        	 
		             dispatcher.forward(request, response);	        	
		        	else {
		        		String sessionUser=(String)session.getAttribute("user");
		        		if(sessionUser==null)
		        			dispatcher.forward(request, response);
		        		else if(!sessionUser.equals("Admin"))
		        			dispatcher.forward(request, response);
		        	}
		        }
		        
		        //Filter to terminate sessions after index page to terminate invalid sessions
		        if(httpRequest.getRequestURI().contains("index.jsp")) {
		        	if(session!=null)
		        	session.invalidate();
		        }
		        	chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
