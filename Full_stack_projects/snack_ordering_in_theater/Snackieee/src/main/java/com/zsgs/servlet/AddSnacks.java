package com.zsgs.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zsgs.account.AccountViewModel;

@WebServlet("/addsnacks")
public class AddSnacks extends HttpServlet {
	public void doPost (HttpServletRequest req , HttpServletResponse res) throws IOException {
		PrintWriter out = res.getWriter();
		
		int category_id = Integer.parseInt(req.getParameter("category_id"));
		String snack_name = req.getParameter("snack_name");
		float price = Float.parseFloat(req.getParameter("price"));
		int stock = Integer.parseInt(req.getParameter("stock"));
		String quantity = req.getParameter("quantity");
		String snack_image = req.getParameter("snack_image");
		
		boolean isSnacksAdded = AccountViewModel.getInstance().addSnacks(category_id,snack_name,price,stock,quantity,snack_image);
		out.println(isSnacksAdded);
	}
}
