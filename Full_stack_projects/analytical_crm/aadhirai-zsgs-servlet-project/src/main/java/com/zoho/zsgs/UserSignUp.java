package com.zoho.zsgs;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zoho.zsgs.accounts.AccountsViewModel;
import com.zoho.zsgs.users.UsersViewModel;

@WebServlet("/usersignup")
public class UserSignUp extends HttpServlet {

	public void service(HttpServletRequest req , HttpServletResponse res) throws IOException {
		String userName = req.getParameter("username");
		String mobileNumber = req.getParameter("mobilenumber");
		
		
		HttpSession session = req.getSession();
		
		boolean isMobileNumberValid = UsersViewModel.getInstance().checkMobileNumberValid(mobileNumber);
		if(isMobileNumberValid) {
		boolean isExistingUser = UsersViewModel.getInstance().userSignUp(userName,mobileNumber);
		if(isExistingUser) {
			session.setAttribute("fail", "User already exist");
			res.sendRedirect("usersignup.jsp");
			return;
		}
		else {
			res.sendRedirect("userslogin.jsp");
			return;
		}
		}
		else {
			res.sendRedirect("usersignup.jsp");
			session.setAttribute("fail", "invalid mobile number");
		}
	}
}
