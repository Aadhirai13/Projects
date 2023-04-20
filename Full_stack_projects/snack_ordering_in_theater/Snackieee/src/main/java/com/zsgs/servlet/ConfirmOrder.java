package com.zsgs.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zsgs.cart.CartViewModel;
import com.zsgs.orders.OrdersViewModel;

@WebServlet("/confirmorder")
public class ConfirmOrder extends HttpServlet {
	public void doPost (HttpServletRequest req , HttpServletResponse res) throws IOException {
		PrintWriter out = res.getWriter();
		
		HttpSession session = req.getSession(false);
		String mailId = (String)session.getAttribute("mail");
		
		String rowno = req.getParameter("rowno");
		int seatno = Integer.parseInt(req.getParameter("seatno"));
		String amounttopay = req.getParameter("amounttopay");
		
		boolean isOrderPlaced = OrdersViewModel.getInstance().orderItems(mailId, rowno, seatno, amounttopay);
		out.println(isOrderPlaced);
	}
}
