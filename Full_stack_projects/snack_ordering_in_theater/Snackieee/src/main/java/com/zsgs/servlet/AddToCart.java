package com.zsgs.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.zsgs.cart.CartViewModel;

@WebServlet("/addtocart")
public class AddToCart extends HttpServlet {
	public void doPost (HttpServletRequest req , HttpServletResponse res) throws IOException {
		PrintWriter out = res.getWriter();
		String mailId = "";
		
		HttpSession session = req.getSession();
		if(session.getAttribute("mail") == null) {
			out.println(-1);
			return;
		}
		else {
			mailId = (String)session.getAttribute("mail");
		}
		
		int itemcount = Integer.parseInt(req.getParameter("itemcount"));
		int snackid = Integer.parseInt(req.getParameter("snackid"));
		
		boolean isCartCountValid = CartViewModel.getInstance().addToCart(mailId, snackid, itemcount);
		out.println(isCartCountValid);
	}
}
