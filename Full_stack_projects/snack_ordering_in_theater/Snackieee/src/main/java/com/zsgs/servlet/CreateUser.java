package com.zsgs.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zsgs.account.AccountViewModel;

@WebServlet("/createuser")
public class CreateUser extends HttpServlet {
	public void doPost (HttpServletRequest req , HttpServletResponse res) throws IOException {
		PrintWriter out = res.getWriter();
		String username = "";
		String mailid = "";
		String password = "";
		
		HttpSession session = req.getSession();
		if(session.getAttribute("mail") != null) {
			out.println(-1);
			return;
		}
		else {
			username = req.getParameter("username");
			mailid = req.getParameter("mailid");
			password = req.getParameter("password");	
		boolean isaccountCreated = AccountViewModel.getInstance().addUser(username, mailid, password);
		if(!isaccountCreated)
			session.setAttribute("mail", mailid);
		out.println(isaccountCreated);
		}
	}
}
