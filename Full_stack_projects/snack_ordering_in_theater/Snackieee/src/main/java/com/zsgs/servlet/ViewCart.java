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
import com.zsgs.model.CartItems;
import com.zsgs.model.Categories;

@WebServlet("/viewcart")
public class ViewCart extends HttpServlet {
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
			out.println(getcart(mailId));
		}
	}

	private List<CartItems> getcart(String mailId) {
		List<CartItems> cartItems = CartViewModel.getInstance().getCartItems(mailId);

		if (cartItems.size() == 0) {
			return null;
		}

		JSONArray array = new JSONArray();

		for (CartItems items : cartItems) {

			JSONObject obj = new JSONObject();

			obj.put("snackname", items.getSnack_name());
			obj.put("snackprice", items.getSnack_amount());
			obj.put("snackquantity", items.getItem_count());
			obj.put("snacktotalprice", items.getTotal_price());
			obj.put("snack_tax", items.getTax_amount());
			obj.put("snack_id", items.getSnack_id());

			array.add(obj);
		}

		return array;
	}
}
