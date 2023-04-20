package com.zsgs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.zsgs.orders.OrdersViewModel;

@WebServlet("/showreview")
public class ShowReview extends HttpServlet {
	public void doPost (HttpServletRequest req , HttpServletResponse res) throws IOException {
		PrintWriter out = res.getWriter();
		
		int snackid = Integer.parseInt(req.getParameter("snackid"));
		out.println(getReview(snackid));
	}
	
	public JSONArray getReview(int snackid) {
		List<String> reviews = OrdersViewModel.getInstance().getReviews(snackid);

		if (reviews.size() == 0) {
			return null;
		}
		
		JSONArray array = new JSONArray();

		for (String review : reviews) {

			JSONObject obj = new JSONObject();

			obj.put("review", review);
			
			array.add(obj);
		}

		return array;
	}
}
