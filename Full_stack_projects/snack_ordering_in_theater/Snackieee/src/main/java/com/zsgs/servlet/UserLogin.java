package com.zsgs.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zsgs.account.AccountViewModel;

@WebServlet("/userlogin")
public class UserLogin extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		PrintWriter out = res.getWriter();
		String mailid = "";
		String password = "";

		HttpSession session = req.getSession();
			mailid = req.getParameter("mailid");
			password = req.getParameter("password");
			boolean isUserLogin = AccountViewModel.getInstance().userLogin(mailid, password);
			if (isUserLogin) {
				session.setAttribute("mail", mailid);
			}
			out.println(isUserLogin);
	}
}
