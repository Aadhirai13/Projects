package com.zsgs.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(urlPatterns = { "/createuser" })
public class NewUserFilter implements Filter {

	public NewUserFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
	
		String name = request.getParameter("username");

		PrintWriter out = response.getWriter();
		
		if (!Verification.name(name)) {
			out.print(-2);
			return;
		}

		String pass = request.getParameter("password");	

		if (!Verification.pass(pass)) {
			out.print(-3);
			return;
		}
		
		if(pass.contains(" ")) {
			out.print(-4);
			return;
		}

		String mail = request.getParameter("mailid");
		
		if (!Verification.validateMail(mail)) {
			out.print(-5);
			return;
		}
		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}