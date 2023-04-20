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

@WebFilter(urlPatterns = { "/userlogin" })
public class ExistingUser implements Filter {

	public ExistingUser() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String pass = request.getParameter("password");

		PrintWriter out = response.getWriter();

		if (!Verification.pass(pass)) {
			out.print(-2);
			return;
		}

		String mail = request.getParameter("mailid");

		if (!Verification.validateMail(mail)) {
			out.print(-3);
			return;
		}

		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}