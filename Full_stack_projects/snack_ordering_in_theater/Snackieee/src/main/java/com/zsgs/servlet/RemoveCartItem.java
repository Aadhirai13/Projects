package com.zsgs.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zsgs.cart.CartViewModel;

@WebServlet("/removecartitem")
public class RemoveCartItem extends HttpServlet {
	public void doPost (HttpServletRequest req , HttpServletResponse res) throws IOException {
		PrintWriter out = res.getWriter();
		
		int snackid = Integer.parseInt(req.getParameter("snackid"));
		HttpSession session = req.getSession();
		String mailId = (String)session.getAttribute("mail");

		out.println(CartViewModel.getInstance().removeFromCart(mailId, snackid));
	}
}
