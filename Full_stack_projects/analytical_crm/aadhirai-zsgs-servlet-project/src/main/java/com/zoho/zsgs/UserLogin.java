package com.zoho.zsgs;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zoho.zsgs.users.UsersViewModel;


@WebServlet("/userlogin")
public class UserLogin extends HttpServlet {

	public void service(HttpServletRequest req , HttpServletResponse res) throws IOException {
		String userName = req.getParameter("username");
		String mobileNumber = req.getParameter("mobilenumber");
		boolean isExistingUser = UsersViewModel.getInstance().validateUserCredentials(userName,mobileNumber);
		
		HttpSession session = req.getSession();
		
		if(isExistingUser) {
			boolean isLead = UsersViewModel.getInstance().isLead(mobileNumber);
			if(isLead) {
				res.sendRedirect("usercallinfo.jsp");
				return;
			}
			else {
				res.sendRedirect("contactdealinfo.jsp");
				return;
			}
		}
		else {
			session.setAttribute("fail", "Invalid credentials");
			res.sendRedirect("userslogin.jsp");
			return;
		}
	}
}
