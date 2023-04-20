package com.zoho.zsgs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.parser.ParseException;

import com.zoho.zsgs.accounts.AccountsViewModel;

@WebServlet("/accountlogin")
public class AccountsLogin extends HttpServlet {
	
	public void service(HttpServletRequest req , HttpServletResponse res) throws IOException {
		String userName = req.getParameter("accountsname");
		String password = req.getParameter("accountsnumber");
		
		PrintWriter out = res.getWriter();
		
		
		HttpSession session = req.getSession();
		
		boolean isMobileNumberValid = AccountsViewModel.getInstance().checkMobileNumberValid(password);
		if(isMobileNumberValid) {
			boolean isValid = AccountsViewModel.getInstance().validateAccountsCredentials(userName, password);
			if(isValid) {
				res.sendRedirect("accountspage.jsp");
				return;
			}
			else {
				res.sendRedirect("accountslogin.jsp");
				session.setAttribute("fail", "Invalid Credentials");
				return;
			}
		}
		else {
			res.sendRedirect("accountslogin.jsp");
			session.setAttribute("fail", "invalid mobile number");
		}
		
		
		
	}
}
