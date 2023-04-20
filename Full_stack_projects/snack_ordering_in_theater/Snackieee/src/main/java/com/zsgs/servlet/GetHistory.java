package com.zsgs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.zsgs.cart.CartViewModel;
import com.zsgs.home.HomeViewModel;
import com.zsgs.model.Categories;
import com.zsgs.model.OrderedItems;
import com.zsgs.orders.OrdersViewModel;

@WebServlet("/gethistory")
public class GetHistory extends HttpServlet {
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
		out.println(getHistory(mailId));
	}
	
	public JSONArray getHistory(String mailId) {
		List<OrderedItems> history = OrdersViewModel.getInstance().getHistory(mailId);

		if (history.size() == 0) {
			return null;
		}
		
		JSONArray array = new JSONArray();

		for (OrderedItems his : history) {

			JSONObject obj = new JSONObject();

			obj.put("order_id", his.getOrder_id());
			obj.put("mail_id", his.getMail_id());
			obj.put("amount_paid", his.getAmount_paid());
			obj.put("ordered_date", his.getOrdered_date()+"");
			
			array.add(obj);
		}

		return array;
	}
}
