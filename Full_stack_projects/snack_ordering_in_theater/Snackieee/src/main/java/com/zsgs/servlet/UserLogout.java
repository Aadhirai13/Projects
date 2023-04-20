package com.zsgs.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/userlogout")
public class UserLogout extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		PrintWriter out = res.getWriter();

		HttpSession session = req.getSession();
		if (session.getAttribute("mail") == null) {
			out.println(-1);
		} else {
			session.invalidate();
			out.println(true);
		}
	}
}
