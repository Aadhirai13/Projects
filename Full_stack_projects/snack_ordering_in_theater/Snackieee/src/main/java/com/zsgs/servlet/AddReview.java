package com.zsgs.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zsgs.account.AccountViewModel;
import com.zsgs.orders.OrdersViewModel;

@WebServlet("/addReview")
public class AddReview extends HttpServlet {
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
		
		int snack_id = Integer.parseInt(req.getParameter("snack_id"));
		String review = req.getParameter("review");
		
		boolean isSnacksAdded = OrdersViewModel.getInstance().addReview(mailId,snack_id,review);
		out.println(isSnacksAdded);
	}
}
